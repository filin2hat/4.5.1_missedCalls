import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        MissedCalls missedCalls = new MissedCalls(phoneBook);

        addContact(phoneBook);
        addMissedCalls(missedCalls);
        System.out.println(missedCalls);
    }

    private static void addMissedCalls(MissedCalls missedCalls) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.println("Введите пропущенные звонки.\nДля окончания введите 'END':\n");
                input = scanner.nextLine();
                if (input.equals("end")) break;
                missedCalls.addMissedCalls(input);
            }
        }
    }

    private static void addContact(PhoneBook phoneBook) {
        final Contact todd = PhoneBook.createContact("Todd", "555 222 000");
        phoneBook.addContact(todd);

        final Contact sam = PhoneBook.createContact("Sam", "555 222 111");
        phoneBook.addContact(sam);

        final Contact michiel = PhoneBook.createContact("Michiel", "555 222 222");
        phoneBook.addContact(michiel);

        final Contact mike = PhoneBook.createContact("Mike", "555 222 333");
        phoneBook.addContact(mike);
    }
}

