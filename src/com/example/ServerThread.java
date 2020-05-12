package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Xiamuzi
 * @version 1.0
 * @date 2020/5/1 20:37
 */
public class ServerThread extends Thread {
    DatagramSocket socket;
    DataInputStream in = null;
    DataOutputStream out = null;

    //JDBC初始化
    //JDBC驱动名及数据库URL
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://121.199.28.87:3306/bsnew?useSSL=false&serverTimezone=GMT%2B8";
    //数据库的用户名和密码
    final String username = "root";
    final String password = "root";
    //jdbc
    Connection conn = null;

    ServerThread(DatagramSocket t) {
        socket = t;

    }

    public void run() {

//        while (true){
            try{
                //注册JDBC驱动
                Class.forName("com.mysql.jdbc.Driver");
                //打开链接
                System.out.println("连接数据库...");
                conn = DriverManager.getConnection(DB_URL,username,password);
                //执行插入操作
                String sql = "insert into info(userid,heartreat,oxygen,pressurehigh,pressuredown,temperature,ecg,times) values(?,?,?,?,?,?,?,?)";
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1,demo.infor.getUserid());
                pstm.setInt(2,demo.infor.getHeartreat());
                pstm.setFloat(3,demo.infor.getOxygen());
                pstm.setInt(4,demo.infor.getPressurehigh());
                pstm.setInt(5,demo.infor.getPressuredown());
                pstm.setFloat(6,demo.infor.getTemperature());
                pstm.setInt(7,demo.infor.getEcg());
                pstm.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
                 //执行
                pstm.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
//        }
    }
}
