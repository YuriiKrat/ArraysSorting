package com.labs.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Writes data to excel file
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 03.12.16.
 */
public class ExcelWriter {

    /**
     * Excel workbook
     */
    private XSSFWorkbook workbook;

    /**
     * File name
     */
    private String fileName;

    public ExcelWriter(String fileName) {
        this.fileName = fileName;
        FileInputStream file = null;
        try {
            file = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            try (FileOutputStream out = new FileOutputStream(fileName)) {
                XSSFWorkbook w = new XSSFWorkbook();
                w.write(out);
                file = new FileInputStream(fileName);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        try {
            workbook = new XSSFWorkbook(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes time data to sheet
     * @param numb data
     * @param rowNumb row number
     * @param colNumb column number
     * @param sheetName sheet name
     */
    public void write(double numb, int rowNumb, int colNumb, String sheetName) {
        XSSFSheet sheet = workbook.getSheet(sheetName) == null ?
                workbook.createSheet(sheetName) :
                workbook.getSheet(sheetName);

        Row row;
        Cell cell;
        if (sheet.getRow(rowNumb) == null) {
            row = sheet.createRow(rowNumb);
        } else {
            row = sheet.getRow(rowNumb);
        }
        cell = row.createCell(colNumb);
        cell.setCellValue(numb);
        cell.setCellType(CellType.NUMERIC);

    }

    /**
     * Creates chart
     * @param seriesNumb number of sorters
     * @param seriesLength
     * @param sheetName name of sheet
     * @param seriesNames names of sorters
     */
    public void createChart(int seriesNumb, int seriesLength, String sheetName, List<String> seriesNames){

        Sheet sheet = workbook.getSheet(sheetName) == null ?
                workbook.createSheet(sheetName) :
                workbook.getSheet(sheetName);

        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 30);

        Chart chart = drawing.createChart(anchor);
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.TOP_RIGHT);

        LineChartData data = chart.getChartDataFactory().createLineChartData();

        ValueAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet,
                new CellRangeAddress(0, 0, 0, seriesLength- 1));
        for(int i = 1;i <= seriesNumb; i++){
            ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet,
                    new CellRangeAddress(i, i, 0, seriesLength - 1));
            data.addSeries(xs, ys1).setTitle(seriesNames.get(i-1));
        }
        chart.plot(data, bottomAxis, leftAxis);


    }

    /**
     * Writes changes to file
     */
    public void commit() {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            workbook.write(out);
            System.out.println("Excel written successfully..");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
