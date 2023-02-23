import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Java program to create a simple HTTP Server to demonstrate how to use
 * ServerSocket and Socket class.
 *
 * @author Javin Paul
 */
public class HTTPDemo {
    public static void main(String[] args) throws IOException{

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening to connection on port 8080.....");
        while(true){
            try(Socket socket = server.accept()) {
                Date today = new Date();
                String httpsResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream().write(httpsResponse.getBytes("UTF-8"));
            }
        }
    }

}
