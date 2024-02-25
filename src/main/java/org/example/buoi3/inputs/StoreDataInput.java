package org.example.buoi3.inputs;

public class StoreDataInput {
    private String name;
    private String address;

    public StoreDataInput(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public StoreDataInput() {
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

}
