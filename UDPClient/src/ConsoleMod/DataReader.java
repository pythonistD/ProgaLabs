package ConsoleMod;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DataReader {
    private static BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
    private boolean loop = true;
    private static BufferedReader readFile;
    private static String inputfileCollection;

    public String getConsoleData() throws Exception{
        String line;
        line = consoleInput.readLine();
        return line;
    }




    //Сеттеры геттеры
    protected void setLoop(boolean loop){
        this.loop = loop;
    }
    public static BufferedReader getTreat(){
        return DataReader.consoleInput;
    }

    public static void setInputfileCollection(String inputfileCollection) {
        DataReader.inputfileCollection = inputfileCollection;
    }
}
