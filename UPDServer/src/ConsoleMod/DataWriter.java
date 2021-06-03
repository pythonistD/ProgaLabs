package ConsoleMod;

import java.io.BufferedReader;

public class DataWriter {

    public void writeCollectionData(BufferedReader collectionData) throws Exception{
        String currentline;
            while ((currentline = collectionData.readLine()) != null) {
                Parser.csvparser(currentline);
            }
            collectionData.close();
    }
}
