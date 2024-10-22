/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LTM_BT_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
public class client_01 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        // Gửi dữ liệu
        String send = ";B21DCCN321;xjOrS1Tp";
        DatagramPacket dp = new DatagramPacket(send.getBytes(), send.length(), serverAddress, port);
        client.send(dp);
        
        // Nhận dữ liệu
        byte[] rec = new byte[1024];
        DatagramPacket dpRec = new DatagramPacket(rec, rec.length);
        client.receive(dpRec);
        String s = new String(dpRec.getData(), 0, dpRec.getLength(), StandardCharsets.UTF_8);
        String[] list = s.trim().split(";");
        list[1] = list[1].toLowerCase();
        String[] tu = list[1].trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<tu.length; i++) {
            sb.append(Character.toUpperCase(tu[i].charAt(0)));
            sb.append(tu[i].substring(1));
            sb.append(" ");
        }
        String tuXL = sb.toString().substring(0, sb.length()-1);
        String kq = list[0] + ";" + tuXL;
        System.out.println(kq);
        kq.getBytes();
        kq.length();
        DatagramPacket dpKq = new DatagramPacket(kq.getBytes(), kq.length(), serverAddress, port);
        client.send(dpKq);
        
        client.close();
        //StringBuilder sb = new StringBuilder(list[1]);
//        for(int i=0; i<list[1].length(); i++) {
//            
//        }
        //String kq = list[1][0].toUpperCase();
    }
}



//package UDP.ByteStream.QuestionCode801;
//
//import java.io.IOException;
//import java.net.*;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;

//public class Client {
//    public static String getResult(String s){
//        String res = "";
//        String regex = "[,;\\s]+";
//        String[] strings = s.split(regex);
//        res += strings[0];
//        int n = Integer.parseInt(strings[1]);
//        ArrayList<Integer> number = new ArrayList<>();
//        for(int i = 2; i < strings.length; i++){
//            int x = Integer.parseInt(strings[i]);
//            number.add(x);
//        }
//        for(int i = 0; i <= n; i++){
//            if(!number.contains(i)){
//                res += Integer.toString(i)+", ";
//            }
//        }
//        return res.substring(0,res.length()-1);
//    }
//    public static void main(String[] args) {
//        DatagramSocket client = null;
//        try{
//            InetAddress serverAddress = InetAddress.getByName("26.46.130.38");
//            int port = 2207;
//            client = new DatagramSocket();
//            //Gui du lieu len server
//            String fMsgSend = "B19DCCN530;801";
//            DatagramPacket fPacketSend = new DatagramPacket(fMsgSend.getBytes(StandardCharsets.UTF_8), fMsgSend.length(),serverAddress,port);
//            client.send(fPacketSend);
//            //Nhan du lieu tu server gui vèe
//            byte[] bytes = new byte[1024];
//            DatagramPacket fPacketRec = new DatagramPacket(bytes, bytes.length);
//            client.receive(fPacketRec);
//            String fMsgRec = new String(fPacketRec.getData(),0,fPacketRec.getLength(), StandardCharsets.UTF_8);
//            System.out.println(fMsgRec);
//            //Xu ly du lieu
//            String result = getResult(fMsgRec);
//            DatagramPacket sPacketSend = new DatagramPacket(result.getBytes(StandardCharsets.UTF_8),result.length(),serverAddress,port);
//            client.send(sPacketSend);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
