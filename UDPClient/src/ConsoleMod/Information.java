package ConsoleMod;

public class Information {
    Validator validator = new Validator();
    Parser parser = new Parser();
    String modleType;
    String command;
    private static long id;
    private static String filename;

    public boolean takeInformation(String line) throws Exception{
        String[] parsedLine = parser.parseInputLine(line);
        command = parsedLine[0];
        if(parsedLine.length == 1){
            return true;
        }
        if(validator.isString(parsedLine[1])){
            id = Long.parseLong(parsedLine[1]);
        }
        if(!validator.isString(parsedLine[1])){
            if(validator.isFilename(parsedLine[1])){
                filename = parsedLine[1];
            }
            if(!validator.isFilename(parsedLine[1])){
                modleType = parser.deleteBrackets(parsedLine[1]);
            }
        }
        if(parsedLine.length == 3){
            modleType = parser.deleteBrackets(parsedLine[2]);
        }
        return true;

    }

    public  String getCommand() {
        return command;
    }

    public static long getId() {
        return id;
    }

    public String getModleType() {
        return modleType;
    }

    public static String getFilename() {
        return filename;
    }
}
