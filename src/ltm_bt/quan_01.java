/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm_bt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class quan_01 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.188.19.218", 1605);
        client.setSoTimeout(5000);
        
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        String s = "B21DCCN621;e4zoHWm";
//        byte[] send = new byte[1024];
//        send = s.getBytes();
        out.writeUTF(s);
        
        DataInputStream in = new DataInputStream(client.getInputStream());
        byte[] rev = new byte[1024];
        String s1 = in.readUTF();
        
        String s2 = new StringBuilder(s1).reverse().toString();
        out.writeUTF(s2);
        
        in.close();
        out.close();
        client.close();
    }
}
