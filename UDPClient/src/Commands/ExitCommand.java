package Commands;

import ConsoleMod.ConsoleMod;

public class ExitCommand extends Command{

    @Override
    public void execute() {
        ConsoleMod.setTreat(false);
    }
}
