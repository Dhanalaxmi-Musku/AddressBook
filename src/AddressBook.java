import java.util.ArrayList;

public class AddressBook {
	private ArrayList<Contact> contacts;
    public AddressBook() {
        this.contacts = new ArrayList<>();
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the address book.");
            return;
        }
        
        System.out.println("Contacts in Address Book:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

}
