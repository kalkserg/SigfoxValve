package ua.utilix.model;

import org.springframework.stereotype.Component;

@Component
public class SigfoxData implements Sigfox {
    private String id;
    private Sigfox strategy;
    private int state;
    private float batteryPower;
    private String message;


    public float getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = (float) batteryPower / 1000;
    }


    public Sigfox getStrategy() {
        return strategy;
    }

    public void setStrategy(Sigfox strategy) {
        this.strategy = strategy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
