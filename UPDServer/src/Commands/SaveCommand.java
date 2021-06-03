package Commands;

import Model.Dragon;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ListIterator;

public class SaveCommand extends Command{
    @Override
    public void execute() throws Exception{
            ListIterator<Dragon> dragonListIterator = Dragon.getDragonsCollection().listIterator();
            Writer out =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("CSV\\Dragon.csv"), StandardCharsets.UTF_8));

            while (dragonListIterator.hasNext()){
                out.write(dragonListIterator.next().toString());
            }
            System.out.println("Изменения успешно сохранены");
            out.close();
    }
}
