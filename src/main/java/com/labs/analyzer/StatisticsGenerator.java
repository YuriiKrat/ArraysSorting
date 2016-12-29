package com.labs.analyzer;

import com.labs.annotations.Filler;
import com.labs.excel.ExcelWriter;
import com.labs.sorters.ArraySorter;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Finds all classes and somehow annotated methods in defined package
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.11.16.
 */
public class StatisticsGenerator {

    /**
     * List of sorting classes
     */
    private List<Class <?>> sorters;

    /**
     * List of filling methods
     */
    private List<Method> fillers;

    /**
     * Initializes fields {@link #sorters} and {@link #fillers}
     * @param path path to root folder with sources
     */
    public StatisticsGenerator(String path) {
        this.sorters = new ArrayList<>();
        this.fillers = new ArrayList<>();
        init(path);
    }

    /**
     * Finds sorting classes and filling methods
     * @param path path to current file
     */
    private void init(String path) {
        File file = new File(path.replace('.', '/'));
        File[] files = file.getAbsoluteFile().listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    init(path + "." + f.getName());
                } else {
                    if (f.getName().endsWith(".java")) {
                        try {
                            Class clazz = Class.forName(path.replace("src.main.java.", "") + "." +
                                    f.getName().replace(".java", ""));
                            if (clazz.getSuperclass() != null && clazz.getSuperclass().equals(ArraySorter.class)) {
                                sorters.add(clazz);
                            } else {
                               Method[] methods = clazz.getMethods();
                               for(Method method: methods) {
                                   if (method.isAnnotationPresent(Filler.class)) {
                                       fillers.add(method);
                                   }
                               }
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }



    /**
     * Returns names of sorter classes
     * @return names of sorters
     */
     List<String> getNamesOfSorters(){
        List<String> names = new ArrayList<>();
        for (Class<?> sorter : sorters) {
                names.add(sorter.getSimpleName());
        }
        return names;
    }

    /**
     * Returns generated arrays
     *
     * @param length length of an array
     * @return generated arrays
     */
     Map<String, int[]> getFilledArrays(int length) {

        Map<String, int[]> arrays = new HashMap<>();

        for (Method filler : fillers) {
                if (filler.getReturnType().equals(int[].class) && filler.getParameterCount() == 1) {
                    try {
                        int[] array = (int[]) filler.invoke(null, length);
                        arrays.put(filler.getName(), array);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        return arrays;
    }

     List<Class<?>> getSorters() {
        return sorters;
    }

}
