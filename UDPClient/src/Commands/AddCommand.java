package Commands;


import ConsoleMod.DataReader;
import ConsoleMod.Other;
import ConsoleMod.ValidateFields;
import ConsoleMod.Validator;
import Model.Coordinates;
import Model.Dragon;
import Model.DragonHead;
import Model.DragonType;

import java.io.BufferedReader;
import java.util.ListIterator;

public class AddCommand extends Command  {
    private Validator validator = new Validator();
    private ValidateFields validateFields = new ValidateFields();



    @Override
    public void execute() throws Exception {
        try {
            Dragon dragon = createDragon();
            dragon.inctCounter();
            Dragon.getDragonsCollection().add(dragon);
            System.out.println("Дракон успешно добавлен");
        } catch (Exception e) {
            System.out.println("Введённые данные не корректны");
        }
    }
    public Dragon createDragon()throws Exception{
        ListIterator<String> promptsiterator = Other.promptsListtocreate().listIterator();

        BufferedReader in = DataReader.getTreat();
        String promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        String name = in.readLine();
        validateFields.checkName(name,promptToChange);
        promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        Long age = validator.checkLong(promptToChange);
        promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        Double wingspan = validator.checkDouble(promptToChange);
        promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        Boolean speaking = validator.checkBolean(promptToChange);
        promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        Double x =  validator.checkDouble(promptToChange);
        promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        Double y =  validator.checkDouble(promptToChange);
        promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        Double tooth =  validator.checkDouble(promptToChange);
        promptToChange = promptsiterator.next();
        System.out.println(promptToChange);
        DragonType dragonType = validator.checkDragonType(promptToChange);
         Dragon dragon =
                new Dragon(name, age, wingspan, speaking, new Coordinates(x, y), new DragonHead(tooth), dragonType);
         return dragon;
    }
}
