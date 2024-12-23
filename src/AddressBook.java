import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public void sortContactsByCity() {
        contacts.stream()
                .sorted(Comparator.comparing(contact -> contact.getCity().toLowerCase()))
                .forEach(System.out::println);
    }

    public void sortContactsByState() {
        contacts.stream()
                .sorted(Comparator.comparing(contact -> contact.getState().toLowerCase()))
                .forEach(System.out::println);
    }

    public void sortContactsByZip() {
        contacts.stream()
                .sorted(Comparator.comparing(contact -> contact.getZip()))
                .forEach(System.out::println);
    }
    public void displaySortedMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select sorting criteria:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by City");
        System.out.println("3. Sort by State");
        System.out.println("4. Sort by Zip");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sortContactsByName();
                break;
            case 2:
                sortContactsByCity();
                break;
            case 3:
                sortContactsByState();
                break;
            case 4:
                sortContactsByZip();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    public void writeContactsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }
            System.out.println("Contacts written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public void readContactsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                
                // Ensure there are enough parts in the array
                if (parts.length == 8) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    String address = parts[2];
                    String city = parts[3];
                    String state = parts[4];
                    String zip = parts[5];
                    String phoneNumber = parts[6];
                    String email = parts[7];
                    
                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addContact(contact);
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
            System.out.println("Contacts read from file and added to Address Book.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

}
