package ConsoleMod;

import Model.Coordinates;
import Model.Dragon;
import Model.DragonHead;
import Model.DragonType;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;


public class Parser {

    public String[] parseInputLine(String command) throws Exception{
        String[] partsOfCommand;
        partsOfCommand = command.split(" ",3);
        return partsOfCommand;
    }
    public static String parseCSVfield(String field){
        String[] data = field.split(":");
        return data[1];

    }

    public static void csvparser(String currentline) throws IOException {
        CSVParser parser = CSVParser.parse(currentline, CSVFormat.EXCEL);
        for (CSVRecord csvRecord : parser) {
            String name = Parser.parseCSVfield(csvRecord.get(1));
            Long age = Long.parseLong(Parser.parseCSVfield(csvRecord.get(2)));
            double wingspan = Double.parseDouble(Parser.parseCSVfield(csvRecord.get(3)));
            boolean speaking = Boolean.parseBoolean(Parser.parseCSVfield(csvRecord.get(4)));
            double x = Double.parseDouble(Parser.parseCSVfield(csvRecord.get(5)));
            double y = Double.parseDouble(Parser.parseCSVfield(csvRecord.get(6)));
            Coordinates coordinates = new Coordinates(x, y);
            double tooth = Double.parseDouble(Parser.parseCSVfield(csvRecord.get(7)));
            DragonHead dragonHead = new DragonHead(tooth);
            Dragon dragon = new Dragon(name, age, wingspan, speaking, coordinates, dragonHead, DragonType.valueOf(Parser.parseCSVfield(csvRecord.get(8))));
            dragon.inctCounter();
            Dragon.getDragonsCollection().add(dragon);

        }
    }
    public String deleteBrackets(String field){
        String data = field.replaceAll("[{}]","");
        return data;
    }



}
