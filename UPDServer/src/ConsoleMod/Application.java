package ConsoleMod;

import Commands.CommandFactoryImpl;


public class Application {
    private static boolean loop = true;
    private DataReader dataReader = new DataReader() ;
    private CommandFactoryImpl commandFactoryImpl = new CommandFactoryImpl();
    private Validator validator = new Validator();
    private Information information = new Information();

    public void consoleMod() throws Exception {
        DataReader.getCollectionData();
        DataWriter dataWriter = new DataWriter();
        dataWriter.writeCollectionData(DataReader.getCollectionData());
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
            commandFactoryImpl.chooseCommand(information.getCommand()).execute();
        }
    }
    // Отвечает за остановку цикла
    public static void setTreat(boolean loop){
        Application.loop=loop;
    }



}
