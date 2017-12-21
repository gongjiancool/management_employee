package com.study.panel;

import com.study.ui.Style;
import com.sun.prism.j2d.print.J2DPrinterJob;

import javax.swing.*;
import java.util.List;

/**
 * Created by HP on 2017/12/20.
 */
public class SalaryPanel extends JPanel{
    private JLabel jLabel;
    private List<String> itemList;

    public String getName() {
        return "salary";
    }

    public SalaryPanel(List<String> itemList) {
        this.itemList = itemList;
//        jLabel = new JLabel("工资管理");
//        add(jLabel);
        for (String item:itemList) {
            JButton button = new JButton(item);
            Style.setButtonStyle1(button);
            add(button);
        }
    }
}
