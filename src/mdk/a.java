package mdk;

/**
 * @Description ToDo
 * @Author MDK
 * @Date 2019/4/18 9:44
 * @Version 1.0
 **/
public class a {
    public static void main(String[] args) {
        for (int i =1;i<=10000;i++){
            if (i%100==0){
                System.out.println("insert into tab_m(column1,column2) values('mark_" + i + "','isnull');");
            }else{

                System.out.println("insert into tab_m(column1,column2,column3) values('mark_" + i + "','col2','mnotnull');");

            }
        }
    }
}
