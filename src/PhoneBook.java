import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, Contact> storage = new HashMap<>();


    public boolean addContact(Contact contact) {
        if (storage.containsKey(contact.getPhone()))
            return false;
        storage.put(contact.getPhone(), contact);
        return true;
    }


    public Contact findContactByPhone(String phoneNumber) {
        return storage.get(phoneNumber);
    }

    public static Contact createContact(String name, String phone) {
        return new Contact(name, phone);
    }


}

