import java.util.Objects;

public class Contact {
	private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    public Contact(String firstName, String lastName, String address, 
                   String city, String state, String zip, 
                   String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getFirstName() { 
    	return firstName; 
    	}
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    	}

    public String getLastName() { 
    	return lastName; 
    	}
    public void setLastName(String lastName) { 
    	this.lastName = lastName; 
    	}

    public String getAddress() { 
    	return address; 
    	}
    public void setAddress(String address) { 
    	this.address = address; 
    	}

    public String getCity() {
    	return city; 
    	}
    public void setCity(String city) { 
    	this.city = city; 
    	}

    public String getState() { 
    	return state; 
    	}
    public void setState(String state) { 
    	this.state = state;
    	}

    public String getZip() { 
    	return zip; 
    	}
    public void setZip(String zip) {
    	this.zip = zip; 
    	}

    public String getPhoneNumber() { 
    	return phoneNumber; 
    	}
    public void setPhoneNumber(String phoneNumber) { 
    	this.phoneNumber = phoneNumber; 
    	}

    public String getEmail() {
    	return email; 
    	}
    public void setEmail(String email) { 
    	this.email = email; 
    	}
    public String toString() {
        return "Contact{" +
               "Name='" + firstName + " " + lastName + '\'' +
               ", Address='" + address + '\'' +
               ", City='" + city + '\'' +
               ", State='" + state + '\'' +
               ", Zip='" + zip + '\'' +
               ", Phone='" + phoneNumber + '\'' +
               ", Email='" + email + '\'' +
               '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return firstName.equalsIgnoreCase(contact.firstName) && 
               lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }
    public String toCSV() {
        return String.join(",", firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    public static Contact fromCSV(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length == 8) {
            return new Contact(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7]);
        }
        System.out.println("Skipping malformed CSV line: " + csvLine);
        return null;
    }

}
