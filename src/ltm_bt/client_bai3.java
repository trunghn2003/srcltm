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
public class client_bai3 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.188.19.218", 1605);
        client.setSoTimeout(5000);
        String s = "B21DCCN321;vpB5IIG";
        // Gửi xâu
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeUTF(s);
        
        // Nhận xâu
        DataInputStream in = new DataInputStream(client.getInputStream());
        String receive = in.readUTF();
        
        // Đảo ngược và gửi
        String send = new StringBuilder(receive).reverse().toString();
        out.writeUTF(send);
        
        // Đóng kết nối
        in.close();
        out.close();
        client.close();
        
    }
}
