package ua.utilix.model.strategy;

import ua.utilix.model.SigfoxData;


public class AndryStrategy extends DefaultStrategy {

    public AndryStrategy(SigfoxData sigfoxData) {
        super(sigfoxData);
    }

    public SigfoxData parse(String id, String input, int sequence) {

        if(input.length() == 8) {
            sigfoxData.setState(Integer.parseInt(input.substring(6,2)));
            sigfoxData.setBatteryPower(Integer.parseInt(input.substring(2,4)));
        }else{
            sigfoxData.setState(Integer.parseInt(input.substring(4,2)));
            sigfoxData.setBatteryPower(Integer.parseInt(input.substring(0,4)));
        }
        sigfoxData.setId(id);
        sigfoxData.setMessage(input);

        return sigfoxData;
    }
}
