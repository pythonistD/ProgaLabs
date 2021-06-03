package ConsoleMod;

public class InformationTaker {
    Validator validator = new Validator();
    Parser parser = new Parser();

    public void takeInformation(String line) throws Exception{
        String[] parsedLine = parser.parseInputLine(line);


    }
}
