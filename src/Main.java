import java.util.List;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        addGroup(phoneBook, "Family", "Friends", "Work");
        addContact(phoneBook);

        System.out.println("Поиск контакта по номеру 555 485 357\n" + phoneBook.findContactByPhone("555 485 357"));

        final List<Contact> family = phoneBook.findContactsByGroups("Family");
        System.out.println("\nПоиск контактов в группе Family:");
        for (Contact contact : family) {
            System.out.println(contact);
        }

    }

    private static void addGroup(PhoneBook phoneBook, String... groups) {
        for (String group : groups) {
            phoneBook.addGroup(group);
        }
    }

    private static void addContact(PhoneBook phoneBook) {
        final Contact todd = PhoneBook.createContact("Todd", "555 235 158");
        phoneBook.addContactToGroups(todd, "Family", "Work");

        final Contact sam = PhoneBook.createContact("Sam", "555 015 258");
        phoneBook.addContactToGroups(sam, "Friends", "Work");

        final Contact michiel = PhoneBook.createContact("Michiel", "555 485 357");
        phoneBook.addContactToGroups(michiel, "Work");

        final Contact mike = PhoneBook.createContact("Mike", "555 999 585");
        phoneBook.addContactToGroups(mike, "Family", "Friends", "Work");


    }


}

