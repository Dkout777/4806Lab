package main;

import javax.persistence.*;
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name;
    private String address;
    private String phoneNum;
    @ManyToOne
    private AddressBook addressBook;
    protected BuddyInfo(){ }
    public BuddyInfo (String name, String address, String phoneNum, AddressBook addressBook){
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.id = null;
        this.addressBook = addressBook;
    }
    @Override
    public String toString() {
        return String.format(
                "Buddy[id=%d, firstName='%s', Address='%s',  phonenum='%s]",
                id, name, address, phoneNum);
    }
    public  void printBuddy() {
        System.out.println("name: " + name + " address: " +address + " phone: " + phoneNum );
    }
    public String getName() { return name; }
    public String getAddress() {
        return address;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AddressBook getAddressBook() { return addressBook; }
    public void setAddressBook(AddressBook addressBook) { this.addressBook = addressBook; }

}