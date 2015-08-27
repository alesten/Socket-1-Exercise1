/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.pkg1.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author AlexanderSteen
 */
public class Socket1Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        int port = 1234;

        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));
        while (true) {            
            new TimePrinter(ss.accept()).start();
        }
    }
}
