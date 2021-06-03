package ConsoleMod;

import Commands.CommandFactoryImpl;


public class ConsoleMod {
    private static boolean loop = true;
    private DataReader dataReader = new DataReader() ;
    private CommandFactoryImpl commandFactoryImpl = new CommandFactoryImpl();
    private Validator validator = new Validator();
    private Information information = new Information();

    public Object getDataFromKeyboard() throws Exception {
        Validator validator = new Validator();
        String line;
        while (loop){
            line = dataReader.getConsoleData();
            try {
                information.takeInformation(line);
                validator.checkLine(information);
            }catch (Exception e){
                System.out.println("Комманда введена неверно" + "\n" + "Попробуйте ввести ещё раз"+ "\n" + "Чтобы получить список доступных команд напишите help");
                continue;
            }
            break;
        }
        return commandFactoryImpl.chooseCommand(information.getCommand());
    }
    // Отвечает за остановку цикла
    public static void setTreat(boolean loop){
        ConsoleMod.loop=loop;
    }



}
