package ge.edu.btu.chat.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket;
        Scanner scanner = new Scanner(System.in);
        String sent;
        String recieve;

        socket = new Socket("localhost",8081);
        System.out.println("მიმდინარეობს დაკავშირება...");
        while(true){
            System.out.println("კითხვა");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            sent = scanner.nextLine();
            objectOutputStream.writeObject(sent);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                recieve = (String) objectInputStream.readObject();
                System.out.println("პასუხი : " + recieve);
            }
            catch (Exception e){e.printStackTrace();
                System.out.println("სცადეთ თავიდან " + e);
            }

        }
    }
}
