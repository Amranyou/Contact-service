/*
 * Author: Fathi Amran
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	/*
	 * This class test the attributes of the Contact class to make sure they comply with the requirements
	 */

	@Test
	void testContactClassAttributes() {

		// create a contact
		Contact.instance().addContact("9999999999", "Mike", "Tyson", "5597813348", "12 P ST, Pville, CA 93257");

		// assert that the newly created contact has the same values as the following:
		assertTrue(Contact.instance().getContactId().equalsIgnoreCase("9999999999"));
		assertTrue(Contact.instance().getFirstName().equalsIgnoreCase("Mike"));
		assertTrue(Contact.instance().getLastName().equalsIgnoreCase("Tyson"));
		assertTrue(Contact.instance().getPhoneNumber().equalsIgnoreCase("5597813348"));
		assertTrue(Contact.instance().getAddress().equalsIgnoreCase("12 P ST, Pville, CA 93257"));
	}

	@Test
	void testNameLength() {
		// expecting an exception for name longer than 10 chars
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact.instance().addContact("9999999999", "MikeIsAlongName", "Tyson", "5597813348", "12 P ST, Pville, CA 93257");
		}); 
	}

	@Test
	void testNameNull() {
		// expecting an exception for null names
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact.instance().addContact("9999999999", null, "Tyson", "5597813348", "12 P ST, Pville, CA 93257");
		}); 
	}

	@Test
	void testPhoneNumberLength() {
		// expecting an exception for phone numbers shorter or longer than 10 digits
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact.instance().addContact("99999999995874549", "Mike", "Tyson", "5597813348", "12 P ST, Pville, CA 93257");
		}); 
	}
	
	@Test
	void testPhoneNumberNull() {
		// expecting an exception for null phone number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact.instance().addContact(null, "Mike", "Tyson", "5597813348", "12 P ST, Pville, CA 93257");
		}); 
	}
	
	@Test
	void testLongAddress() {
		// expecting an exception for an address longer than 30 chars
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact.instance().addContact("9999999999", "Mike", "Tyson", "5597813348", "12 Apple street Ave West Wood North Grant Road ST, Pville, CA 93257");
		}); 
	}
}
