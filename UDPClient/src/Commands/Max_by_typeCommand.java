package Commands;

import Model.Dragon;

import java.util.ListIterator;

public class Max_by_typeCommand extends Command{
    @Override
    public void execute() throws Exception{
        ListIterator<Dragon> itr = Dragon.getDragonsCollection().listIterator();
        Dragon dragon = new Dragon();
        Dragon dragon1=itr.next();
        while (itr.hasNext()){
            dragon = itr.next();
            if(dragon1.getType().ordinal() > dragon.getType().ordinal()){
                dragon1 = dragon;
            }
        }
        System.out.println(dragon.toString());
    }
}
