package de.exxcellent.challenge.interfaces;

import java.util.List;


public interface DataProcessor {

    void loadCSVData(String path, String separator);

    default int getIndexOfColumn(String SearchedColumnName, List<String> columnNames) {
        // is used in case the order of columns in the csv changed
        return columnNames.indexOf(SearchedColumnName);
    }

    default void checkIfLineValuesCanBeParsed(int line, String[] values, String[] columnsWithIntegerValues, List<String> columnNames) {
        for (String columnName : columnsWithIntegerValues) {
            if (!values[getIndexOfColumn(columnName, columnNames)].matches("^-?[0-9]+$"))
            {
                throw new Error("Column " + columnName + " in line " + line + " should be an integer.");
            }
        }
    }
}