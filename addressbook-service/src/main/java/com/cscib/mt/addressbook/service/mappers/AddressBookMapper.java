package com.cscib.mt.addressbook.service.mappers;

import com.cscib.mt.addressbook.model.AddressBook;
import com.cscib.mt.addressbook.model.Person;

import java.util.List;

/**
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
