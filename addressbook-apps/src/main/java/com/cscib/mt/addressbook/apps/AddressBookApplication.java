package com.cscib.mt.addressbook.apps;


import com.cscib.mt.addressbook.enums.Gender;
import com.cscib.mt.addressbook.service.AddressBookService;

import java.util.Calendar;

/**
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class AddressBookApplication {

    static String FILE = "/addressbook.txt";

    public static void main(String[] args) throws Exception {
        // Read file and create data structure
        AddressBookService addressBookService = AddressBookService.getInstance(FILE);

        // 1. How many males are in the address book?
        System.out.println("Males in the address book: " + addressBookService.countOccurrencesByGender(Gender.MALE));

        // 2. Who is the oldest person in the address book?
        System.out.println("Oldest person in the address book is: " + addressBookService.getOldestPerson());

        // 3. How many days older is Bill than Paul?
        int days = addressBookService.getAgeDifferenceByNames("Bill McKnight", "Paul Robinson");
        System.out.println("Bill is " + days + " days older than Paul");
    }


}
