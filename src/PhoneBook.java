import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<Contact>> storage = new HashMap<>();

    public boolean addGroup(String groupName) {
        if (storage.containsKey(groupName))
            return false;
        storage.put(groupName, new ArrayList<>());
        return true;
    }

    public boolean addContactToGroups(Contact contact, String... groups) {
        for (String group : groups) {
            if (!storage.containsKey(group))
                return false;
            storage.get(group).add(contact);
        }
        return true;
    }

    public List<Contact> findContactsByGroups(String groupName) {
        return storage.get(groupName);
    }

    public Contact findContactByPhone(String phoneNumber) {
        for (List<Contact> groupContacts : storage.values()) {
            for (Contact contact : groupContacts) {
                if (contact.getPhone().equals(phoneNumber))
                    return contact;
            }
        }
        return null;
    }

    public static Contact createContact(String name, String phone) {
        return new Contact(name, phone);
    }


}

