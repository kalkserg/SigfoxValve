package ua.utilix.model.strategy;

import ua.utilix.model.SigfoxData;


public class AndryStrategy extends DefaultStrategy {

    public AndryStrategy(SigfoxData sigfoxData) {
        super(sigfoxData);
    }

    public SigfoxData parse(String id, String input, int sequence) throws Exception {

        if(input.length() == 8) {
            sigfoxData.setState(Integer.parseInt(input.substring(6)));
            sigfoxData.setBatteryPower(Integer.parseInt(input.substring(2,4)));
        }else if(input.length() == 6){
            sigfoxData.setState(Integer.parseInt(input.substring(4)));
            sigfoxData.setBatteryPower(Integer.parseInt(input.substring(0,4)));
        }else{
            throw new Exception("Wrong data length! \n");
        }
        sigfoxData.setId(id);
        sigfoxData.setMessage(input);

        return sigfoxData;
    }
}
