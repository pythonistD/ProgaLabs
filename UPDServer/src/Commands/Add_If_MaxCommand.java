package Commands;

import Model.Dragon;

import java.util.Collections;

public class Add_If_MaxCommand extends Command{
    AddCommand addCommand = new AddCommand();
    DragonComparator dragonComparator = new DragonComparator();
    @Override
    public void execute() throws Exception {
        Dragon dragonMax = findDragonMax();
        Dragon dragonNew = addCommand.createDragon();
        if(dragonComparator.compare(dragonMax,dragonNew) < 0){
            dragonNew.inctCounter();
            Dragon.getDragonsCollection().add(dragonNew);
            System.out.println("Дракон максимален, поэтому успешно добавлен");
        }

    }
    protected Dragon findDragonMax() {
        return Collections.max(Dragon.getDragonsCollection(), dragonComparator);
    }

}
