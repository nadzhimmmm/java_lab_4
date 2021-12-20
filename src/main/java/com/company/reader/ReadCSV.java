package com.company.reader;


import com.company.model.Division;
import com.company.model.Human;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that reads data from a file into a list
 */
public class ReadCSV {

    /**
     * Reads data from the specified terminal, with a separator
     * @param csvFilePatch relative path to the file
     * @param separator separator
     * @return a list with a few people
     */
    public List<Human> readDataFromCsvFile(String csvFilePatch, char separator) {
        List<Human> listHuman = new LinkedList<>();

        long divisionId = 1;
        HashMap<String, Division> divisions = new HashMap<>();

        try (
                InputStream in = getClass().getResourceAsStream(csvFilePatch);
                CSVReader reader = in == null ? null : new CSVReaderBuilder(new InputStreamReader(in))
                        .withCSVParser(new CSVParserBuilder().withSeparator(separator).build()).build()) {
            if (reader == null) {
                throw new FileNotFoundException(csvFilePatch);
            }

            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Division nowDivision;
                if(divisions.containsKey(nextLine[4])) {
                    nowDivision = divisions.get(nextLine[4]);
                } else {
                    nowDivision = new Division(divisionId, nextLine[4]);
                    divisions.put(nextLine[4], nowDivision);
                    divisionId++;
                }
                listHuman.add(new Human(Long.parseLong(nextLine[0]), nextLine[1], nextLine[2],
                        LocalDate.parse(nextLine[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        nowDivision, Integer.parseInt(nextLine[5])));
            }


        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return listHuman;
    }

}
