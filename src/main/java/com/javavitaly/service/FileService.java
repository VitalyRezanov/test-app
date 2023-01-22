package com.javavitaly.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

@Service
public class FileService {

    private HashSet<String> numbersHashSet;

    public FileService() throws IOException {
        this.numbersHashSet = new HashSet<>();
        String is = this.getFileAsIOStream("name_java.xlsx");
        FileInputStream file = new FileInputStream(is);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() > 0)
                numbersHashSet.add(row.getCell(0).getStringCellValue());
        }
    }
    public void FileOutService() {
        System.out.println(numbersHashSet);
    }
    private boolean findNumber(String s) {
        boolean b = numbersHashSet.contains(s);
        if (b) {
            System.out.println("номер найден");
        }
        else {
            System.out.println("номер не найден");
        }

        return numbersHashSet.contains(s);
    }

    public void printFindResult() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i<3; i++) {
            System.out.println("Введите номер");
            String number = in.next();
            this.findNumber(number);
        }
        in.close();
    }

    private String getFileAsIOStream(final String fileName)
    {
        String ioStream = this.getClass()
                .getClassLoader()
                .getResource(fileName).getPath();

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

}
