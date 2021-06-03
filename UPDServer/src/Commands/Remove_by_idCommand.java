package Commands;

import ConsoleMod.Information;
import Model.Dragon;

import java.util.ListIterator;

public class Remove_by_idCommand extends Command{
    public void execute(){
        ListIterator<Dragon > dragonListIterator = Dragon.getDragonsCollection().listIterator();
        long currentId;
        while (dragonListIterator.hasNext()){
            Dragon dragon = dragonListIterator.next();
            currentId = dragon.getId();
            if(currentId == Information.getId()){
                System.out.println(dragon.toString());
                System.out.print("Удаление прошло успешно");
                Dragon.getDragonsCollection().remove(dragon);
                break;
            }
        }
    }

}
