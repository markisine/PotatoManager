package managers;

import commands.TestCommand;
import commands.types.TcpCommand;
import de.m.mapi.tcp.MSocket;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TcpCommandManager {

    // Strings
        public static String test = "test";
    //

    public ConcurrentMap<String, TcpCommand> commands;

    public TcpCommandManager() {
        //this.commands.put(String, Command)
        this.commands = new ConcurrentHashMap<>();
        this.commands.put("test", new TestCommand());

    }
    public boolean perform(MSocket socket, String message) {
        TcpCommand cmd;
        if ((cmd = this.commands.get(message.toLowerCase())) != null) {
            try {
                cmd.PerformCommand(socket,message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
