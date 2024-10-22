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
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class client_02 {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        DatagramSocket client = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        
        String send = ";B21DCCN321;RKm2xMyh";
        DatagramPacket dp = new DatagramPacket(send.getBytes(), send.length(), serverAddress, port);
        client.send(dp);
     
        byte[] rec = new byte[1024];
        DatagramPacket dpRec = new DatagramPacket(rec, rec.length);
        client.receive(dpRec);
        
        String stringRec = new String(dpRec.getData(), 0, dpRec.getLength(), StandardCharsets.UTF_8);
        String[] list = stringRec.trim().split(";");
        String[] so = list[1].trim().split(",");
        int[] ds = new int[so.length];
        for(int i=0; i<so.length; i++) {
            ds[i] = Integer.parseInt(so[i]);
            System.out.print(so[i] + " ");
        }
        for(int i=0; i<so.length; i++) {
            System.out.print(so[i] + " ");
        }
        Arrays.sort(ds);
        int min = ds[0];
        int max = ds[ds.length-1];
        String kq = list[0] + ";" + max + "," + min;
        System.out.println(kq);
        client.send(new DatagramPacket(kq.getBytes(), kq.length(), serverAddress, port));
    }
}
