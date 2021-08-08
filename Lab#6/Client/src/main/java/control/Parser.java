package control;

import MyExceptions.IncorrectIdException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Содержит методы для извелчения информации
 */
public class Parser {

    public static String getExtension(String fullFileName){
        // Подключил библиотеку, чтобы автоматически искала расширение файла org.apache.commons.io.FilenameUtils;
        return FilenameUtils.getExtension(fullFileName);
    }

    public static String[] parseInputLine(String command) throws NullPointerException{
        String[] partsOfCommand;
        partsOfCommand = command.split(" ");
        return partsOfCommand;
    }

    public String deleteBrackets(String field) {
        String data = field.replaceAll("[{}]", "");
        return data;
    }



}
