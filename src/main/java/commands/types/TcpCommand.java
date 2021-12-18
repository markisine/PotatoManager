package commands.types;

import de.m.mapi.tcp.MSocket;

public interface TcpCommand {
    void PerformCommand(MSocket socket, String message) throws InterruptedException;
}
