package mdk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description ToDo
 * @Author MDK
 * @Date 2019/4/9 9:28
 * @Version 1.0
 **/
public class ora {
    public static void main(String[] args) {
        //192.168.8.47
        String ip = "192.168.8.47";
        String port = "1521";
        String sid = "orcl";
        String user = "mdk";
        String pwd = "admin123";
        String url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;
        testOracle db= null;
        boolean bool = false;        //用作判定是否发生异常
        Integer bigNum = 10000;     //用于记录执行条数
        try {
            for (int i = 1; i<=50; i++){
                db= new testOracle(url, user, pwd, false);      //创建连接
                bool = db.execute("insert into tab_b(column1,column2) values("+i+",'test0419')");
                System.out.println("current loop: "+String.valueOf(i));
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        db.executeCommit();     //执行提交
        db.close();     //关闭连接
    }
}
















/*
*
* if (i%3==0){
                    //insert语句
                    bool = db.execute("insert into tab_m(column1,column2,column3) values('mark_"+i+"','ins_test','col3notnull')");
                }else if (i%5==0){
                    //insert语句
                    bool = db.execute("insert into tab_m(column1,column2) values('mark_"+i+"','col3null')");
                }else if (i%10==0){
                    //insert语句
                    bool = db.execute("insert into tab_k(column1,column2) values('mark_"+i+"','col3null')");
                }else if (i%50==0){
                    bool = db.execute("insert into tab_k(column1,column2,column3) values('mark_"+i+"','col3null','tab_knotnull')");
                }
* */