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
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
public class client_bai1 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.188.19.218", 1604);
        client.setSoTimeout(5000);
        
        // Gửi data
        String s = "B21DCCN321;tikTtxG";
        byte[] send = s.getBytes();
        OutputStream out = new DataOutputStream(client.getOutputStream());
        out.write(send);
        out.flush();
        
        // Nhận data
        InputStream in = new DataInputStream(client.getInputStream());
//        byte[] rev = i n.readAllBytes();
////        String s1 = rev.toString();
//        String s1 = new String(rev);
//        //System.out.println(s1);
        byte[] rev = new byte[1024];
        in.read(rev);
        String s1 = new String(rev);
        
        // Tính tổng
        String[] list = s1.trim().split("\\|");
        int tong = 0;
        for(int i=0; i<list.length; i++){
            //System.out.println(list[i]);
            tong+=Integer.parseInt(list[i]);
            //System.out.println(list[i]);  
        }
        //System.out.println(tong);
        out.write(String.valueOf(tong).getBytes());
        out.flush();
        
//        int i=0;
//        int tong = 0;
//        while(s1.contains("|")){
//            int a = Integer.parseInt(s1.substring(0, s1.indexOf("|")));
//            tong += a;
//            s1 = s1.substring(s1.indexOf("|")+1);
//        }
//        tong+=Integer.parseInt(s1);
//        out.write(tong);
//        out.flush();

        // Đóng kết nối
        in.close();
        out.close();
        client.close();

//        Socket socket = new Socket("172.188.19.218", 1604 );
//        InputStream is = socket.getInputStream();
//        OutputStream os = socket.getOutputStream();
//        String msv = "B21DCN321" + ";" +"tikTtxG";
//        byte[] send = msv.getBytes(StandardCharsets.UTF_8);
//        os.write(send);
//        os.flush();
//        
//        byte[] receive = new byte[1024];
//        is.read(receive);
//        
//        String s = new String(receive);
//        String [] s1 = s.split("\\|");
//        int tong = 0;
//        for(int i = 0; i < s1.length - 1; i ++){
//           tong += Integer.parseInt(s1[i].trim());
//        }
//        byte[] sendBytes = String.valueOf(tong).getBytes(StandardCharsets.UTF_8);
//        os.write(sendBytes);
//        os.flush();
//        
//        os.close();
//        is.close();
//        socket.close();
    }
}
