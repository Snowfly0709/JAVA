package stu.xjtu.Leon.ToObject.exams;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements MenuListener, ActionListener
{
    JMenuBar bar;
    JMenu fileMenu,exit;
    JMenu easy, medium, hard;//扫雷级别
    MineArea mineArea=null; //扫雷区域

    public Window(){
        bar=new JMenuBar();
        fileMenu=new JMenu("选择难度");
        exit=new JMenu("退出");
        easy=new JMenu("初级");
        medium =new JMenu("中级");
        hard =new JMenu("高级");
        fileMenu.add(easy);
        fileMenu.add(medium);
        fileMenu.add(hard);
        bar.add(fileMenu);
        bar.add(exit);
        setJMenuBar(bar);
        easy.addMenuListener(this);
        medium.addMenuListener(this);
        hard.addMenuListener(this);
        exit.addMenuListener(this);
        mineArea=new MineArea(9,9,10,easy.getText());//默认创建初级扫雷区
        add(mineArea, BorderLayout.CENTER);
        setBounds(300,100,1000,750);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }
    public void menuSelected(MenuEvent e){
        if(e.getSource()==easy){
            mineArea.initMineArea(9,9,10,easy.getText());
            validate();
        }
        else if(e.getSource()== medium){
            mineArea.initMineArea(16,16,40, medium.getText());
            validate();
        }
        else if(e.getSource()== hard){
            mineArea.initMineArea(22,30,99, hard.getText());
            validate();
        }
        else if(e.getSource()== exit) {
            Object[] options = {"yes","no"};
            String s =(String) JOptionPane.showInputDialog(null,"你真的要退出吗？","系统提示",JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
            if(s.equals("yes"))
                System.exit(0);

        }
    }
    public void menuCanceled(MenuEvent e){}
    public void menuDeselected(MenuEvent e){}
    public void actionPerformed(ActionEvent e){}
    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        String lookAndFeel =UIManager.getSystemLookAndFeelClassName(); //选用系统主题UI
        UIManager.setLookAndFeel(lookAndFeel);
        new Window();
    }
}
