package com.moy.moyapp.service;

import com.moy.moyapp.entity.Entry;
import com.moy.moyapp.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

import java.util.List;

@Service
public class EntryService
{
    @Autowired
    private EntryRepository repository;

    public Entry saveEntry(Entry entry)
    {
        if(entry.getName()==null || entry.getName().isEmpty())
        {
            throw new RuntimeException("Name cannot be empty");
        }
        return repository.save(entry);
    }

    public List<Entry>getAllEntries()
    {
        return repository.findAll();
    }

    public List<Entry>searchByName(String name)
    {
        return repository.findByName(name);
    }

    public List<Entry>searchByVillage(String village)
    {
        return repository.findByVillage(village);
    }

    public ByteArrayInputStream exportToExcel() throws Exception {

        List<Entry> entries = repository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Moy Data");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Village");
        header.createCell(2).setCellValue("Amount");
        header.createCell(3).setCellValue("Function");

        int rowNum = 1;

        for (Entry e : entries) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(e.getName());
            row.createCell(1).setCellValue(e.getVillage());
            row.createCell(2).setCellValue(e.getAmount());
            row.createCell(3).setCellValue(e.getFunctionName());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
