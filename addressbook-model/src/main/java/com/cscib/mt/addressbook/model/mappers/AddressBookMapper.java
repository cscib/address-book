package com.cscib.mt.addressbook.model.mappers;

import com.cscib.mt.addressbook.model.AddressBook;
import com.cscib.mt.addressbook.model.Person;

import java.util.List;

/**
 * A mapper class of which its job is to map objects from AddressBook to another object and vice-versa.
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class AddressBookMapper {

    /**
     * Maps a list of persons to an AddressBook.
     * @param persons a list of type Person
     * @return an Address Book
     */
    public static AddressBook mapToAddressBook(List<Person> persons){
        AddressBook addressBook = new AddressBook();
        addressBook.setPersons(persons);
        return addressBook;
    }
}
