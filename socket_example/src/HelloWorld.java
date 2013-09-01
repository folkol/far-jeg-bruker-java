import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while(true) {
            Socket accept = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            OutputStream out = accept.getOutputStream();

            System.out.println(in.readLine());

            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("\r\n".getBytes());
            out.write("<html><body>Hello World</body></html>".getBytes());

            accept.close();
        }
    }
}
