package com.cscib.mt.addressbook.dao;

import com.cscib.mt.addressbook.enums.Gender;
import com.cscib.mt.addressbook.model.AddressBook;
import com.cscib.mt.addressbook.model.Person;
import com.cscib.mt.addressbook.model.mappers.AddressBookMapper;
import com.cscib.mt.addressbook.utils.FileReaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The class AddressBookDAO performs all Address Book Data Access operations. It is a singleton class which upon loading
 * the first time it creates an addressBook object by reading the objects from a file. This DAO can in the future be modified
 * in order to read from database or use entities to fetch/query data.
 *
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class AddressBookDAO {

    /**
     * The address book
     */
    private static AddressBook addressBook;

    /**
     * The AddressBookDAO Singleton Instance
     */
    private static AddressBookDAO singletonInstance;

    /**
     * The AddressBookDAO private constructor which loads the data in the addressBook object on initialisation.
     * @param file the fileName with the names
     * @throws IOException
     */
    private AddressBookDAO(File file) throws IOException {

        FileReaderUtils fileReaderUtils = new FileReaderUtils<Person>();

        List<Person> persons = fileReaderUtils.readFileIntoList(file, Person.class);
        addressBook = AddressBookMapper.mapToAddressBook(persons);
    }

    /**
     * Singleton getInstance method which returns the singleton instance of the method.
     * @param file the file
     * @return the singleton instance of the class
     * @throws IOException
     */
    public static AddressBookDAO getInstance(File file) throws IOException {
        if (null == singletonInstance) {
            synchronized (AddressBookDAO.class) {
                singletonInstance = new AddressBookDAO(file);
            }
        }
        return singletonInstance;
    }

    /**
     * Finds a person by name.
     * @param name the name of the person
     * @return a Person object
     */
    public Person findPersonByName(String name) {
        if (name != null) {
            for (Person person : addressBook.getPersons()){
                if (person.getName().equalsIgnoreCase(name.trim())) {
                    return person;
                }
            }
        }
        return null;
    }


    /**
     * Counts persons by gender.
     * @param gender the gender
     * @return the number of persons that have a particular Gender
     */
    public int countPersonsByGender(Gender gender) {
        int countOccurrences = 0;
        for (Person person : addressBook.getPersons()){
            if (person.getGender() == gender) {
                countOccurrences++;
            }
        }
        return countOccurrences;
    }

    /**
     * Find all persons in the address book.
     * @return a list of persons
     */
    public List<? extends Person> findAllPersons() {
        return addressBook.getPersons();
    }
}
