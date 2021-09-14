package ua.utilix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {
    @Id
    @GeneratedValue
    private Long id;
    private String sigfoxId = "";
    private String protocol = ""; //device_type // Andry
    private int kvk_id;  //kvk_id
    private String device_location;  //device_location
    private int session_time;  //time next session
    private String meter_type;  //meter_type ControlValve = CV
    private int valveStatus; //0 = close; 100 = open;
    private float powerVoltage;

    public Device() {
    }

    public int getKvk_id() {
        return kvk_id;
    }

    public void setKvk_id(int kvk_id) {
        this.kvk_id = kvk_id;
    }

    public String getDevice_location() {
        return device_location;
    }

    public void setDevice_location(String device_location) {
        this.device_location = device_location;
    }

    public int getSession_time() {
        return session_time;
    }

    public void setSession_time(int session_time) {
        this.session_time = session_time;
    }

    public String getMeter_type() {
        return meter_type;
    }

    public void setMeter_type(String meter_type) {
        this.meter_type = meter_type;
    }

    public int getValveStatus() {
        return valveStatus;
    }

    public void setValveStatus(int valveStatus) {
        this.valveStatus = valveStatus;
    }

    public float getPowerVoltage() {
        return powerVoltage;
    }

    public void setPowerVoltage(Float powerVoltage) {
        this.powerVoltage = powerVoltage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigfoxId() {
        return sigfoxId;
    }

    public void setSigfoxId(String sigfoxId) {
        this.sigfoxId = sigfoxId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

}
