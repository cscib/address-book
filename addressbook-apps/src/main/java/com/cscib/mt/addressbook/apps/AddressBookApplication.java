package com.cscib.mt.addressbook.apps;


import com.cscib.mt.addressbook.enums.Gender;
import com.cscib.mt.addressbook.service.AddressBookService;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

/**
 * The Main Application which loads file with addressbook and answers 3 questions.
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class AddressBookApplication {

    static String FILENAME = "/addressbook.txt";

    public static void main(String[] args)  {

        String filename = (args != null && args.length > 0) ? args[0] : null;

        AddressBookService addressBookService = null;
        try {
            // Instantiate singleton service AddressBookService by passing the filename as a parameter.
            if (filename != null) {
                addressBookService = AddressBookService.getInstance(filename);
            } else {
                URL url = AddressBookApplication.class.getResource(FILENAME);
                addressBookService = AddressBookService.getInstance(url.getPath());
            }

            // 1. How many males are in the address book?
            System.out.println("Males in the address book: " + addressBookService.countOccurrencesByGender(Gender.MALE));

            // 2. Who is the oldest person in the address book?
            System.out.println("Oldest person in the address book is: " + addressBookService.getOldestPerson());

            // 3. How many days older is Bill than Paul?
            int days = addressBookService.getAgeDifferenceByNames("Bill McKnight", "Paul Robinson");
            System.out.println("Bill is " + days + " days older than Paul");

        } catch (IOException e) {
            System.out.println("Exception encountered when trying to read file " + filename);
        }
    }


}
