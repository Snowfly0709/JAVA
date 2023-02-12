package stu.xjtu.Leon.ToObject.exams;

import javax.swing.*;
import java.util.LinkedList;

public class LayMines
{
    ImageIcon mineIcon;
    public LayMines()
    {
        mineIcon = new ImageIcon("C:\\Users\\xiongzf\\IdeaProjects\\Basic_Data\\day01\\src\\stu\\xjtu\\Leon\\ToObject\\exams\\mine.png");
    }
    //初始化
    public void initBlock(Block[][] block)
    {
        for(int i=0;i<block.length;i++) {
            for(int j=0;j<block[i].length;j++)
                block[i][j].setIsMine(false);
        }
    }

    public void layMinesForBlock(Block [][] block,int mineCount){ //在雷区布置mineCount个雷
        //先都设置是无雷
        initBlock(block);
        int row=block.length;
        int column=block[0].length;

        //使用list将二维数组转化成线性进行布雷
        LinkedList<Block> list=new LinkedList<Block>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++)
                list.add(block[i][j]);
        }

        while(mineCount>0){                  //开始布雷
            int size=list.size();             // list返回节点的个数
            int randomIndex=(int)(Math.random()*size);
            Block b=list.get(randomIndex);
            b.setIsMine(true);
            b.setName("雷");
            b.setMineIcon(mineIcon);
            list.remove(randomIndex);        //list删除索引值为randomIndex的节点
            mineCount--;
        }
        for(int i=0;i<row;i++){             //检查布雷情况
            for(int j=0;j<column;j++){
                if(block[i][j].isMine()){
                    block[i][j].setIsOpen(false);
                    block[i][j].setIsMark(false);
                }
                else {
                    int mineNumber=0;
                    for(int k=Math.max(i-1,0);k<=Math.min(i+1,row-1);k++) {
                        for(int t=Math.max(j-1,0);t<=Math.min(j+1,column-1);t++){
                            if(block[k][t].isMine())
                                mineNumber++;
                        }
                    }
                    block[i][j].setIsOpen(false);
                    block[i][j].setIsMark(false); //将游戏初始化
                    block[i][j].setName(""+mineNumber); //标记每个方块周围的雷的数目
                    block[i][j].setAroundMineNumber(mineNumber); //设置该方块周围的雷数目
                }
            }
        }
    }
}
