package socket.pkg1.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimePrinter extends Thread {

    BufferedReader in;
    PrintWriter out;
    Socket s;

    public TimePrinter(Socket s) throws IOException {
        this.s = s;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
    }

    @Override
    public void run() {
        while (!out.checkError()) {
            try {
                in.readLine();
                DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.ENGLISH);
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
                dateFormatYear.setTimeZone(TimeZone.getTimeZone("UTC"));

                Date date = new Date();

                out.printf("%s UTC %s\n", dateFormat.format(date), dateFormatYear.format(date));
            } catch (IOException ex) {
                Logger.getLogger(TimePrinter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Socket disconnected");
    }
}
