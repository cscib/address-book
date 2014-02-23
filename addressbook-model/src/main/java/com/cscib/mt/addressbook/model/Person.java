package com.cscib.mt.addressbook.model;

import com.cscib.mt.addressbook.enums.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author      caroline sciberras
* @version     1.0.0
* @since       2014-02-22
*/
public class Person {

    /**
     * The Person Constructor of the person.
     * @param name the name of the person.
     * @param gender the gender of the person.
     * @param dateOfBirth the date of birth of the person.
     */
    public Person(String name, Gender gender, Date dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * The Person Constructor of the person.
     * @param str the name of the person.
     */
    public Person(String str) throws ParseException {
        String a[] = str.split(",");
        this.name = a[0];
        this.gender = a[1].trim().equalsIgnoreCase(Gender.FEMALE.name()) ? Gender.FEMALE : a[1].trim().equalsIgnoreCase(Gender.MALE.name()) ? Gender.MALE : null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        this.dateOfBirth = format.parse(a[2]);
    }

    /**
     * The name of the person
     */
    private String name;

    /**
     * The gender of the person
     */
    private Gender gender;

    /**
     * The date of the person
     */
    private Date dateOfBirth;

    /**
     * Retrieves the name of the person.
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * @param name the name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the gender of the person.
     * @return the gender of the person
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     * @param gender the gender of the person
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Sets the date of birth of the person.
     * @return the date of birth of the person.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the person.
     * @param dateOfBirth the date of birth of the person.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
