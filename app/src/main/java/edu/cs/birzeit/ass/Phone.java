package edu.cs.birzeit.ass;

public class Phone {
    private String phoneName;
    private String screenSize;
    private String operatingSystem;
    private String battery;
    private String Memory;
    private String weight;

    public Phone(String phoneName, String screenSize, String operatingSystem, String battery, String memory, String weight) {
        this.phoneName = phoneName;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.battery = battery;
        Memory = memory;
        this.weight = weight;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
