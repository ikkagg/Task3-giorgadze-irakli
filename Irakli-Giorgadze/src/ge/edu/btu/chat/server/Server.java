package ge.edu.btu.chat.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket;
        Socket socket;
        ServerThread serverThread;

        serverSocket = new ServerSocket(8081);
        System.out.println("სერვერთან წარმატებით დაკავშირდა");
        socket = serverSocket.accept();

        while(true){
            serverThread = new ServerThread(socket);
            serverThread.start();
            serverThread.join();
        }
    }
}
