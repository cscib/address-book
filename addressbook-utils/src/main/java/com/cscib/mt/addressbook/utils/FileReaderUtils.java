package com.cscib.mt.addressbook.utils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to read files and map them into object of type T
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class FileReaderUtils<T> {

    /**
     * Reads file in a List of type T. Using Generics so that eventually multiple files can be mapped into different
     * objects of type T
     * @param modelClass the class of the model object of type T
     * @return a list of objects of type T
     * @throws IOException
     */
    public List<T> readFileIntoList(File file, Class<T> modelClass) throws IOException {

        List<T> list = new ArrayList<T>();

        if (file.exists()){
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file)));

            try {
                Constructor<T> tConstructor = modelClass.getConstructor(String.class);
                String data;
                while ((data = reader.readLine()) != null) {
                    T t = tConstructor.newInstance(data);
                    list.add(t);
                }
            } catch (InvocationTargetException |
                    InstantiationException |
                    IllegalAccessException |
                    NoSuchMethodException e) {
                throw new IOException("Problems encountered when reading file data and mapping them in objects.");
            } finally {
                reader.close();
            }
        }

        return list;
    }
}