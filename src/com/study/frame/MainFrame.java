package com.study.frame;

import com.study.model.Information;
import com.study.panel.*;
import com.study.ui.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * Created by HP on 2017/12/19.
 */
public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private JLabel closeLabel;
    private JLabel avatarLabel;
    private JLabel accountLabel;
    private JLabel nameLabel;
    private InformationPanel ip;
    private NoticePanel np;
    private SalaryPanel sp;
    private PersonalPanel pep;
    private PublicPanel pup;
    private RewardsPublishPanel rp;
    private AttendancePanel ap;
    private Map<String,List<String>> permissionMap;
    private JButton[] buttons;
    private int i = 0;
    private Information information = null;

    public MainFrame( Map<String,List<String>> permissionMap , Information information) {
        this.permissionMap = permissionMap;
        this.information = information;
        init();
        other();
        listen();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        add(mainPanel);
    }

    public void listen(){
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
    }

    public void init() {
        //该用户的权限组按钮
        int count = permissionMap.entrySet().size();
        buttons = new JButton[count];
        //卡片布局
        CardLayout card = new CardLayout();
        centerPanel.setLayout(card);
        Iterator<Map.Entry<String, List<String>>> iterator = permissionMap.entrySet().iterator();
        JButton jButton3 = new JButton("公告栏");
        Style.setButtonStyle1(jButton3);
        leftPanel.add(jButton3);
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            String groupName = entry.getKey();
            //生成权限组按钮
            JButton jButton = new JButton(groupName);
            leftPanel.add(jButton);
            buttons[i] = jButton;
            Style.setButtonStyle1(jButton);
//            jButton.setBorder(new RoundBorder());
            //生成各个权限组对应的卡片面板
            if ("档案管理".equals(groupName)) {
                ip = new InformationPanel(entry.getValue());
                centerPanel.add(ip.getName(), ip);
            } else if ("培训通知".equals(groupName)) {
                np = new NoticePanel(entry.getValue());
                centerPanel.add(np.getName(),np);
            }else if ("工资管理".equals(groupName)) {
                sp = new SalaryPanel(entry.getValue());
                centerPanel.add(sp.getName(),sp);
            }else if ("个人信息".equals(groupName)) {
                pep = new PersonalPanel(entry.getValue());
                centerPanel.add(pep.getName(),pep);
            }else if ("公告留言".equals(groupName)) {
                pup = new PublicPanel(entry.getValue());
                centerPanel.add(pup.getName(),pup);
            }else if ("奖惩管理".equals(groupName)) {
                rp = new RewardsPublishPanel(entry.getValue());
                centerPanel.add(rp.getName(),rp);
            }
                else if ("考勤记录".equals(groupName)) {
                ap = new AttendancePanel(entry.getValue());
                centerPanel.add(ap.getName(),ap);
            }
            i++;
        }

        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = button.getText();
                    if ("档案管理".equals(name)) {
                        card.show(centerPanel, ip.getName());
                    } else if ("培训通知".equals(name)) {
                        card.show(centerPanel, np.getName());
                    } else if ("工资管理".equals(name)) {
                        card.show(centerPanel, sp.getName());
                    } else if ("个人信息".equals(name)) {
                        card.show(centerPanel, pep.getName());
                    }else if ("公告留言".equals(name)) {
                        card.show(centerPanel, pup.getName());
                    }else if ("奖惩管理".equals(name)) {
                        card.show(centerPanel, rp.getName());
                    }else if ("考勤记录".equals(name)) {
                        card.show(centerPanel, ap.getName());
                    }
                }
            });
        }
        JButton jButton1 = new JButton("统计报表");
        JButton jButton2 = new JButton("密码修改");
        leftPanel.add(jButton1);
        leftPanel.add(jButton2);
        Style.setButtonStyle1(jButton1);
        Style.setButtonStyle1(jButton2);
        Style.setButtonStyle1(jButton3);
//        jButton1.setBorder(new RoundBorder());
//        jButton2.setBorder(new RoundBorder());
//        jButton3.setBorder(new RoundBorder());
    }

    private void other(){
        avatarLabel.setIcon(new ImageIcon(information.getAvatar()));
        nameLabel.setText(information.getName());
        accountLabel.setText(information.getAccount());
    }
}
