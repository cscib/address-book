package com.cscib.mt.addressbook.utils;

import com.cscib.mt.addressbook.model.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.getDateOfBirth().after(b.getDateOfBirth()) ? -1 : a.getDateOfBirth().equals(b.getDateOfBirth()) ? 0 : 1;
    }
}