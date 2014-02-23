package com.cscib.mt.addressbook.service;

import com.cscib.mt.addressbook.dao.AddressBookDAO;
import com.cscib.mt.addressbook.enums.Gender;
import com.cscib.mt.addressbook.model.Person;
import com.cscib.mt.addressbook.utils.AgeComparator;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class AddressBookService {

    /**
     * The AddressBookService Singleton Instance
     */
    private static AddressBookService singletonInstance;

    /**
     * The address book DAO
     */
    private static AddressBookDAO addressBookDAO;

    /**
     * The AddressBookService Constructor
     * @param file
     */
    private AddressBookService(File file) throws IOException {
        addressBookDAO = AddressBookDAO.getInstance(file);
    }

    /**
     * The getInstance method returning the class singleton instance.
     * @param path the path
     * @return the AddressBookService instance
     * @throws IOException
     */
    public static AddressBookService getInstance(String path) throws IOException {
        return getInstance(new File(path));
    }

    /**
     * The getInstance method returning the class singleton instance.
     * @param file the filename
     * @return the AddressBookService instance
     * @throws IOException
     */
    public static AddressBookService getInstance(File file) throws IOException {
        if (null == singletonInstance) {
            synchronized (AddressBookService.class) {
                singletonInstance = new AddressBookService(file);
            }
        }
        return singletonInstance;
    }

    /**
     * Count the occurrences of a particular gender
     * @param gender the gender
     * @return the number of persons of a particular gender
     */
    public int countOccurrencesByGender(Gender gender){
        return addressBookDAO.countPersonsByGender(gender);
    }


    /**
     * Get the Oldest Person.
     * @return a Person object
     */
    public Person getOldestPerson() {
        Person oldestPerson = null;

        List<? extends Person> persons = addressBookDAO.findAllPersons();
        if (persons != null && !persons.isEmpty()) {
            Collections.sort(persons, new AgeComparator());
            oldestPerson = persons.get(persons.size() - 1);
        }
        return oldestPerson;
    }

    /**
     * Get the age Difference of person 1 and person 2.
     * @param name1 the name of person 1
     * @param name2 the name of person 2
     * @return the age difference
     */
    public int getAgeDifferenceByNames(String name1, String name2) {
        int days = -1;
        Person person1 = addressBookDAO.findPersonByName(name1);
        Person person2 = addressBookDAO.findPersonByName(name2);

        if (person1 != null && person2 != null) {
            days = Days.daysBetween(new DateTime(person1.getDateOfBirth()), new DateTime(person2.getDateOfBirth())).getDays();

        }
        return days;
    }

}
