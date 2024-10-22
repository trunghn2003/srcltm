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
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class client_04 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String send = ";B21DCCN321;QKXx31BO";
        DatagramPacket dpSend = new DatagramPacket(send.getBytes(), send.length(), serverAddress, port);
        client.send(dpSend);
        
        byte[] rec = new byte[1024];
        DatagramPacket dpRec = new DatagramPacket(rec, rec.length);
        client.receive(dpRec);
        
        String strRec = new String(dpRec.getData());
        System.out.println(strRec);
        
        String[] list = strRec.trim().split(";");
        String[] so = list[1].trim().split(",");
        int[] daySo = new int[so.length];
        for(int i=0; i<so.length; i++) {
            daySo[i] = Integer.parseInt(so[i]);
        }
        //System.out.println(daySo);
        Arrays.sort(daySo);
        String kq = list[0] + ";" + daySo[daySo.length-2] + "," + daySo[1];
        client.send(new DatagramPacket(kq.getBytes(), kq.length(), serverAddress, port));
        
        client.close();
    }
}
