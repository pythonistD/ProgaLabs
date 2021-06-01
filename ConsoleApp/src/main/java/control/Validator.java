package control;
import model.ModelTypes;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Валидация данных
 */
public class Validator {
    private static long id;
    private static String filename;
    private final Parser parser = new Parser();
    private final Utility utility = new Utility();
    private String Command;

    // Проверка корректности команд

    public static long getId() {
        return id;
    }

    public static String getFilename() {
        return filename;
    }

    public static void checkFileExtension(String fullFileName) throws UnsupportedEncodingException {
        String extension =
                Parser.getExtension(fullFileName);
        if (!extension.equals("csv")) {
            throw new UnsupportedEncodingException("Неправильная кодировка файла\n +Поддерживаются файлы кодировки CSV");
        }
    }

    public static void checkFileExist(String filePath) throws FileNotFoundException {
        if (filePath.equals(null)) {
            throw new FileNotFoundException("Не правильно указан путь до CSV файла или не ввели его в аргументе коммандной строки");
        }
    }

    public void isRight(boolean flag) throws IncorrectInputException {
        if (!flag) {
            throw new IncorrectInputException("Команда введена некоректно");
        }
    }

    public boolean isString(String field) {
        try {
            Long.parseLong(field);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isModelType(String field) {
        try {
            ModelTypes.valueOf(field);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkCommand(String command) {
        for (String s : utility.avalibleCommandList()) {
            if (s.equals(command)) {
                return true;
            }
        }
        return false;
    }

    public void checkLine(Information inf) throws Exception {
        boolean profCommand;
        boolean profModelType;
        profCommand = checkCommand(inf.getCommand());
        if (inf.getModleType() != null) {
            profModelType = checkModelType(inf.getModleType());
            isRight(profModelType);
        }
        isRight(profCommand);
    }

    public boolean checkModelType(String modeltype) {
        try {
            ModelTypes.valueOf(modeltype);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getCommand() {
        return Command;
    }
}
