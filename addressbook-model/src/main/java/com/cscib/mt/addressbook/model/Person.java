package com.cscib.mt.addressbook.model;

import com.cscib.mt.addressbook.enums.Gender;
import com.cscib.mt.addressbook.model.exceptions.MappingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* The person POJO.
* @author      caroline sciberras
* @version     1.0.0
* @since       2014-02-22
*/
public class Person {

    public static final String DELIMITER = ",";
    public static final String FORMATTER = "dd/MM/yy";

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
     * @param delimiter the delimiter.
     * @param dateFormatter the date formatter e.g. (dd/MM/yy).
     */
    public Person(String str, String delimiter, String dateFormatter) throws ParseException, MappingException {
        String strArr[] = str.split(delimiter);

        if (strArr == null || strArr.length != 3) {
            throw new MappingException("Problems mapping data to a Person.");
        }

        this.name = strArr[0].trim();
        this.gender = Gender.valueOfIgnoreCase(strArr[1].trim());
        this.dateOfBirth = new SimpleDateFormat(dateFormatter).parse(strArr[2].trim());
    }

    /**
     * The Person Constructor of the person.
     * @param str the name of the person.
     */
    public Person(String str) throws ParseException, MappingException {
        this(str, DELIMITER, FORMATTER);
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

    /**
     * Overriding the toString() method
     * @return a string
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dateOfBirth +
                '}';
    }
}
