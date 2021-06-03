package ConsoleMod;

public class ValidateFields {
    public void checkName(String name,String promptToChange){
        while (true){
            try {
                String[] parsedName = name.split(" ");
                if(name.equals(null) || parsedName[0].equals(" ")){
                 throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Данные введены некорректно" + "\n" + "Попробуйте ввести ещё раз");
                System.out.println(promptToChange);
                continue;
            }
            break;
        }
        System.out.println("OK");
    }
}
