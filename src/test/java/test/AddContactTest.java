package test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactMock;
import agenda.model.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class AddContactTest {

	private Contact con;
	private RepositoryContact rep;
	
	@Before
	public void setUp() throws Exception {
		rep = new RepositoryContactMock();
	}
	
	@Test
	public void testCase1()
	{
		try {
			con = new Contact("name", "address1", "+4071122334455");
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		//int n = rep.count();
		rep.addContact(con.getName(),con.getAddress(), con.getTelefon());
		for(Contact c : rep.getContacts())
			if (c.equals(con))
			{
				assertTrue(true);
				break;
			}
		//assertTrue(n+1 == rep.count());
	}
	
	@Test
	public void testCase2()
	{
		try{
			Contact con = (Contact) new Object();
			rep.addContact(con.getName(), con.getAddress(), con.getTelefon());
		}
		catch(Exception e)
		{
			assertTrue(true);
		}	
	}
	
	@Test
	public void testCase3()
	{
		for(Contact c : rep.getContacts())
			rep.removeContact(c);
		
		try {
			con = new Contact("name", "address1", "+071122334455");
			rep.addContact(con.getName(),con.getAddress(),con.getTelefon());
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		int n  = rep.count();
		if (n == 1) 
			if (con.equals(rep.getContacts().get(0))) assertTrue(true);
			else assertTrue(false);
		else assertTrue(false);
	}
	
}
