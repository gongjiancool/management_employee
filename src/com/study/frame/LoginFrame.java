package com.study.frame;

import com.study.factory.DAOFactory;
import com.study.factory.ServiceFactory;
import com.study.model.Information;
import com.study.service.LoginService;
import com.study.ui.LoginButton;
import com.study.ui.MyDialog;
import com.study.utils.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2017/12/19.
 */
public class LoginFrame extends JFrame {
    private JPanel mainPanel;
    private JLabel ycLabel;
    private JLabel hideLabel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton escButton;
    private JPanel loginPanel;
    private ImagePanel imagePanel;
    private ImagePanel contentPanel;
    private JLabel forgetLabel;
    private JLabel label1;
    private JTextField idField;
    private JPasswordField passwordField;
    private LoginService loginService = ServiceFactory.getLoginServiceInstance();
    private Information information;


    public LoginFrame(){
        init();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = idField.getText();
                String password = new String(passwordField.getPassword());
                Map<String,Object> map = loginService.employeeLogin(account,password);
                information = loginService.getInformation(account);
                String info = map.get("info").toString();
                //JOptionPane.showMessageDialog(null, info);
                new MyDialog(info);
                if ("登录成功".equals(info)){
                    Map<String, List<String>> loginPermissionMap = (Map<String, List<String>>) map.get("permissionMap");
                    LoginFrame.this.dispose();
                    System.out.println(information);
                    new MainFrame(loginPermissionMap,information);
                }
            }
        });
        escButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void init(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        imagePanel = new ImagePanel(screenSize.width,screenSize.height,"bg1.jpg");
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER,150,150));
        mainPanel.add(imagePanel);
        contentPanel = new ImagePanel(600,700,"bg.png");
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,150,250));
        imagePanel.add(contentPanel);
        loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new GridLayout(4,1));
        JPanel[] panels = new JPanel[4];
        for (int i = 0; i<panels.length; i++){
            panels[i] = new JPanel();
            panels[i].setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
            panels[i].setOpaque(false);
        }
        idField = new JTextField();
        passwordField = new JPasswordField();
        idField.setPreferredSize(new Dimension(200,30));
        passwordField.setPreferredSize(new Dimension(200,30));
        idLabel = new JLabel();
        idLabel.setFont(new Font("幼圆",1,15));
        passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("幼圆",1,15));
        forgetLabel = new JLabel();
        forgetLabel.setFont(new Font("幼圆",1,15));
        label1 = new JLabel();
        idLabel.setText("     帐号：");
        passwordLabel.setText("     密码：");
        forgetLabel.setText("忘记密码?");
        label1.setText("                                                                   ");
        panels[0].add(idLabel);
        panels[0].add(idField);
        panels[1].add(passwordLabel);
        panels[1].add(passwordField);
        panels[2].add(label1);
        panels[2].add(forgetLabel);
        ycLabel = new JLabel(new ImageIcon(LoginFrame.class.getResource("/img/1.png")));
        panels[3].add(ycLabel);
        ycLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                contentPanel.setVisible(false);

                hideLabel.setVisible(true);
            }
        });
        loginButton = new LoginButton("登录",30,new Color(128,205,233),new Color(248,234,207));
        loginButton.setFont(new Font("幼圆",1,15));
        escButton = new LoginButton("退出",30,new Color(128,205,233),new Color(248,234,207));
        escButton.setFont(new Font("幼圆",1,15));
        panels[3].setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        panels[3].add(loginButton);
        panels[3].add(escButton);
        for (int i = 0;i < panels.length;i ++) {
            loginPanel.add(panels[i]);
        }
        contentPanel.add(loginPanel);
        hideLabel = new JLabel(new ImageIcon(LoginFrame.class.getResource("/img/4.png")));
        hideLabel.setVisible(false);
        hideLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                contentPanel.setVisible(true);

                hideLabel.setVisible(false);
            }
        });
        imagePanel.add(hideLabel);
    }


    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setContentPane(new LoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
