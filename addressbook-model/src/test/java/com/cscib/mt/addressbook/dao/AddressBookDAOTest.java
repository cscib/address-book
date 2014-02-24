package com.cscib.mt.addressbook.dao;


import com.cscib.mt.addressbook.enums.Gender;
import com.cscib.mt.addressbook.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Test class for AddressBookDAO
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
@RunWith(JUnit4.class)
public class AddressBookDAOTest {

    private static URL path;


    @Before
    public void before() throws IOException {
        path = this.getClass().getResource("/addressbook.txt");
    }

    @Test
    public void getInstanceTest() throws IOException {
        AddressBookDAO addressBookDAO = AddressBookDAO.getInstance(new File(path.getPath()));
        assertNotNull(addressBookDAO);
    }

    @Test
    public void findPersonByNameTest() throws IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");

        AddressBookDAO addressBookDAO = AddressBookDAO.getInstance(new File(path.getPath()));
        assertNotNull(addressBookDAO);

        Person person1 = addressBookDAO.findPersonByName("Bill McKnight");
        assertEquals(person1.getName(), "Bill McKnight");
        assertEquals(person1.getGender().name(), Gender.MALE.name());
        assertEquals(person1.getDateOfBirth(),simpleDateFormat.parse("16/03/77"));

        Person person2 = addressBookDAO.findPersonByName("Non Existent");
        assertNull(person2);

    }


    @Test
    public void countPersonsByGenderTest() throws IOException {
        AddressBookDAO addressBookDAO = AddressBookDAO.getInstance(new File(path.getPath()));
        assertNotNull(addressBookDAO);

        assertEquals(3, addressBookDAO.countPersonsByGender(Gender.MALE));
        assertEquals(2, addressBookDAO.countPersonsByGender(Gender.FEMALE));
    }

    @Test
    public void findAllPersonsTest() throws IOException {
        AddressBookDAO addressBookDAO = AddressBookDAO.getInstance(new File(path.getPath()));
        assertNotNull(addressBookDAO);

        List<? extends Person> persons = addressBookDAO.findAllPersons();
        assertNotNull(persons);
        assertEquals(5,persons.size());
    }
}
