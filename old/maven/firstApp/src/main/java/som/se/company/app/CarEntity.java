package som.se.company.app;

public class CarEntity {

    String referenceNumber;
    String model;
    Float weight;
    Double amount;

    public CarEntity() {
    }

    public CarEntity(String referenceNumber, String model, Float weight, Double amount) {
        this.referenceNumber = referenceNumber;
        this.model = model;
        this.weight = weight;
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
