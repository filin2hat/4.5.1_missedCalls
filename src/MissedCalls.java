import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    private final Map<LocalDateTime, String> storage = new TreeMap<>();
    private final PhoneBook phoneBook;

    public MissedCalls(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addMissedCalls(String phone) {
        storage.put(LocalDateTime.now(), phone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<LocalDateTime, String> entry : storage.entrySet()) {
            final String phoneNumber = entry.getValue();
            final Contact contactByPhone = phoneBook.findContactByPhone(phoneNumber);
            sb.append(entry.getKey());
            sb.append(" - ");
            sb.append(contactByPhone == null ? phoneNumber : contactByPhone.getName());
            sb.append("\n");
        }
        return sb.toString();
    }

}
