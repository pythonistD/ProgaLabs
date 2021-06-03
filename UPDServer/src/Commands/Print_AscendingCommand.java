package Commands;

import Model.Dragon;

import java.util.Collections;

public class Print_AscendingCommand extends Command {
    DragonComparator dragonComparator = new DragonComparator();
    @Override
    public void execute() throws Exception{
           Collections.sort(Dragon.getDragonsCollection(),dragonComparator);
           System.out.println("Список успешноы отсортирован");

    }


}
