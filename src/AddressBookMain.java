import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	    Map<String, AddressBook> addressBooks = new HashMap<>();
	    
	    public static void main(String[] args) {
	    	Scanner scanner = new Scanner(System.in);
	    	AddressBookMain a=new AddressBookMain();
		System.out.println("Welcome to Address Book Program");
		 while (true) {
	            
	            System.out.println("\n--- Address Book System Menu ---");
	            System.out.println("1. Create New Address Book");
	            System.out.println("2. Select Address Book");
	            System.out.println("3. List All Address Books");
	            System.out.println("4. Search by city");
	            System.out.println("5. Search by state");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch (choice) {
	                case 1:
	                    a.createAddressBook();
	                    break;
	                case 2:
	                    a.selectAddressBook();
	                    break;
	                case 3:
	                    a.listAddressBooks();
	                    break;
	                case 4:
	                    System.out.print("Enter city to search: ");
	                    String searchCity = scanner.nextLine();
	                    a.searchByCity(searchCity);
	                    break;
	                case 5:
	                    System.out.print("Enter state to search: ");
	                    String searchState = scanner.nextLine();
	                    a.searchByState(searchState);
	                    break;
	                case 6:
	                    System.out.println("Exiting Address Book System.");
	                    scanner.close();
	                    System.exit(0);
	                 
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	}
	    private  void createAddressBook() {
	    	Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a unique name for the new Address Book: ");
	        String bookName = scanner.nextLine();
	        
	        // Check if address book name already exists
	        if (addressBooks.containsKey(bookName)) {
	            System.out.println("An Address Book with this name already exists!");
	            return;
	        }
	        
	        // Create and store new Address Book
	        AddressBook newAddressBook = new AddressBook(bookName);
	        addressBooks.put(bookName, newAddressBook);
	        System.out.println("Address Book '" + bookName + "' created successfully!");
	    }

	    // Select and manage a specific Address Book
	    private   void selectAddressBook() {
	        // Check if any address books exist
	    	Scanner scanner = new Scanner(System.in);
	        if (addressBooks.isEmpty()) {
	            System.out.println("No Address Books exist. Please create one first.");
	            return;
	        }
	        
	        // List existing address books
	        System.out.println("Existing Address Books:");
	        for (String bookName : addressBooks.keySet()) {
	            System.out.println(bookName);
	        }
	        
	        // Prompt for selection
	        System.out.print("Enter the name of the Address Book to manage: ");
	        String selectedBookName = scanner.nextLine();
	        
	        // Validate selection
	        AddressBook selectedBook = addressBooks.get(selectedBookName);
	        if (selectedBook == null) {
	            System.out.println("Address Book not found!");
	            return;
	        }
	        while (true) {
	            System.out.println("\n--- " + selectedBookName + " Address Book Menu ---");
	            System.out.println("1. Add New Contact");
	            System.out.println("2. Edit Contact");
	            System.out.println("3. Delete Contact");
	            System.out.println("4. Display Contacts");
	            System.out.println("5. Return to Main Menu");
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            
	            switch (choice) {
	                case 1: // Add Contact
	                	System.out.print("Enter First Name: ");
	                    String firstName = scanner.nextLine();
	                    System.out.print("Enter Last Name: ");
	                    String lastName = scanner.nextLine();
	                    System.out.print("Enter Address: ");
	                    String address = scanner.nextLine();
	                    System.out.print("Enter City: ");
	                    String city = scanner.nextLine();
	                    System.out.print("Enter State: ");
	                    String state = scanner.nextLine();
	                    System.out.print("Enter Zip: ");
	                    String zip = scanner.nextLine();
	                    System.out.print("Enter Phone Number: ");
	                    String phoneNumber = scanner.nextLine();
	                    System.out.print("Enter Email: ");
	                    String email = scanner.nextLine();
	                    
	                    Contact newContact = new Contact(firstName, lastName, address, 
	                                                     city, state, zip, 
	                                                     phoneNumber, email);
	                    selectedBook.addContact(newContact);
	                    break;
	                
	                case 2: // Edit Contact
	                    System.out.print("Enter First Name to Edit: ");
	                    String editFirstName = scanner.nextLine();
	                    System.out.print("Enter Last Name to Edit: ");
	                    String editLastName = scanner.nextLine();
	                    selectedBook.editContact(editFirstName, editLastName);
	                    break;
	                
	                case 3: // Delete Contact
	                    System.out.print("Enter First Name to Delete: ");
	                    String deleteFirstName = scanner.nextLine();
	                    System.out.print("Enter Last Name to Delete: ");
	                    String deleteLastName = scanner.nextLine();
	                    selectedBook.deleteContact(deleteFirstName, deleteLastName);
	                    break;
	                
	                case 4: // Display Contacts
	                    selectedBook.displayContacts();
	                    break;
	                
	                
	                case 5: // Return to Main Menu
	                    return;
	                 
	                
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
       
            
                               
        }
	    private  void listAddressBooks() {
	        if (addressBooks.isEmpty()) {
	            System.out.println("No Address Books exist.");
	            return;
	        }
	        
	        System.out.println("Existing Address Books:");
	        for (String bookName : addressBooks.keySet()) {
	            System.out.println(bookName);
	        }
	    }
	    public void searchByCity(String city) {
	        addressBooks.values().stream()
	            .flatMap(book -> book.getContacts().stream())
	            .filter(contact -> contact.getCity().equalsIgnoreCase(city))
	            .forEach(System.out::println);
	    }

	    public void searchByState(String state) {
	        addressBooks.values().stream()
	            .flatMap(book -> book.getContacts().stream())
	            .filter(contact -> contact.getState().equalsIgnoreCase(state))
	            .forEach(System.out::println);
	    }
}
	    

