package org.example.buoi3.outputs;

public class StoreDataOutput {
    private String name;
    private String address;
    private Double rate;

    public StoreDataOutput(String name, String address, Double rate) {

        this.name = name;
        this.address = address;
        this.rate = rate;
    }

    public StoreDataOutput() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
