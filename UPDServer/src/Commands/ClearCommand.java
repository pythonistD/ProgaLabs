package Commands;

import Model.Dragon;

public class ClearCommand extends Command{
    public void execute() throws Exception{
        Dragon.getDragonsCollection().clear();
        System.out.println("Список успешно отчищен");
    }
}
