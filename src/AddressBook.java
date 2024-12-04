import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	private ArrayList<Contact> contacts;
    public AddressBook() {
        this.contacts = new ArrayList<>();
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }
    public boolean editContact(String firstName, String lastName) {
        Scanner scanner = new Scanner(System.in);
        
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && 
                contact.getLastName().equalsIgnoreCase(lastName)) {
                
                System.out.println("Current Contact Details: " + contact);
                System.out.print("Enter new address (current: " + contact.getAddress() + "): ");
                String newAddress = scanner.nextLine();
                if (!newAddress.isEmpty()) 
                	contact.setAddress(newAddress);

                System.out.print("Enter new city (current: " + contact.getCity() + "): ");
                String newCity = scanner.nextLine();
                if (!newCity.isEmpty()) 
                	contact.setCity(newCity);

                System.out.print("Enter new state (current: " + contact.getState() + "): ");
                String newState = scanner.nextLine();
                if (!newState.isEmpty()) 
                	contact.setState(newState);

                System.out.print("Enter new zip (current: " + contact.getZip() + "): ");
                String newZip = scanner.nextLine();
                if (!newZip.isEmpty()) 
                	contact.setZip(newZip);

                System.out.print("Enter new phone number (current: " + contact.getPhoneNumber() + "): ");
                String newPhone = scanner.nextLine();
                if (!newPhone.isEmpty()) 
                	contact.setPhoneNumber(newPhone);

                System.out.print("Enter new email (current: " + contact.getEmail() + "): ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty())
                	contact.setEmail(newEmail);

                System.out.println("Contact updated successfully!");
                return true;
            }
        }
        
        System.out.println("Contact not found!");
        return false;
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
