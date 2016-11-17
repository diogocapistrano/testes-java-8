package br.com.bsnet;

import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Created by DCN on 17/11/16.
 */
public class LambdaTest {

    public static void main(String[] args) {
        try {
            FileInputStream xlsxInputStream = new FileInputStream("/Users/DCN/Downloads/Book.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(xlsxInputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Lists.newArrayList(sheet.rowIterator()).forEach(row -> {
                Lists.newArrayList(row.cellIterator()).forEach(cell -> {
                    String cellAdress = cell.getAddress().formatAsString();
                    if(cellAdress.contains("A") || cellAdress.contains("B")) System.out.println(cell.getNumericCellValue());
                });
            });

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        List<String> cores = new ArrayList<String>();
        cores.add("vermelho");
        cores.add("azul");

        cores.forEach(cor -> System.out.println(cor));

        cores.forEach(System.out::println);

    }

}