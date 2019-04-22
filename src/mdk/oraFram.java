package mdk;

import javax.swing.*;
import java.awt.*;

/**
 * @Description ToDo
 * @Author MDK
 * @Date 2019/4/9 16:36
 * @Version 1.0
 **/
public class oraFram extends JFrame {
    private static final long serialVersionUID = 1L;
    private Button btn;    //按钮
    private TextField ip;
    private TextField port;
    private TextField userName;
    private TextField password;

    public oraFram (){
        shezhi();
        UpPanel();
        DownPanel();
        this.repaint();
    }
    private void shezhi() {
        this.setSize(350, 420); // 设置窗体大小
        this.setTitle("执行程序"); // 设置窗体标题
        this.setResizable(true); // 设置是否可调整大小

        this.setLocation(400, 200);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setVisible(true); // 设置窗体是否可见
        this.repaint();
    }


    public void UpPanel() {
        Panel up = new Panel(); // 创建上面的Pabel
        up.setSize(460, 220);
        up.setLocation(60, 200);
        up.setLayout(new GridLayout(3, 3, 3, 2));
        ip = new TextField(10);
        port = new TextField(10);
        userName = new TextField(10);
        password = new TextField(10);

        JLabel label1 = new JLabel("IP:");
        JLabel label2 = new JLabel("端口:");
        JLabel label3 = new JLabel("用户名:");
        JLabel label4 = new JLabel("密码:");

        up.add(label1);
        up.add(ip);
        //up.add(new Label("\r\n"));
        up.add(label2);
        up.add(port);
        up.add(label3);
        up.add(userName);
        up.add(label4);
        up.add(password);
        /*设置颜色*/
        label1.setForeground(Color.RED);
        label2.setForeground(Color.BLUE);

        this.add(up, BorderLayout.NORTH);
    }

    private void DownPanel() {
        Panel one = new Panel();
        btn = new Button("执行");
        //btn.setFont(new oraFram());
        //btn.setForeground(Color.BLUE);
        one.add(btn);
        this.add(one, BorderLayout.SOUTH);
    }


    public static void main(String[] args) {
        oraFram oraFram1 = new oraFram();
        //oraFram1.repaint();
    }
}
