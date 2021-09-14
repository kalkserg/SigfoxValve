package ua.utilix.model.strategy;

import ua.utilix.model.Sigfox;
import ua.utilix.model.SigfoxData;

public class DefaultStrategy implements Sigfox {

    SigfoxData sigfoxData;

    public DefaultStrategy(SigfoxData sigfoxData) {
        this.sigfoxData = sigfoxData;
        sigfoxData.setState(0);
    }

}
