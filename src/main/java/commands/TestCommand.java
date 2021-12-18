package commands;

import commands.types.TcpCommand;
import de.m.mapi.tcp.MSocket;

public class TestCommand implements TcpCommand {
    @Override
    public void PerformCommand(MSocket socket, String message) throws InterruptedException {
        System.out.println("kek test command");
    }
}
