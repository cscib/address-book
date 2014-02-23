package com.cscib.mt.addressbook.utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      caroline sciberras
 * @version     1.0.0
 * @since       2014-02-22
 */
public class FileReaderUtils<T> {

    /**
     *
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
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } finally {
                reader.close();
            }
        }

        return list;
    }
}