package ass5;

import java.io.*;
import java.net.*;

public class MutualServer implements Runnable {
    Socket socket = null;
    static ServerSocket ss;

    MutualServer(Socket newSocket) {
        this.socket = newSocket;
    }

    public static void main(String args[]) throws IOException {
        ss = new ServerSocket(7000); // Creating a server socket on port 7000
        System.out.println("Server Started"); // Print a message indicating that the server has started
        while (true) {
            Socket s = ss.accept(); // Accept incoming connections
            MutualServer es = new MutualServer(s); // Create a new MutualServer object for each connection
            Thread t = new Thread(es); // Create a new thread to handle the connection
            t.start(); // Start the thread
        }
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Create a BufferedReader to read input from the client
            while (true) {
                System.out.println(in.readLine()); // Continuously read input from the client and print it to the console
            }
        } catch (Exception e) {
            // Exception handling
        }
    }
}
