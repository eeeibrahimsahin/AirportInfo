package com.accenture.airportinfo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

class CsvConverterServiceTest {

    @Test
    void testConvert() throws FileNotFoundException {
        //Arrange
        String PATH_TEST = "src/test/java/test.csv";
        final List<TestClass> actualResult =
                new CsvToBeanBuilder<TestClass>(new FileReader(PATH_TEST))
                        .withType(TestClass.class).build().parse();
        //act
        final List<TestClass> expectedResult =
                CsvConverterService.convert(PATH_TEST, TestClass.class);
        //Assert
        assertEquals(expectedResult.toString(), actualResult.toString());
    }
}

