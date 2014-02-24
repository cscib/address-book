package com.cscib.mt.addressbook.enums;

/**
 * Enumerator class representing the Gender i.e. Male or Female
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public enum Gender {

   MALE,
   FEMALE;

    public static Gender valueOfIgnoreCase(String gender){
        for (Gender value : Gender.values()){
            if (value.name().equalsIgnoreCase(gender)) {
                return value;
            }
        }
        throw new IllegalArgumentException(
                "Cannot be parsed into an enum element : '" + gender + "'"
        );
    }
}
