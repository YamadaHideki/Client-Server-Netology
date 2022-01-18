import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        String host = "netology.homework";
        int port = 8080;
        Scanner scanner = new Scanner(System.in);

        try(Socket clientSocket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while(!clientSocket.isClosed()) {
                System.out.println(in.readLine());
                out.println(scanner.nextLine());
            }
        }
    }
}
