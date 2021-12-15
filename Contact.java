/*
 * Author: Fathi Amran
 */


public class Contact {

	// contact attributes
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// singleton
	private static Contact instance = null;
	private Contact() {};
	
	// get class instance
	public static Contact instance() {
		if(null == Contact.instance) {
			Contact.instance = new Contact();
		}
		return Contact.instance;
	}
	
	// add a contact and store it in vector
	public Contact addContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		Contact contact = Contact.instance();
		// add attributes to contact object
		contact.contactId = assignContactId(contactId);
		contact.firstName = updateFirstName(firstName);
		contact.lastName = updateLastName(lastName);
		contact.phoneNumber = updatePhoneNumber(phoneNumber);
		contact.address = updateAddress(address);

		// making sure that we account for all created contacts
		ContactService.contacts.addElement(contact);
		return contact;
	}

	// getters
	public String getContactId() { 
		return contactId; 
	}

	public String getFirstName() { 
		return firstName; 
	}

	public String getLastName() { 
		return lastName;
	}

	public String getPhoneNumber() { 
		return phoneNumber;
	}

	public String getAddress() { 
		return address;
	}

	// update first name
	public String updateFirstName(String firstName) {
		if ( (firstName == null) || (firstName.length() > 10)) {
			throw new IllegalArgumentException("First name cannot be empty or longer than 10 characters");
		} else {
			this.firstName = firstName;
			return this.firstName;
		}
	}

	// update last name
	public String updateLastName(String lastName) {
		if ( (lastName == null) || (lastName.length() > 10) ) {
			throw new IllegalArgumentException("Last name cannot be empty or longer than 10 characters");
		} else {
			this.lastName = lastName;
			return lastName;
		}
	}

	// update phone number
	public String updatePhoneNumber(String phoneNumber) {
		String regex = "[0-9]+";
		if ( (phoneNumber == null) || (phoneNumber.length() != 10) || (!phoneNumber.matches(regex)) ) {
			throw new IllegalArgumentException("Phone number cannot be empty and must be 10 digits long.");
		} else {
			this.phoneNumber = phoneNumber;
			return phoneNumber;
		}
	}

	// update address
	public String updateAddress(String address) {
		if ( (address == null) || (address.length() > 30) ) {
			throw new IllegalArgumentException("Address cannot be empty or longer than 30 chars");
		} else {
			this.address = address;
			return address;
		}
	}

	// assign contact id
	public String assignContactId(String contactId) {
		// loop through vector to check if ID is unique
		for(int index = 0; index < ContactService.contacts().size(); index++) {
			
			// Check if contact is null
			if(null != ContactService.contacts.get(index)) { 
				// check if contactId matches a vector element and return its index
				if (ContactService.contacts.get(index).getContactId().equals(contactId)) {
					throw new IllegalArgumentException("Contact ID already exists. Choosse a different one.");
				}
			}
		}
		
		// check if ID is null or less than 10 chars
		if ((contactId == null) || (contactId.length() > 10)) {
			throw new IllegalArgumentException("Contact ID cannot be empty");
		} else {
			return contactId;
		}
	}
}

