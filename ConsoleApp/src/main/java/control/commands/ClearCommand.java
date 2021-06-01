package control.commands;

import model.Dragon;
/**
 * Запуск команды
 * @throws Exception
 */
public class ClearCommand extends Command {
    public void execute() throws Exception {
        Dragon.getDragonsCollection().clear();
        System.out.println("Список успешно отчищен");
    }
}
