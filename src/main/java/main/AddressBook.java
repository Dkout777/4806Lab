package main;

import main.BuddyInfo;

import javax.persistence.*;
import java.util.*;
@Entity
public class AddressBook {

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<BuddyInfo> address = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id = null;
    private String name;
    protected AddressBook(){}
    public  AddressBook(String name){
        this.name = name;
    }
    public void addBuddy(BuddyInfo buddy){
        address.add(buddy);
    }
    public void removeBuddy(BuddyInfo buddy){
        address.remove(buddy);
    }
    public void  printBuddies(){
        for (BuddyInfo buddy: address) {
            buddy.printBuddy();

        }
    }
    public Set<BuddyInfo> getAddress() { return address; }
    public void setAddress(Set<BuddyInfo> address) { this.address = address; }
    public String buddyToString() {

        return (address.toString());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

}