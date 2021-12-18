package main;


import de.m.mapi.tcp.TcpServer;
import listeners.TcpCommandListener;
import managers.TcpCommandManager;

import javax.security.auth.login.LoginException;

public class Main {
    public static Main INSTANCE;
    private TcpCommandManager TcpCmdMan;
    public static TcpServer tcpServer;

    public static void main(String[] args) {
        try {
            new Main();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        tcpServer = new TcpServer(9999);
        tcpServer.start();
        TcpCommandListener.tcpCommandListener();
    }
    public TcpCommandManager getTcpCmdMan(){
        return TcpCmdMan;
    }
    public Main(){
        INSTANCE = this;
        this.TcpCmdMan = new TcpCommandManager();
    }
}
