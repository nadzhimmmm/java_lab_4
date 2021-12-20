package com.company;

import com.company.model.Human;
import com.company.reader.ReadCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReadCVS {

    ReadCSV read = new ReadCSV();

    @Test
    void testList() {
        List<Human> result = read.readDataFromCsvFile("/foreign_names.csv", ';');
        assertAll(() -> assertEquals("{id: 28281, name: Aahan', male: Male', birthDate: 1970-05-15, division: {id: 1, name: 'I'}, salary: 4800.0}",
                result.get(0).toString()),
                () -> assertEquals("{id: 54178, name: Zyta', male: Female', birthDate: 1955-04-16, division: {id: 5, name: 'H'}, salary: 7600.0}",
                result.get(25897).toString()),
                () -> assertEquals("{id: 43281, name: Kitchi', male: Male', birthDate: 1993-09-08, division: {id: 7, name: 'O'}, salary: 7900.0}",
                        result.get(15000).toString())
        );
    }

}
