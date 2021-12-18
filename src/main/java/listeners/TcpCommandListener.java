package listeners;

import de.m.mapi.tcp.MSocket;
import de.m.mapi.tcp.TcpEventHandler;
import main.Main;
import managers.TcpCommandManager;

public class TcpCommandListener {
    public static void tcpCommandListener() {

        TcpEventHandler handler = new TcpEventHandler() {
            @Override
            public void onMessageReceived(MSocket socket, String message) {
                super.onMessageReceived(socket, message);
                System.out.println(message);

                String[] args = message.split(" ");
                if(Main.INSTANCE.getTcpCmdMan().perform(socket, message)){
                    System.out.println("Unbekannter Command:  " + message);
                }
            }
        };
        Main.tcpServer.addListeners(handler);

    }
}
