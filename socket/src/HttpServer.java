import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This program will open up a ServerSocket listening for connections on port :8080.
 * When a client connects, the server will retrieve it's input and output streams, read
 * and print out the HTTP request status line before it sends back a HTTP response.
 * @author folkol
 */
public class HttpServer {

    public static void main(String[] args) throws Exception {
        String payload = "<!DOCTYPE html><html><body><h1>Hello World</h1></body></html>";
        String statusLine = "HTTP/1.1 200 OK\r\n";
        String headers =
            "Connection: close\r\n" +
            "Content-Length: 61\r\n" +
            "Content-Type: text/html\r\n";
        String headerDelimiter = "\r\n";

        ServerSocket server = new ServerSocket(8080);
        while(true) {
            Socket connection = server.accept();

            BufferedReader request = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(request.readLine());

            OutputStream response = connection.getOutputStream();
            response.write(statusLine.getBytes());
            response.write(headers.getBytes());
            response.write(headerDelimiter.getBytes());
            response.write(payload.getBytes());

            connection.close();
        }
    }
}
