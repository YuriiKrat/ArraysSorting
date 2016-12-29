package com.labs.analyzer;

import com.labs.excel.ExcelWriter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 08.12.16.
 */
public class Analyzer {

    /**
     * Information about classes and methods in concrete package
     */
    private StatisticsGenerator sg;

    /**
     * Initializes field {@link #sg}
     * @param path path to root folder with sources
     */
    public Analyzer(String path) {
        this.sg = new StatisticsGenerator(path);
    }

    /**
     * Generates time statistics for all types of sorters
     * with different fillers and writes it to console
     *
     * @param length length of array
     */
    public void analyze(int length) {
        Map<String, int[]> arrays = sg.getFilledArrays(length);
        long start;
        long finish;
        for(Map.Entry<String, int[]> array: arrays.entrySet()) {
            System.out.println("Filling type: " + array.getKey().replace("create", ""));
            System.out.format("|%-20s|%-15s|%20s|\n",
                    "Sort type",
                    "Size of array",
                    "Time(nanoseconds)");
            for(Class<?> sorter: sg.getSorters()) {
                try {
                    int[] tmp = new int[length];
                    System.arraycopy(array.getValue(), 0, tmp, 0, length);
                    Object clazz = sorter.getConstructor().newInstance();
                    Method method = sorter.getMethod("sort", int[].class);
                    start = System.nanoTime();
                    method.invoke(clazz, (Object) tmp);
                    finish = System.nanoTime();
                    System.out.format("|%-20s|%-15d|%20d|\n",
                            sorter.getSimpleName(), length,
                            (finish - start));

                } catch (InstantiationException | NoSuchMethodException |
                        InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Generates time statistics for all types of sorters
     * with different fillers and writes it to xls-file
     *
     * @param min minimal size of arrays
     * @param max maximal size of arrays
     * @param step iteration step
     */
    public void analyzeToExcel(int min, int max, int step) {
        ExcelWriter writer = new ExcelWriter("sort_stat.xlsx");
        int deep = 1;
        for (int i = min, j = 0; i <= max; i += step, j++) {
            Map<String, int[]> arrays = sg.getFilledArrays(i);
            long start;
            long finish;

            for (Map.Entry<String, int[]> array : arrays.entrySet()) {
                writer.write(i, 0, j, array.getKey().replace("create", ""));
                deep = 1;
                for (Class<?> sorter : sg.getSorters()) {
                    try {
                        int[] tmp = new int[i];
                        Object clazz = sorter.getConstructor().newInstance();
                        Method method = sorter.getMethod("sort", int[].class);
                        start = System.nanoTime();
                        method.invoke(clazz, (Object) array.getValue());
                        finish = System.nanoTime();
                        writer.write((finish - start), deep, j,array.getKey().replace("create", ""));
                    } catch (InstantiationException | NoSuchMethodException |
                            InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    deep++;
                }
            }

        }

        Map<String, int[]> arrays = sg.getFilledArrays(1);
        for (Map.Entry<String, int[]> array : arrays.entrySet()) {
            writer.createChart(deep-1,(max-min)/step,
                    array.getKey().replace("create", ""), sg.getNamesOfSorters());
        }
        writer.commit();
    }

}
