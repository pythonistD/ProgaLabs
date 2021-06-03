package ConsoleMod;

import Model.Dragon;

import java.util.ArrayList;
import java.util.LinkedList;

public class Other {
    private static ArrayList<String> promtstochange = new ArrayList<>();
    private static ArrayList<String> promptstocreate = new ArrayList<>();

    public ArrayList<String> avalibleCommandList(){
        ArrayList<String> avalibleCommand=new ArrayList<>();
        avalibleCommand.add("help");
        avalibleCommand.add("info");
        avalibleCommand.add("show");
        avalibleCommand.add("add");
        avalibleCommand.add("update");
        avalibleCommand.add("remove_by_id");
        avalibleCommand.add("clear");
        avalibleCommand.add("save");
        avalibleCommand.add("execute_script");
        avalibleCommand.add("exit");
        avalibleCommand.add("remove_head");
        avalibleCommand.add("add_if_max");
        avalibleCommand.add("add_if_min");
        avalibleCommand.add("max_by_type");
        avalibleCommand.add("print_ascending");
        avalibleCommand.add("print_unique_head");
        return avalibleCommand;
    }
    public static ArrayList<String> promptsListtocreate(){
        promptstocreate.add("Введите имя дракона");
        promptstocreate.add("Сколько лет дракону");
        promptstocreate.add("Размах крыла");
        promptstocreate.add("Говорящий?\n" + "TRUE|FALSE");
        promptstocreate.add("Координата Х");
        promptstocreate.add("Координата У");
        promptstocreate.add("Количество зубов");
        promptstocreate.add("Тип дракона\n" + "Доступные типы:\n" + "FIRE\n" + "WATER\n" + "UNDERGROUND");
        promptstocreate.add("Дракон успешно добавлен");
        return promptstocreate;
    }
    public static int count(LinkedList<Dragon> elements){
        return elements.size();
    }
}
