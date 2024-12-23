import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	private String name;
	ArrayList<Contact> contacts;
    public AddressBook(String name) {
    	this.name = name;
        this.contacts = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public List<Contact> getContacts() {
        return contacts;
    }


    public void addContact(Contact contact) {
        if (contacts.stream().anyMatch(c -> c.equals(contact))) {
            System.out.println("Contact already exists!");
            return;
        }
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
    public boolean deleteContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && 
                contact.getLastName().equalsIgnoreCase(lastName)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
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
        contacts.forEach(System.out::println);
    }
    public void sortContactsByName() {
        contacts.stream()
                .sorted(Comparator.comparing(contact -> contact.getFirstName().toLowerCase()))
                .forEach(System.out::println);
    }

}
