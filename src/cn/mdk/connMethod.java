package cn.mdk;

import java.sql.*;

/**
 * @Description 连接方法
 * @Author MDK
 * @Date 2019/4/11 16:05
 * @Version 1.0
 **/
public class connMethod {
    Connection conn = null;     // 创建一个数据库连接
    Statement stment = null;// 创建预编译语句对象
    ResultSet rs = null;        // 创建一个结果集对象
    String driver = "oracle.jdbc.OracleDriver";    //驱动标识符
    public connMethod(String url, String user, String pwd){
        try {
            Class.forName(driver);   //添加连接驱动
            conn = DriverManager.getConnection(url, user, pwd);
            conn.setAutoCommit(false);      //false为手动提交,true为自动提交
            stment = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean execute(String sql){
        try {
            stment.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
            return false;
        }

    }

    /*
    * 方法 executeQuery 用于产生单个结果集的语句，例如 SELECT 语句。
    * */
    public  ResultSet executeQuery(String sql){
        try {
            rs = stment.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
            return null;
        }
    }

    /*
    * 方法 executeUpdate 用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
    * 返回值是一个整数，指示受影响的行数（即更新计数）
    * */
    public int executeUpdate(String sql){
        try {
            return stment.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
            return 0;
        }
    }

    /*
    * 关闭这个操作数据的接口
    * */
    public void closed(){
        try {
            stment.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
        }
    }

    /*
    * 验证是否已关闭了此 Statement 对象。
    * */
    public boolean isClosed(){
        try {
            return stment.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
            return false;
        }
    }

    /*
    * Commit提交方法
    * */
    public void commit(){
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
        }
    }

    /*
    * 回滚方法
    * */
    public void rollback(){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
        }
    }

    /*
    *查询此 Connection 对象是否处于只读模式。
     * */
    public boolean isReadOnly(){
        try {
            return conn.isReadOnly();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
            return false;
        }
    }

    /*
    * 立即释放此 Connection 对象的数据库和 JDBC 资源
    * */
    public void connClose(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常状况为:"+e.toString());
        }
    }

    /*
    * 验证是否释放此 Connection 对象的数据库和 JDBC 资源
    * */
    public boolean connIsClose(){
        try {
            return conn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
