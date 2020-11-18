package ge.edu.btu.chat.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket client;
    private String pas;

    public ServerThread(Socket Client){
        this.client = Client;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            String stringi = (String) objectInputStream.readObject();
            switch (stringi){
                case "გამარჯობა":
                    pas = "მოგესალმები, რით შემიძლია დაგეხმარო?";
                    System.out.println(pas);
                    break;
                case "მაჩვენე კურსი":
                    pas = "3,31";
                    System.out.println(pas);
                    break;
                case "მაჩვენე ფილიალები":
                    pas = "ი.ჭავჭავაძის გამზ., გურამიშვილის გამზ.";
                    System.out.println(pas);
                    break;
                case "ნახვამდის":
                    pas = "გმადლობთ რომ სარგებლობთ ჩვენი სერვისით";
                    System.out.println(pas);
                    break;
                default:
                    pas = "ამ კითხვაზე პასუხი არ მაქვს";
                    System.out.println(pas);
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(pas);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("სცადეთ თავიდან");
        }
    }
}
