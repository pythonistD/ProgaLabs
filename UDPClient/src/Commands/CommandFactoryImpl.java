package Commands;

public class CommandFactoryImpl implements Interfaces.CommandFactory {
    public Command chooseCommand(String commandLine){
        Command command = null;
        switch (commandLine){
            case "help":
                command = new HelpCommand();
                break;
            case "exit":
                command = new ExitCommand();
                break;
            case "show":
                command = new ShowCommand();
                break;
            case "add":
                command = new AddCommand();
                break;
            case "update":
                command = new UpdateCommand();
                break;
            case "remove_by_id":
                command = new Remove_by_idCommand();
                break;
            case "info":
                command = new InfoCommand();
                break;
            case "max_by_type":
                command = new Max_by_typeCommand();
                break;
            case "print_ascending":
                command = new Print_AscendingCommand();
                break;
            case "remove_head":
                command = new Remove_headCommand();
                break;
            case "save":
                command = new SaveCommand();
                break;
            case "clear":
                command = new ClearCommand();
                break;
            case "execute_script":
                command = new Execute_ScriptCommand();
                break;
            case "add_if_max":
                command = new Add_If_MaxCommand();
                break;
            case "add_if_min":
                command = new Add_If_MinCommand();
                break;
            case "print_unique_head":
                command = new Print_Unique_HeadCommand();
                break;


        }
    return command;

    }
}
