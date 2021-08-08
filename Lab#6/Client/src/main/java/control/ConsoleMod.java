package control;

import control.commands.CommandFactoryImpl;
import java.util.NoSuchElementException;

/**
 * Главный класс, который отвечает за консольный интерактивный режим
 */
public class ConsoleMod {
    private static boolean loop = true;
    private DataReader dataReader = new DataReader();
    private CommandFactoryImpl commandFactoryImpl = new CommandFactoryImpl();
    private Validator validator = new Validator();
    private Information information;
    private InfDeliverer infDeliverer;

    public Object getDataFromKeyboard() throws Exception {
            Utility.createAvailableCommandsMap();
            String line;
            while (loop) {
                information = new Information();
                try {
                    line = dataReader.getConsoleData();
                    information.takeInformation(line);
                    infDeliverer = new InfDeliverer(information);
                    validator.checkLine(information);
                } catch (IllegalArgumentException badArgument) {
                    System.out.print(badArgument.getMessage());
                } catch (NoSuchElementException | IllegalStateException e) {
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println("Комманда введена неверно" + "\n" + "Попробуйте ввести ещё раз" + "\n" + "Чтобы получить список доступных команд напишите help");
                    continue;
                }
                break;
            }
        return commandFactoryImpl.chooseCommand(information.getCommand());
    }

    /**
     * Отвечает за остановку цикла(программы)
     * @param loop
     */
    public static void setTreat(boolean loop) {
        ConsoleMod.loop = loop;
    }


}
