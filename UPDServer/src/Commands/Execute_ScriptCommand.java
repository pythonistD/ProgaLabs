package Commands;


import ConsoleMod.DataReader;
import ConsoleMod.Information;
import ConsoleMod.Validator;

import java.io.BufferedReader;

public class Execute_ScriptCommand extends Command{
    Validator validator = new Validator();
    CommandFactoryImpl commandFactoryImpl = new CommandFactoryImpl();
    public void execute() throws Exception{
        BufferedReader bufferedReader = DataReader.getData(Information.getFilename());
        String command = "1";
        boolean flag=true;
        while (true){
            command = bufferedReader.readLine();
            if(command == null){
                System.out.println("Скрипт выполнен успешно");
                break;

            }
            try {
                validator.checkCommand(command);
            }catch (Exception e){
                System.out.println("В скрипте ошибка" + "\n" + "Выполнение сценария прервано");
                break;
            }
            commandFactoryImpl.chooseCommand(validator.getCommand()).execute();

        }
    }

}
