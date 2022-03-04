package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewAddressBookController {
    @Autowired
    private AddressRepository repository;
    @Autowired
    private BuddyRepository buddyRepository;
    private static final String template = "Hello, %s!";
    private int selectedAddressBook;

    @PostMapping("/addaddressbook")
    public AddressBook addAddressBook(@RequestParam(value = "name", defaultValue = "World") String name){

        AddressBook newAddress = new AddressBook(name);
        return repository.save(newAddress);
        
    }
    @GetMapping("/getAddressList")
    public String addressBook(  Model model){
        String s = "";
        for (AddressBook ad: repository.findAll()){
            s = s + ad.getId() + ". "+ ad.getName() + ad.buddyToString() + "\n";
        }
        model.addAttribute("s",s);
        return "AddressList";

    }
    @GetMapping("/BuddyList")
    public String selectAddressBook(@RequestParam(value = "id") String id){
        String s = "";
        AddressBook selectedBook;
        selectedAddressBook = Integer.parseInt(id);
        selectedBook = repository.findById(selectedAddressBook);
        return selectedBook.buddyToString();

    }

    @GetMapping("/toaddressform")
    public String addressForm(Model model) {
        model.addAttribute("addressform", new AddressBook());
        return "addressform";
    }
    @PostMapping("/toaddressform")
    public String addressSubmit(@ModelAttribute AddressBook addressBook, Model model) {
        model.addAttribute("addressform", addressBook);
        repository.save(addressBook);
        return "result";
    }
    @GetMapping("/tobuddyform")
    public String buddyForm(Model model) {
        model.addAttribute("buddyform", new BuddyForm());
        return "buddyform";
    }
    @PostMapping("/tobuddyform")
    public String buddySubmit(@ModelAttribute BuddyForm buddyform, Model model) {
        model.addAttribute("buddyform", buddyform);
        String addressID = buddyform.getAddressID();
        AddressBook addressBook = repository.findById(Integer.parseInt(addressID));
        BuddyInfo add = new BuddyInfo(buddyform.getName(),buddyform.getAddress(), buddyform.getPhone(), addressBook);
        addressBook.addBuddy(add);
        buddyRepository.save(add);
        return "buddyresult";
    }
    @GetMapping("/AddBuddy")
    public String  addBuddy(@RequestParam(value = "name", defaultValue = "test") String name,
                               @RequestParam(value = "address", defaultValue = "test") String address,
                               @RequestParam(value = "phone", defaultValue = "test")String phone
    ){
        AddressBook addressBook = repository.findById(selectedAddressBook);
        BuddyInfo buddy = new BuddyInfo(name,address,phone,addressBook);
        addressBook.addBuddy(buddy);
        buddyRepository.save(buddy);
        return addressBook.buddyToString();

    }
    @GetMapping("/removeBuddy")
    public String  removeBuddy(@RequestParam(value = "id") String id
    ){
        AddressBook addressBook = repository.findById(selectedAddressBook);
        BuddyInfo buddy = buddyRepository.findById(Integer.parseInt(id));
        addressBook.removeBuddy(buddy);
        buddyRepository.delete(buddy);

        return addressBook.buddyToString();

    }
}
