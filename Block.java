package stu.xjtu.Leon.ToObject.exams;

import javax.swing.*;

public class Block
{
    String name;                   //名字,比如"雷"或数字
    int aroundMineNumber;          //如果不是，此数据是周围雷的数目
    ImageIcon mineIcon;       //雷的图标
    boolean isMine=false;   //是否是雷
    boolean isMark=false;          //是否被标记
    boolean isOpen=false;          //是否被挖开
    BlockView blockView;       //方块的视图
    public void setName(String name) {
        this.name=name;
    }
    public void setAroundMineNumber(int n) {
        aroundMineNumber=n;
    }
    public int getAroundMineNumber() {
        return aroundMineNumber;
    }
    public String getName() {
        return name;
    }
    public boolean isMine() {
        return isMine;
    }
    public void setIsMine(boolean b) {
        isMine=b;
    }
    public void setMineIcon(ImageIcon icon){
        mineIcon=icon;
    }
    public ImageIcon getMineIcon(){
        return mineIcon;
    }
    public boolean getIsOpen() {
        return isOpen;
    }
    public void setIsOpen(boolean p) {
        isOpen=p;
    }
    public boolean getIsMark() {
        return isMark;
    }
    public void setIsMark(boolean m) {
        isMark=m;
    }
    public void setBlockView(BlockView view){
        blockView = view;
        blockView.acceptBlock(this);
    }
    public View4Block getBlockView(){
        return  blockView;
    }

}
