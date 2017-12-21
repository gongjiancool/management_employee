package com.study.utils;

import javax.swing.*;
import java.awt.*;

/**
 * 绘图面板，可将指定宽带，高度，名称的图片自动适应绘制到面板上
 * @author  樊委
 * @since 2017 . 9 .20
 * @version 1.0
 */
public class ImagePanel extends JPanel{
    private int width;
    private int height;
    private  String imgPath;//图片路径

    public ImagePanel(int width,int height,String  imgPath){
        this.width=width;
        this.height=height;
        this.imgPath =imgPath;
        this.setPreferredSize(new Dimension(this.width,this.height));
    }
    public ImagePanel(){
        super();//调用
    }

    /**
     * 重写父类
     * 对组件绘制
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/"+imgPath));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(this.width,this.height,Image.SCALE_FAST));
        imageIcon.paintIcon(this,g,0,0);
    }
}
