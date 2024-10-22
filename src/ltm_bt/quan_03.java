/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm_bt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class quan_03 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.188.19.218", 1604);
        //client.setSoTimeout(5000);
        
        OutputStream out = new DataOutputStream(client.getOutputStream());
        String s = "B21DCCN621;vjuqeYx";
        byte[] send = new byte[1024];
        send = s.getBytes();
        out.write(send);
        out.flush();
        
        InputStream in = new DataInputStream(client.getInputStream());
        byte[] rev = new byte[1024];
        in.read(rev);
        String s1 = new String(rev);
        //System.out.println(s1);
        String[] list = s1.trim().split("\\|");
        int a = Integer.parseInt(list[0].trim());
        int b = Integer.parseInt(list[1].trim());
        //System.out.println(a + " " + b);
        int kq = (int) (Math.pow(a, b));
        //System.out.println(kq);
        out.write(String.valueOf(kq).getBytes());
        out.flush();
        
        in.close();
        out.close();
        client.close();
       
        
    }
}
