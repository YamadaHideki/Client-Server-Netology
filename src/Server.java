import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        String clientName = null;
        boolean clientIsChild = false;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Write your name");
            clientName = in.readLine();
            out.println("Are u child? (yes/no)");
            String childYesOrNo = in.readLine();

            if(childYesOrNo.equals("yes")) {
                clientIsChild = true;
                out.println(String.format("Welcome to the kids area, %s! Let's play!", clientName));
            } else if (childYesOrNo.equals("no")) {
                clientIsChild = false;
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", clientName));
            } else {
                out.println("Good bye!");
            }

            serverSocket.close();
        }
    }
}
