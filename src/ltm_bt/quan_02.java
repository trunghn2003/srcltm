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

/**
 *
 * @author Admin
 */
public class quan_02 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.188.19.218", 1606);
        client.setSoTimeout(5000);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String s = "B21DCCN621;JCEUfc8";
        bw.write(s);
        bw.newLine();
        bw.flush();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s1 = br.readLine();
        System.out.println(s1);
        String[] list = s1.split(", ");
        
        StringBuilder s2 = new StringBuilder();
        for(int i=0; i<list.length; i++) {
            System.out.println(list[i]);
            if(list[i].endsWith(".edu")) {
                s2.append(list[i]).append(", ");
            }
        }
        String output = s2.toString();
        System.out.println(output);
        output = output.substring(0, output.length()-2);
        System.out.println(output);
        bw.write(output);
        bw.newLine();
        bw.flush();
        
        br.close();
        bw.close();
        client.close();
    }
}
