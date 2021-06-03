package Commands;

import Model.Dragon;

import java.util.Collections;

public class Add_If_MinCommand extends Command{
    AddCommand addCommand = new AddCommand();
    DragonComparator dragonComparator = new DragonComparator();
    @Override
    public void execute() throws Exception {
        Dragon dragonMin = findDragonMin();
        Dragon dragonNew = addCommand.createDragon();
        if(dragonComparator.compare(dragonMin,dragonNew) > 0 ){
            dragonNew.inctCounter();
            Dragon.getDragonsCollection().add(dragonNew);
            System.out.println("Дракон минимален, поэтому успешно добавлен");
        }

    }
    protected Dragon findDragonMin(){
        return Collections.min(Dragon.getDragonsCollection(),dragonComparator);
    }

}
