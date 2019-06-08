package com.thisAndSuper;

import java.sql.*;

public class MysqlDemo {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        //serverTimezoned的参数可选，例如GMT
        String url = "jdbc:mysql://localhost:3306/world?useSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC";
        String user = "root";
        String password = "271828";

        try {
            //加载驱动程序
            Class.forName(driver);
            //getConnection()方法，连接Mysql数据库
            conn = DriverManager.getConnection(url, user, password);

            if (!conn.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
            }

            //创建statement类对象，用来执行sql语句
            Statement statement = conn.createStatement();
            //要执行的sql语句
            String sql = "select * from city c where c.ID = 1";
            //ResultSet类，用来存放获取的结果集
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("学校" + "\t" + "时间");
            System.out.println("-----------------");

            String university = null;
            String time = null;
            while (rs.next()){
                university = rs.getString(2);
                time = rs.getString(4);
                System.out.println(university + "\t" + time);
            }

            rs.close();
            conn.close();
        }catch (ClassNotFoundException e){
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }catch (SQLException e){
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e){
            //TODO: handle exception
            e.printStackTrace();
        }finally {
            System.out.println("数据库数据成功获取！！");
        }
    }
}
