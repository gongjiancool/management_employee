package com.study.ui;

import com.study.panel.PublicPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MoQi on 2017-12-18.
 * 样式类
 */
public class Style {
    public final static Dimension BUTTON_SIZE = new Dimension(160, 50);
    public final static Dimension FIELD_SIZE = new Dimension(150, 50);

    public final static Color GREEN = new Color(145, 233, 241);
    public final static Color BLUE = new Color(5, 153, 255);
    public final static Color WHITE = new Color(255, 255, 255);

    public final static Font NOMAL_FONT = new Font("楷体", Font.PLAIN, 20);
    public final static Font BOLD_FONT = new Font("楷体", Font.BOLD, 24);

    public static void setButtonStyle(JButton button) {
        button.setPreferredSize(BUTTON_SIZE);
        button.setBackground(GREEN);
        button.setForeground(BLUE);
        button.setFont(NOMAL_FONT);
    }

    public static void setButtonStyle1(JButton jButton){
        jButton.setSize(160,50);
        jButton.setBackground(BLUE);
        jButton.setFont(NOMAL_FONT);
        jButton.setForeground(Color.BLACK);
    }

    public static void setFieldStyle(JComponent component) {
        component.setPreferredSize(FIELD_SIZE);
        component.setBackground(BLUE);
        component.setForeground(WHITE);
        component.setFont(NOMAL_FONT);
    }

    public static void setLabelStyle(JLabel label) {
        label.setForeground(BLUE);
        label.setFont(BOLD_FONT);
    }
}
