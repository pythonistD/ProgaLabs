package Commands;

import ConsoleMod.Other;
import Model.Dragon;

public class InfoCommand extends Command{
    @Override
    public void execute() throws Exception{
        System.out.println("Тип коллекции:Linked list" + "\n"
                + "Дата создания коллекции: " + Dragon.getDragonsCollection().getFirst().getCreationDate() + "\n"
                + "Коллицество элементов коллекции: " + Other.count(Dragon.getDragonsCollection()));

    }


}
