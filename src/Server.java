import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try {
            //Создаем сокет-слушатель
            ServerSocket socketListener = new ServerSocket(Config.PORT);

            while (true) {
                Socket client = null;
                while (client == null) {
                    client = socketListener.accept();
                }
                new ClientThread(client); //Создаем новый поток, которому передаем сокет
            }
        } catch (SocketException e) {
            System.err.println("Socket exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O exception");
            e.printStackTrace();
        }
    }
}