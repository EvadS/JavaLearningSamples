package som.se.company.app;

public class IOUFlow {

    CarState carValue;
    String otherParty ;


    public IOUFlow() {
    }

    public IOUFlow(CarState carValue, String otherParty) {
        this.carValue = carValue;
        this.otherParty = otherParty;
    }

    public CarState getCarValue() {
        return carValue;
    }

    public void setCarValue(CarState carValue) {
        this.carValue = carValue;
    }

    public String getOtherParty() {
        return otherParty;
    }

    public void setOtherParty(String otherParty) {
        this.otherParty = otherParty;
    }
}
