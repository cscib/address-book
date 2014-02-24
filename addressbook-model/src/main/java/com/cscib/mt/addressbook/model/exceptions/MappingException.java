package com.cscib.mt.addressbook.model.exceptions;

/**
 * An exception class used for when there are mapping problems.
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-24
 */
public class MappingException extends Exception{
    /**
     * Public constructor calling the super class
     * @param s the message
     */
    public MappingException(String s) {
        super(s);
    }

    /**
     * Public constructor calling the super class
     * @param s the message
     * @param throwable throwable
     */
    public MappingException(java.lang.String s, java.lang.Throwable throwable) {
        super(s,throwable);
    }

    /**
     * Public constructor calling the super class
     * @param throwable throwable
     */
    public MappingException(java.lang.Throwable throwable) {
        super(throwable);
    }

}
