/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm_bt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
public class client_bai2 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.188.19.218", 1606);
        client.setSoTimeout(100000);
        // Gửi chuỗi
        String s = "B21DCCN321;sxCt7bY";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bw.write(s, 0, s.length());
        bw.newLine();
        bw.flush();
        
        // Nhận chuỗi
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s1 = br.readLine();
        
        //System.out.println(s1);
        
        // Xử lý chuỗi và gửi
        String s2 = s1.replaceAll("[aeiou]", "");
        bw.write(s2);
        
        // Đóng kết nối
        br.close();
        bw.close();
        client.close();
        
    }
}
