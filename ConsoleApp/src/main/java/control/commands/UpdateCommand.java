package control.commands;

import control.Information;
import model.Dragon;

import java.util.ListIterator;

public class UpdateCommand extends Command {
    /**
     * Запуск комманды
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {
        ListIterator<Dragon> dragonListIterator = Dragon.getDragonsCollection().listIterator();
        Dragon dragon = new Dragon();
        boolean flag = false;
        while (dragonListIterator.hasNext()) {
            dragon = dragonListIterator.next();
            if (dragon.getId() == Information.getId()) {
                flag = true;
                break;
            }
        }
        if (flag == true) {
            System.out.println(dragon);
            changeDragon(dragon, Information.getId());
            System.out.println("Дракон успешно изменён");
        } else {
            System.out.println("Нет такого Id");
        }

    }

    private void changeDragon(Dragon dragon, long id) throws Exception {
        Dragon.getDragonsCollection().remove(dragon);
        AddCommand addCommand = new AddCommand();
        Dragon updatedDragon = addCommand.createDragon();
        updatedDragon.setId(id);
        Dragon.getDragonsCollection().add(updatedDragon);
    }

}
