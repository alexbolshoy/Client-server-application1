package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 15956;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            String yourName = in.readLine();
            System.out.println(yourName);

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            out.println(name);
            String resp = in.readLine();
            System.out.println(resp);

            String yOrN = scanner.nextLine();
            out.println(yOrN);
            String child = in.readLine();
            System.out.println(child);

            String byServer = in.readLine();
            System.out.println(byServer);

            String yesOrNo = scanner.nextLine();
            out.println(yesOrNo);
            String seeYou = in.readLine();
            System.out.println(seeYou);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
