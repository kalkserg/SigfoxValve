package ua.utilix.model;

import ua.utilix.model.strategy.AndryStrategy;
import ua.utilix.model.strategy.DefaultStrategy;

public class SigfoxParser {

    public SigfoxData getData(String id, String input, String dev, int sequence) throws Exception {
        SigfoxData sigfoxData = new SigfoxData();
        try {
            if (dev.equals("Andry")) {
                sigfoxData.setStrategy(new AndryStrategy(sigfoxData));
                sigfoxData = sigfoxData.getStrategy().parse(id, input, sequence);
            } else {
                sigfoxData.setStrategy(new DefaultStrategy(sigfoxData));
                sigfoxData = sigfoxData.getStrategy().parse(id, input, sequence);
            }
        } catch (Exception ex) {
            throw new Exception("Error input data id: " + id);
        }
        return sigfoxData;
    }

}
