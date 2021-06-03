package Commands;

import Model.Dragon;

import java.util.Comparator;

public class DragonComparator implements Comparator<Dragon> {
    @Override
    public int compare(Dragon o1, Dragon o2) {
        if((o1.getAge()-o2.getAge())<0){
            return -1;
        }
        if((o1.getAge()-o2.getAge())>0){
            return 1;
        }
        if((o1.getAge()-o2.getAge()) == 0){
            return 0;
        }
        return 2;
    }
}
