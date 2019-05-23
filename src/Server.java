import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.exit;

public class Server {

    ServerSocket socket;

    public Server(int port){
        try {
            socket = new ServerSocket(port);
            System.out.println("Starting server on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void go(){
        try {
            Socket client = socket.accept();
            System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
            Scanner input = new Scanner(client.getInputStream());

            while (input.hasNextLine()){

                System.out.println("Received message " + input.nextLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main (String[] args){

        if(args.length!=1) {
            System.out.println("Usage: java server <port>");
            exit(-1);
        }

        Server server   = new Server(Integer.parseInt((args[0])));
        server.go();
    }
}
