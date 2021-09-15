package ua.utilix.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.tempuri.WebService;
import ua.tempuri.WebServiceSoap;
import ua.utilix.model.DataValveKVK;
import ua.utilix.model.Device;
import ua.utilix.model.SigfoxData;
import ua.utilix.model.SigfoxParser;
import ua.utilix.service.DeviceService;
import ua.utilix.service.SendMessageService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.TimeZone;

@Controller
public class myController {

    String messageIn = "";
    String messageOut = "";
    private DeviceService deviceService;
    private SendMessageService sendMessageService;

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Autowired
    public void setLocationService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    @PostMapping(produces = "application/json")
    public ResponseEntity<String> postBody(@RequestBody(required = false) String str, Model model) {
//        System.out.println("receive post  " + str);

        JSONObject obj = new JSONObject(str);

        String sigfoxId = obj.getString("device");
        String unixTime = obj.getString("time");
        String data = obj.getString("data");
        int seqNumber = obj.getInt("seqNumber");

//        System.out.println("sigfoxId  " + sigfoxId);

        SigfoxData sigfoxData = null;
        SigfoxParser sigfoxParser = new SigfoxParser();

        messageIn = messageIn + str;

        Device device = null;

        try {
            device = deviceService.findBySigfoxId(sigfoxId);
        } catch (Exception e) {
            System.err.println("Error find SigfoxId!");
        }
//        System.out.println("findDevice " + device);

        if (device != null) {

//            System.out.println(sigfoxId);
//            System.out.println(data);
//            System.out.println(device.getProtocol());
//            System.out.println(seqNumber);

            try {
                sigfoxData = sigfoxParser.getData(sigfoxId, data, device.getProtocol(), seqNumber);

                //update DB
                device.setPowerVoltage(sigfoxData.getBatteryPower());
                device.setValveStatus(sigfoxData.getState()==0?0:100);
                deviceService.updateDevice(device);

                //make request vodokanal
                LinkedList<DataValveKVK> listDataValveKVK = new LinkedList<>(); //Linked list to send data to KVK
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                int[] invalidids = new int[0];
                boolean success;

                DataValveKVK datakvk = new DataValveKVK();
                datakvk.ID = device.getKvk_id();
                datakvk.PRC_P = device.getValveStatus();
                listDataValveKVK.add(datakvk); //adding data to listDataValve

                String dataJson = gson.toJson(listDataValveKVK);

                dataJson = dataJson.replace("\"PRC_P\":", "\"PRC\":");
                String dataResult = "{\"JSONS\":" + dataJson + "}"; //Generating JSON from listDataValve for KVK

                System.out.println("Sending current valve positions to KVK:");
                System.out.println(dataResult);

                //Login KVK server
                WebService service = new WebService();
                WebServiceSoap port = service.getWebServiceSoap();

                /*

                //Get new ticket
                String ticket = null;
                try {
                    RestHelper restProvider = new RestHelper("getticket", "http://personal.utilix.one:8080/resourcesmanager");
                    ticket = restProvider.getKVKTicket();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                if (ticket!=null) {
                    System.out.println("Get ticket successful. Ticket:" + ticket);
                    String response0 = port.executeEx("_ACCXB.GETERRORS", dataResult, ticket); //Get error codes
                    System.out.println("KVK error codes dictionary: (just for information)");
                    System.out.println(response0);
                } else {
                    System.out.println("Login to KVK failed. Data will not be sent.");
                    //System.out.println(resp.FailReason);
                    System.exit(1);
                }
                */

                //Connect to KVK_TEST to get Valve positions
                String response = port.loginEx("QWERTY_SANITECH", "123456"); //Loging into server TEST!!!!
                LoginExResponseObj resp = gson.fromJson(response, LoginExResponseObj.class); //Parsing response

                //if there is something in listDataValve and login success
                if ((listDataValveKVK.size() > 0) & (resp.Success)) {
                    //if ((listDataValve.size()>0) & (ticket!=null)) {
                    System.out.println("Receive valves positions from KVK:");
                    String response1 = port.executeEx("_ACCXB.SENDVALVEDATA", dataResult, resp.Ticket); //Send values
                    //String response1 = port.executeEx("_ACCXB.SENDVALVEDATA", dataResult, ticket); //Send values
                    System.out.println(response1);
                    System.out.println();
                    response1 = response1.replace("INVALID IDS", "INVALIDIDS");
                    ValveResponseObj resp1 = gson.fromJson(response1, ValveResponseObj.class); //Parsing response1
                    success = resp1.SUCCESS;
                    DataValveKVK[] dataValves = resp1.DATA;
                    invalidids = resp1.INVALIDIDS;
                    if (success) {
                        for (DataValveKVK res : dataValves) {
                            if (device.getKvk_id() == res.ID) {
                                if(device.getValveStatus()!=res.PRC_P) { device.setValveStatus(res.PRC_P); deviceService.updateDevice(device);}
                            }
                        }
                    }
                }
                System.out.println("DOWNLINK");
                //downlink always
                SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHHmm");
                formatter.setTimeZone(TimeZone.getTimeZone("GMT+3"));
                Date now = new Date();
                String downlinkData = formatter.format(now) + String.format("%02d", device.getSession_time()) + String.format("%02d", device.getValveStatus()==0?0:1) + "00";
                messageOut = "{ \"" + sigfoxId + "\": {\"downlinkData\" : \"" + downlinkData + "\" }}";


                //TEST------------------------------------
                SimpleDateFormat formatterhh = new SimpleDateFormat("HH");
                formatter.setTimeZone(TimeZone.getTimeZone("GMT+3"));
                formatterhh.setTimeZone(TimeZone.getTimeZone("GMT+3"));
                downlinkData = formatter.format(now) + String.format("%02d", Integer.parseInt(formatterhh.format(now))+1) + String.format("%02d", sigfoxData.getState()==0?1:0) + "00";
                messageOut = "{ \"" + sigfoxId + "\": {\"downlinkData\" : \"" + downlinkData + "\" }}";
                //--------------------------------------------------------------------------------------

                System.out.println(messageOut);
                return new ResponseEntity<String>(messageOut, HttpStatus.OK);
            } catch (Exception e) {
                System.err.println(e.getMessage());


            }


        } //device != null

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping
    public String getBody(@RequestBody(required = false) String str, Model model) {
//        System.out.println("GET " + messageIn);
//        System.out.println("GET " + messageOut);
        model.addAttribute("str", messageIn + "  " +  messageOut);
        return "byby";
    }

        //    @ResponseBody
//    @GetMapping(path = "/api/users")
//    public List<User> listUsers() {
//        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
////        System.out.println(userService.findAllUsers());
//        return userService.findAllUsers();
//    }
//
//    @GetMapping(path = "/api/byby")
//    public String listUsers2(
//            @RequestParam(name = "name", required = false, defaultValue = "нету юзеров") String name, Model model
//    ) {
//        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
//        name = userService.findAllUsers().toString();
//        model.addAttribute("name", name);// = userService.findAllUsers().toString();
//        return "byby";
//    }

//
//    @GetMapping
//    public List<User> listUsers1() {
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        return userService.findAllUsers();
//    }


//    @GetMapping(path = "/api/users")
//    public ResponseEntity<?> listUsers() {
////        log.info("UsersController:  list users");
//        List<User> resource = userService.findAllUsers();
//        return ResponseEntity.ok(resource);
//    }

//    @PostMapping(path = UserLinks.ADD_USER)
//    public ResponseEntity<?> saveUser(@RequestBody Users user) {
//        log.info("UsersController:  list users");
//        Users resource = usersService.saveUser(user);
//        return ResponseEntity.ok(resource);
//    }

//
//    private byte[] intToByte(int num) {
//        byte[] bytes = new byte[4];
//        String str = String.valueOf(num);
//        for (int i = 0; i < 4; i++) {
//            bytes[i] = (byte) str.charAt(i);
//            //bytes[i] = (byte)(num >>> (i * 8));
//            System.out.println(num + " " + bytes[i]);
//        }
//        return bytes;
//    }

} //myController

class LoginExResponseObj {//Object that returns on login to kvk server
    public boolean Success;
    public String UserName;
    public String Ticket;
    public String FailReason;
    public boolean NeedChangePassword;
    public boolean TempPasswordRequired;
    public String TempPasswordMessage;
}

class ValveResponseObj {//Object that returns on login to kvk server
    public boolean SUCCESS;
    public int[] INVALIDIDS;
    public DataValveKVK[] DATA;
}
