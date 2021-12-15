/*
 * Author: Fathi Amran
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContact() throws Exception {
		
		// temp contatID makes it easy to reference
		String contactID = "444444444";

		// add a contact to test
		ContactService.instance().addContact(contactID, "Mike", "Tyson", "5597813348", "12 P ST, Pville, CA 93257");

		// assert that the newly created contact has the same values as the following:
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getContactId().equalsIgnoreCase(contactID));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getFirstName().equalsIgnoreCase("Mike"));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getLastName().equalsIgnoreCase("Tyson"));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getPhoneNumber().equalsIgnoreCase("5597813348"));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getAddress().equalsIgnoreCase("12 P ST, Pville, CA 93257"));
	}

	@Test
	void testUpdateContact() throws Exception {
		// temp contatID makes it easy to reference
		String contactID = "5555555555";
		
		// add a contact to test
		ContactService.instance().addContact(contactID, "Ali", "Noney", "5597813348", "12 P ST, Pville, CA 93257");
		
		// update the contact
		Contact contact = ContactService.instance().updateContact(contactID, "Joe", "Rom", "6613456666", "10 Y Ave, Quane, CA 93244");

		// assert that the newly update contact has the same values as the following:
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getContactId().equalsIgnoreCase(contactID));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getFirstName().equalsIgnoreCase("Joe"));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getLastName().equalsIgnoreCase("Rom"));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getPhoneNumber().equalsIgnoreCase("6613456666"));
		assertTrue(ContactService.contacts().get(ContactService.instance().findContact(contactID)).getAddress().equalsIgnoreCase("10 Y Ave, Quane, CA 93244"));
	}

	@Test
	void testDeleteContact() throws Exception {

		// add a contact to test
		ContactService.instance().addContact("2222222222", "Noel", "Malak", "5597813348", "12 P ST, Pville, CA 93257");

		// assert contact deletion
		assertTrue(ContactService.instance().deleteContact("2222222222"));
	}
}
