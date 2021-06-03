package Commands;


import ConsoleMod.Application;

public class ExitCommand extends Command{

    @Override
    public void execute() {
        Application.setTreat(false);
    }
}
