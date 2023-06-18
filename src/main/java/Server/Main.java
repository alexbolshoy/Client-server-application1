package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 15956;
        try (ServerSocket serverSocket = new ServerSocket(port)) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    out.println("Write your name?");
                    System.out.println("New connection accepted.");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s. Are you child? (yes/no)", name, clientSocket.getPort()));
                    final String child = in.readLine();
                    if (child.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                    }
                    out.println("Bye. hope we had a great time.(yes/no)");
                    final String greatTime = in.readLine();
                    if (greatTime.equals("yes")) {
                        out.println(String.format("see you, %s", name));
                    } else {
                        out.println(String.format("see you, %s. hope next time will be better", name));
                    }
                }
            }
        }
    }
}
