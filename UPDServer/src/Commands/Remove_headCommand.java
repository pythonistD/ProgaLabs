package Commands;

import Model.Dragon;

public class Remove_headCommand extends Command{
    @Override
    public void execute(){
        System.out.print(Dragon.getDragonsCollection().getFirst().toString());
        Dragon.getDragonsCollection().removeFirst().toString();
        System.out.println("Удаление прошло успешно");

    }
}
