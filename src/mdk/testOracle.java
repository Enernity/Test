package mdk;

import java.sql.*;

/**
 * @Description ToDo
 * @Author MDK
 * @Date 2019/4/9 9:35
 * @Version 1.0
 **/
public class testOracle {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public testOracle(String url, String user, String pwd, boolean b_auto) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            DriverManager.setLoginTimeout(20);
            conn = DriverManager.getConnection(url, user, pwd);
            conn.setAutoCommit(b_auto);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(url + "---" + user + "---" + pwd);
            System.exit(0);
        }
    }

    public boolean executeCommit() {
        try {
            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean executeRollback() {
        try {
            conn.rollback();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean executeUpdate(String sql) {
        try {
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());

            return false;
        }
    }

    public boolean execute(String sql) {
        try {
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());

            //对于ORA01000：超出打开游标的最大数的错误
            //直接退出apply让agent再重新启动apply
            if (e.toString().contains("ORA-01000")) {
                System.exit(0);
            }

            return false;
        }
    }

    public ResultSet executeQuery(String sql) {
        rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
    }


    public void close() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }
}

