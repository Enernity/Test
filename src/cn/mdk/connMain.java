package cn.mdk;

/**
 * @Description ToDo
 * @Author MDK
 * @Date 2019/4/11 16:14
 * @Version 1.0
 **/
public class connMain {
    static String ip = "192.168.8.47";
    static String port = "1521";
    static String sid = "orcl";
    static String user = "mdk";
    static String pwd = "admin123";
    static String url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;
    public static void main(String[] args) {
        connMethod connOra = new connMethod(url,user,pwd);
        boolean judge = false;        //用作判定是否发生异常
        Integer totalNum = 0;     //用于记录执行条数
        for (int i = 1; i <= 10; i++){
            
            /*insert语句*/
            judge = connOra.execute("insert into table0411_1 values('mark_"+i+"','ins_test','ins_test02')");
            totalNum += 1;
            if (judge){
                System.out.println("操作发生异常...");
                break;
            }else{
                System.out.println("正常执行第"+i+"次操作...");
            }
        }
        if (judge){
            connOra.rollback();
            connOra.closed();
            connOra.connClose();
            if (connOra.isClosed()&&connOra.connIsClose()){
                System.out.println("执行回滚,关闭Statement数据操作接口,释放此 Connection 对象,释放系统资源...");
            }else{
                System.out.println("释放资源失败...");
            }
        }else {
            connOra.commit();
            connOra.closed();
            connOra.connClose();
            if (connOra.isClosed()&&connOra.connIsClose()){
                System.out.println("执行提交,关闭Statement数据操作接口,释放此 Connection 对象,释放系统资源...");
            }else{
                System.out.println("释放资源失败...");
            }
        }

    }


}
