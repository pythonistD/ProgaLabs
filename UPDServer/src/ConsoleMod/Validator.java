package ConsoleMod;

import Model.DragonType;
import Model.ModelTypes;

import java.io.BufferedReader;

public class Validator {
    private Parser parser = new Parser();
    private Other other = new Other();
    private static long id;
    private static String filename;
    private String Command;

    // Проверка корректности команд

    public void isRight(boolean flag) throws IncorrectInputException {
        if(!flag){
            throw new IncorrectInputException("Команда введена некоректно");
        }
    }
    public boolean isString(String field){
        try{
            Long.parseLong(field);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean isFilename(String field){
        try{
            ModelTypes.valueOf(field);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean checkCommand(String command){
        for (String s : other.avalibleCommandList()) {
            if (s.equals(command)) {
                return true;
            }
        }
        return false;
    }
    public void checkLine(Information inf) throws Exception{
        boolean profCommand;
        boolean profModelType;
        profCommand = checkCommand(inf.getCommand());
        if(inf.getModleType() != null){
            profModelType = checkModelType(inf.getModleType());
            isRight(profModelType);
        }
        isRight(profCommand);
    }

public boolean checkModelType(String modeltype){
        try {
            ModelTypes.valueOf(modeltype);
        }catch (Exception e){
            return false;
        }
       return true;
}

    // Проверка корректности полей
    public Long checkLong(String promptToChange){
        Long t = null;
        String inData;
        BufferedReader in = DataReader.getTreat();
        while (true){
            try {
                inData = in.readLine();
                if(inData.equals(" ")){
                    break;
                }
                t = Long.parseLong(inData);
            }catch (Exception e){
                System.out.println("Данные введены некорректно" + "\n" + "Попробуйте ввести ещё раз");
                System.out.println(promptToChange);
                continue;
            }
            break;
        }
        return t;
    }
    public Double checkDouble(String promptToChange){
        Double t = null;
        String inData;
        BufferedReader in = DataReader.getTreat();
        while (true){
            try {
                inData = in.readLine();
                if(inData.equals(" ")){
                    break;
                }
                t = Double.parseDouble(inData);
            }catch (Exception e){
                System.out.println("Данные введены некорректно" + "\n" + "Попробуйте ввести ещё раз");
                System.out.println(promptToChange);
                continue;
            }
            break;
        }
        return t;
    }
    public Boolean checkBolean(String promptToChange) throws Exception{
        Boolean t = null;
        String inData;
        BufferedReader in = DataReader.getTreat();
        while (true){
                inData = in.readLine();
                if(inData.equals(" ")){
                    break;
                }
                if(inData.equals("TRUE")){
                    t = true;
                }else if(inData.equals("FALSE")){
                    t = false;
                }else{
                    System.out.println("Данные введены некорректно" + "\n" + "Попробуйте ввести ещё раз");
                    System.out.println(promptToChange);
                    continue;
                }
            break;
        }
        return t;
    }
    public DragonType checkDragonType(String promptToChange){
        DragonType t = null;
        String inData;
        BufferedReader in = DataReader.getTreat();
        while (true){
            try {
                inData = in.readLine();
                if(inData.equals(" ")){
                    break;
                }
                t = DragonType.valueOf(inData);
            }catch (Exception e){
                System.out.println("Данные введены некорректно" + "\n" + "Попробуйте ввести ещё раз");
                System.out.println(promptToChange);
                continue;
            }
            break;
        }
        return t;
    }

    public static long getId() {
        return id;
    }

    public static String getFilename() {
        return filename;
    }

    public String getCommand() {
        return Command;
    }
}
