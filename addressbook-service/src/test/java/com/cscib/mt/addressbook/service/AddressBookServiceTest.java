package com.cscib.mt.addressbook.service;

import com.cscib.mt.addressbook.enums.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
@RunWith(JUnit4.class)
public class AddressBookServiceTest {

    private static URL path;

    @Before
    public void before() throws IOException {
       path = this.getClass().getResource("/addressbook.txt");

    }

    @Test
    public void getInstanceTest() throws IOException {
        File file = new File(path.getPath());
        AddressBookService abService = AddressBookService.getInstance(file);
        assertNotNull(abService);
    }

    @Test(expected = NullPointerException.class)
    public void getInstanceFileContentwithNullTest() throws IOException {
        String s = null;
        AddressBookService abService = AddressBookService.getInstance(s);
    }

    @Test(expected = NullPointerException.class)
    public void getInstanceFileContentWithWrongFilenameTest() throws IOException {
        URL path = this.getClass().getResource("classpath:Wrong.FileName");
        File file = new File(path.getPath());
        AddressBookService abService = AddressBookService.getInstance(file);
    }

    @Test
    public void countOccurrencesByGenderTest() throws IOException {
        File file = new File(path.getPath());
        AddressBookService abService = AddressBookService.getInstance(file);
        assertEquals(3,abService.countOccurrencesByGender(Gender.MALE));
        assertEquals(2,abService.countOccurrencesByGender(Gender.FEMALE));
    }

    @Test
    public void getOldestPersonTest() throws IOException {
        File file = new File(path.getPath());
        AddressBookService abService = AddressBookService.getInstance(file);
        assertEquals("Wes Jackson",abService.getOldestPerson().getName());
    }

    @Test
    public void getAgeDifferenceByNamesTest() throws IOException {
        File file = new File(path.getPath());
        String name1 = "Bill McKnight";
        String name2 = "Paul Robinson";

        AddressBookService abService = AddressBookService.getInstance(file);
        int ageDifference = abService.getAgeDifferenceByNames(name1, name2);
        assertEquals(2862,ageDifference);


    }

}
