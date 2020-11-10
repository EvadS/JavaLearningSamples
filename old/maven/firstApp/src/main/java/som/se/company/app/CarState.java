package som.se.company.app;

import java.time.Instant;

public class CarState {

    Car car ;
    String seller;
    String buyer;

    Instant date ;
    String  linearId;

    public CarState(Car car, String seller, String buyer) {
        this.car = car;
        this.seller = seller;
        this.buyer = buyer;
        date  = Instant.now();
        linearId = java.util.UUID.randomUUID().toString();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}

