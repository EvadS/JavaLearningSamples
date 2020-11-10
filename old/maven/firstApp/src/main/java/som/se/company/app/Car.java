package som.se.company.app;

public class Car {

    String model;
    Double weight;
    Double cost;
    String referenceNumber;

    public Car() {
    }

    public Car(String model, Double weight, Double cost, String referenceNumber) {
        this.model = model;
        this.weight = weight;
        this.cost = cost;
        this.referenceNumber = referenceNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
