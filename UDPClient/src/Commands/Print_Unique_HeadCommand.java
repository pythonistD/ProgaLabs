package Commands;

import Model.Dragon;

public class Print_Unique_HeadCommand extends Command{
    @Override
    public void execute(){
        for (Dragon dragon : Dragon.getDragonsCollection()) {
            System.out.println(dragon.getName() + " toothCount:" + dragon.getHead().getToothCount());
        }

    }
}
