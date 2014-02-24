package com.cscib.mt.addressbook.model;

import java.util.List;

/**
 * The AddressBook POJO.
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class AddressBook {

    /**
     * The list of persons contained in an address book
     */
    private List<? extends Person> persons;

    /**
     * Retrieve the address book.
     * @return a list of persons in an address book
     */
    public List<? extends Person> getPersons() {
        return persons;
    }

    /**
     * Sets the address book.
     * @param persons address book made up of a list of persons
     */
    public void setPersons(List<? extends Person> persons) {
        this.persons = persons;
    }


}
