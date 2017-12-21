package com.study.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MoQi on 2017-12-18.
 * 自定义对话框
 */
public class MyDialog extends JDialog{
    private String info;
    private JLabel infoLabel;
    private JButton okButton;

    public MyDialog(String info) {
        this.info = info;
        //设置为模态框
        setModal(true);
        setTitle("提示框");
        setSize(405, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(new Color(190, 223, 255));
        infoLabel = new JLabel(info);
        Style.setLabelStyle(infoLabel);
        infoLabel.setBounds(150, 25, 200, 50);
        add(infoLabel);
        okButton = new JButton("确定");
        Style.setButtonStyle(okButton);
        okButton.setBounds(135, 100, 130, 50);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog.this.dispose();
            }
        });
        add(okButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyDialog("登录成功");
    }
}
