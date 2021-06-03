package Commands;

import Model.Dragon;

public class Calculator {

    public long calculateDragonfields(Dragon dragon){
        long result=
           dragon.getId() + (long) dragon.getWingspan() + dragon.getAge() +
                   (long)dragon.getCoordinates().getX()+ (long)dragon.getCoordinates().getY();
        return result;
    }
}
