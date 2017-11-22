/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendrequesthttp;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author slotcz
 */
public class SendRequestHTTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader in = null;
        String strURL = "http://localhost:8080/webappSTB"; // 8585
        strURL = strURL + "/upgrade/fdi/check_version_ext";
        strURL = strURL + "/?output=text&board=sml_amls905d&mac=E427714CC758&serial=A0I0B335FG0173400031&current_firmware_version=4.8.87";
        //strURL = strURL + "/TestPage.html";
        try {
            // TODO code application logic here
            URL yahoo = null;
            try {
                yahoo = new URL(strURL); // http://www.yahoo.com/
            } catch (MalformedURLException ex) {
                Logger.getLogger(SendRequestHTTP.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-10);
            }
            URLConnection yc = null;
            try {
                yc = yahoo.openConnection();
            } catch (IOException ex) {
                Logger.getLogger(SendRequestHTTP.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-11);
            }
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(SendRequestHTTP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(SendRequestHTTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
