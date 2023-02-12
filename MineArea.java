package stu.xjtu.Leon.ToObject.exams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class MineArea extends JPanel implements ActionListener, MouseListener {
    JButton reStart;
    Block [][] block;                  //雷区的方块
    BlockView [][] blockView;          //方块的视图
    LayMines lay;                      //负责布雷
    FindingNotMine findingNotMine;   //负责扫雷
    int row, column,mineCount,markMount;//雷区的行数、列数以及地雷个数和标记数
    ImageIcon mark;                   //探雷作的标记
    String grade;                     //游戏级别
    JPanel pCenter,pNorth;            //布局用的面板
    JTextField showTime,showMarkedMineCount; //显示用时和探雷作的标记数目
    Timer time;                          //计时器
    int spendTime=0;                     //扫雷的用时
    PlayMusic playMusic;                 //负责播放雷爆炸的声音
    public MineArea(int row,int column,int mineCount,String grade) {
        reStart=new JButton("重新开始");
        mark=new ImageIcon("C:\\Users\\xiongzf\\IdeaProjects\\Basic_Data\\day01\\src\\stu\\xjtu\\Leon\\ToObject\\exams\\tag.png");  //探雷标记
        time=new Timer(1000,this); //计时器

        //用时和标记数量模板
        showTime=new JTextField(5);
        showMarkedMineCount=new JTextField(5);
        showTime.setHorizontalAlignment(JTextField.CENTER);
        showMarkedMineCount.setHorizontalAlignment(JTextField.CENTER);
        showMarkedMineCount.setFont(new Font("Arial",Font.BOLD,32));
        showTime.setFont(new Font("Arial",Font.BOLD,32));
        pCenter=new JPanel();
        pNorth=new JPanel();
        lay=new LayMines(); //添加雷
        findingNotMine = new FindingNotMine(); //创建扫雷
        initMineArea(row,column,mineCount,grade); //初始化雷区
        reStart.addActionListener(this);
        pNorth.add(new JLabel("剩余雷数:"));
        pNorth.add(showMarkedMineCount);
        pNorth.add(reStart);
        pNorth.add(new JLabel("用时:"));
        pNorth.add(showTime);
        setLayout(new BorderLayout());
        add(pNorth,BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
        playMusic = new PlayMusic();              //负责播放触雷爆炸的声音
        playMusic.setClipFile("C:\\Users\\xiongzf\\IdeaProjects\\Basic_Data\\day01\\src\\stu\\xjtu\\Leon\\ToObject\\exams\\mine.wav");
    }
    public void initMineArea(int row,int column,int mineCount,String grade){
        pCenter.removeAll();
        spendTime=0;
        markMount=mineCount;    //可标记数与雷数相同
        this.row=row;
        this.column =column;
        this.mineCount=mineCount;
        this.grade=grade;
        block=new Block[row][column];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
                block[i][j]=new Block();
        }
        lay.layMinesForBlock(block,mineCount);     //布雷
        findingNotMine.setBlock(block,mineCount); //准备扫雷
        blockView=new BlockView[row][column];       //创建方块的视图
        pCenter.setLayout(new GridLayout(row,column));
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                blockView[i][j]=new BlockView();
                block[i][j].setBlockView(blockView[i][j]); //方块设置自己的视图，相当于独立设置后再插入
                blockView[i][j].setDataOnView();  //将block[i][j]的数据放入视图
                pCenter.add(blockView[i][j]);
                blockView[i][j].getBlockCover().addActionListener(this);
                blockView[i][j].getBlockCover().addMouseListener(this);
                blockView[i][j].seeBlockCover(); //初始时盖住block[i][j]的数据信息
                blockView[i][j].getBlockCover().setEnabled(true);
                blockView[i][j].getBlockCover().setIcon(null);
            }
        }
        showMarkedMineCount.setText(""+markMount);
        repaint();
    }
    public void setRow(int row){
        this.row=row;
    }
    public void setColumn(int column){
        this.column = column;
    }
    public void setMineCount(int mineCount){
        this.mineCount=mineCount;
    }
    public void setGrade(String grade) {
        this.grade=grade;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()!=reStart&&e.getSource()!=time) {
            time.start();
            int m=-1,n=-1;
            for(int i=0;i<row;i++) { //找到单击的方块以及它的位置索引
                for(int j = 0; j< column; j++) {
                    if(e.getSource()==blockView[i][j].getBlockCover()){
                        m=i;
                        n=j;
                        break;
                    }
                }
            }
            if(block[m][n].isMine()) { //用户点击到雷输掉游戏
                for(int i=0;i<row;i++) {
                    for(int j = 0; j< column; j++) {
                        blockView[i][j].getBlockCover().setEnabled(false);//用户单击无效了
                        if(block[i][j].isMine())
                            blockView[i][j].seeBlockNameOrIcon(); //视图显示方块上的数据信息
                    }
                }
                time.stop();
                playMusic.playMusic();    //播放类爆炸的声音
                JOptionPane.showMessageDialog(null,"你输了","结果",JOptionPane.OK_OPTION,mark); //弹出输了的窗口
                spendTime=0;             //恢复初始值
                markMount=mineCount;      //恢复初始值

            }
            else {  //扫雷者得到block[m][n]周围区域不是雷的方块
                Stack<Block> notMineBlock =findingNotMine.getNoMineAroundBlock(block[m][n]);
                while(!notMineBlock.empty()){
                    Block bk = notMineBlock.pop();
                    View4Block view4Block = bk.getBlockView();
                    view4Block.seeBlockNameOrIcon();//视图显示方块上的数据信息
                    System.out.println("ok");
                }
            }
        }
        if(e.getSource()==reStart) {
            initMineArea(row, column,mineCount,grade);
            repaint();
            validate();
        }
        if(e.getSource()==time){
            spendTime++;
            showTime.setText(""+spendTime);
        }
        if(findingNotMine.verifyWin()) {  //判断用户是否扫雷成功
            time.stop();
        }
    }
    public void mousePressed(MouseEvent e){ //探雷:给方块上插一个小旗图标（再次单击取消）
        JButton source=(JButton)e.getSource();
        for(int i=0;i<row;i++) {
            for(int j = 0; j< column; j++) {
                if(e.getModifiers()== InputEvent.BUTTON3_MASK&&
                        source==blockView[i][j].getBlockCover()){
                    if(block[i][j].getIsMark()) {
                        source.setIcon(null);
                        block[i][j].setIsMark(false);
                        markMount=markMount+1;
                        showMarkedMineCount.setText(""+markMount);
                    }
                    else{
                        source.setIcon(mark);
                        block[i][j].setIsMark(true);
                        markMount=markMount-1;
                        showMarkedMineCount.setText(""+markMount);
                    }
                }
            }
        }
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
}
