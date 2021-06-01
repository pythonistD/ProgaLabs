package control;

import MyExceptions.IncorrectIdException;
import control.commands.CommandFactoryImpl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

/**
 * Главный класс, который отвечает за консольный интерактивный режим
 */
public class Application {
    private static boolean loop = true;
    private DataReader dataReader = new DataReader();
    private CommandFactoryImpl commandFactoryImpl = new CommandFactoryImpl();
    private Validator validator = new Validator();
    private Information information = new Information();

    public void consoleMod() throws Exception {
        try {
            Utility.createAvailableCommandsMap();
            DataReader.getCollectionData();
            DataWriter dataWriter = new DataWriter();
            dataWriter.writeCollectionData(DataReader.getCollectionData());
            Validator validator = new Validator();
            String line;
            while (loop) {
                try {
                    line = dataReader.getConsoleData();
                    information.takeInformation(line);
                    validator.checkLine(information);
                } catch (IllegalArgumentException badArgument) {
                    System.out.print(badArgument.getMessage());
                } catch (NoSuchElementException | IllegalStateException e) {
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println("Комманда введена неверно" + "\n" + "Попробуйте ввести ещё раз" + "\n" + "Чтобы получить список доступных команд напишите help");
                    continue;
                }
                commandFactoryImpl.chooseCommand(information.getCommand()).execute();
            }
        } catch (FileNotFoundException noFile) {
            System.out.print(noFile.getMessage());
        } catch (UnsupportedEncodingException badFileEncoding) {
            System.out.print(badFileEncoding.getMessage());
        } catch (IncorrectIdException badId) {
            System.out.print(badId.getMessage());
        }
    }

    // Отвечает за остановку цикла
    public static void setTreat(boolean loop) {
        Application.loop = loop;
    }


}
