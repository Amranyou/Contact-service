/*
 * Author: Fathi Amran
 */


import java.util.Vector;

public class ContactService {

	// vector to store contacts
	public static Vector<Contact> contacts = null;
	private static ContactService instance = null;
	private ContactService() {}
	
	public static ContactService instance() {
		if(null == ContactService.instance) {
			ContactService.instance = new ContactService();
		}
		return ContactService.instance;
	}
	
	public static Vector<Contact> contacts() {
		if(null == ContactService.contacts) {
			ContactService.contacts = new Vector<Contact>(1);
		}
		return ContactService.contacts;
	}

	// add contacts and store them to vector
	public void addContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		ContactService.contacts().addElement(Contact.instance().addContact(contactId, firstName, lastName, phoneNumber, address));
	}

	// delete contact
	public Boolean deleteContact(String contactId) throws Exception {
		ContactService.contacts().remove(findContact(contactId));
		return true;
	}

	// update contact
	public Contact updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) throws Exception {
		
		// update contact attribute
		ContactService.contacts().get(findContact(contactId)).updateFirstName(firstName);
		ContactService.contacts().get(findContact(contactId)).updateLastName(lastName);
		ContactService.contacts().get(findContact(contactId)).updatePhoneNumber(phoneNumber);
		ContactService.contacts().get(findContact(contactId)).updateAddress(address);

		// return contact
		return ContactService.contacts().get(findContact(contactId));
	}

	// find contact
	public int findContact(String contactId) throws Exception {		
		// loop through vector
		for(int index = 0; index < ContactService.contacts().size(); index++) {
			
			// Check if contact is null
			if(null != ContactService.contacts.get(index)) { 
				// check if contactId matches a vector element and return its index
				if (ContactService.contacts.get(index).getContactId().equals(contactId)) {
					return index;
				}
			}
		}
		throw new Exception("Contact not found.");
	}
}