//Taylan Unal APCS 2016
public class LightBulb {
    private boolean isTurnedOn;  //true of on, false if off
    private String type;

    public LightBulb() {
        type = "LED";
        isTurnedOn = false;
    }

    //*******FINISH THE TWO METHODS BELOW******************************************************
    //post: notifies the caller of the method of the state of the bulb
    public boolean isOn() {
        return isTurnedOn;
    }

    //post:  reverses the state of the bulb
    public void pullString() {
        isTurnedOn = !isTurnedOn;
    }
    //******************************************************************************************
}
