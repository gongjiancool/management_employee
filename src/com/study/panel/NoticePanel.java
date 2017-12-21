package com.study.panel;

import com.study.ui.Style;

import javax.swing.*;
import java.util.List;

/**
 * Created by HP on 2017/12/20.
 */
public class NoticePanel extends JPanel{
    private JLabel jLabel;
    private List<String> itemList;

    public String getName() {
        return "notice";
    }

    public NoticePanel(List<String> itemList) {
        this.itemList = itemList;
//        jLabel = new JLabel("培训通知");
//        add(jLabel);
        for (String item:itemList) {
            JButton button = new JButton(item);
            Style.setButtonStyle1(button);
            add(button);
        }
    }
}
