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
        Socket s = ss.accept();
        
        BufferedReader in;
        PrintWriter out;
        
        while(true){
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                out = new PrintWriter(s.getOutputStream(), true);
                in.readLine();
                
                DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.ENGLISH);
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
                dateFormatYear.setTimeZone(TimeZone.getTimeZone("UTC"));

                Date date = new Date();

                out.printf("%s UTC %s\n", dateFormat.format(date), dateFormatYear.format(date));
        }
    }
    
}
