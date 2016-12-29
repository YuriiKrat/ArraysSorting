package com.labs;

import com.labs.analyzer.Analyzer;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 20.11.16
 */
public class Runner {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Analyzer analyzer = new Analyzer("src.main");
//        analyzer.analyzeToExcel(10, 10000,  100);
        analyzer.analyze(10000);
    }

}
