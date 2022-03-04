package main;

public class BuddyForm {
    private String name;
    private String address;
    protected BuddyForm(){}
    public BuddyForm(String name, String address, String phone, String addressID) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        AddressID = addressID;
    }

    private String phone;
    private String AddressID;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public  String getAddressID() {
        return AddressID;
    }

    public void setAddressID(String addressID) {
        AddressID = addressID;
    }

}
