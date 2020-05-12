package com.example;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Xiamuzi
 * @version 1.0
 * @date 2020/5/1 18:07
 */
public class demo {
    static Info infor = new Info();
    public static void main(String[] args) {
        /*
         * 接收客户端发送的数据
         */
        //1.创建服务器端DatagramSocket，指定端口
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8800);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true) {
            //2.创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[9];//创建字节数组，指定接收的数据包的大小
            DatagramPacket packet = new DatagramPacket(data, data.length);
            //3.接收客户端发送的数据
            System.out.println("****服务器端已经启动，等待客户端发送数据");
            try {
                socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes = packet.getData();
            String info = getBufHexStr(bytes);
            //4.读取数据
//            String info = new String(data, 0, packet.getLength());
            System.out.println("我是服务器，客户端说：" + info);

            //123456789 10 11 12 13 14 15 16 17 18
            infor.setUserid(Integer.parseInt(info.substring(0,1)));
            infor.setHeartreat(Integer.parseInt(info.substring(1,3)));
            infor.setOxygen((float) (Float.parseFloat(info.substring(3,5))/100.0));
            infor.setPressurehigh(Integer.parseInt(info.substring(5,8)));
            infor.setPressuredown(Integer.parseInt(info.substring(8,11)));
            String str = info.substring(11,13);
            str.concat(".");
            str.concat(info.substring(13,14));
            infor.setTemperature(Float.parseFloat(str));
            infor.setEcg(Integer.parseInt(info.substring(14)));
            infor.setTime(new Date());
            System.out.println(infor.toString());
            ServerThread thread = new ServerThread(socket);
            thread.start();
            /*
             * 向客户端响应数据
             */
            //1.定义客户端的地址、端口号、数据
//            InetAddress address = packet.getAddress();
//            int port = packet.getPort();
//            byte[] data2 = "欢迎您!".getBytes();
            //2.创建数据报，包含响应的数据信息
//            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            //3.响应客户端
//            try {
//                socket.send(packet2);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //4.关闭资源
//            socket.close();
        }
    }
    //将16进制的byte数组转换成字符串
    public static String getBufHexStr(byte[] raw){
        String HEXES = "0123456789ABCDEF";
        if ( raw == null ) {
            return null;
        }
        final StringBuilder hex = new StringBuilder( 2 * raw.length );
        for ( final byte b : raw ) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }
}