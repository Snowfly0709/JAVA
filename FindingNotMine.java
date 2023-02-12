package stu.xjtu.Leon.ToObject.exams;

import java.util.Stack;

public class FindingNotMine
{
    public Block [][] block;    //雷区的全部方块
    Stack<Block> notMineBlock; //存放一个方块周围区域内不是雷的方块
    int m,n ;                   //方块的索引下标
    int row,column;              //雷区的行和列
    int mineCount;              //雷的数目
    public FindingNotMine(){
        notMineBlock = new Stack<Block>();
    }

    public void setBlock(Block [][] block,int mineCount){
        this.block = block;
        this.mineCount =  mineCount;
        row = block.length;
        column = block[0].length;
    }

    public Stack<Block> getNoMineAroundBlock(Block bk){//得到方块bk附近区域不是雷的方块
        notMineBlock.clear();//每次用完要清零
        for(int i=0;i<row;i++) {   //寻找bk在雷区block中的位置索引
            for(int j=0;j<column;j++) {
                if(bk == block[i][j]){
                    m=i;
                    n=j;
                    break;
                }
            }
        }
        if(!bk.isMine()) {     //方块不是雷
            show(m,n);        //见后面的递归方法
        }
        return notMineBlock;
    }
    public void show(int m,int n) {
        if(block[m][n].getAroundMineNumber()>0&&block[m][n].getIsOpen()==false){
            block[m][n].setIsOpen(true);
            notMineBlock.push(block[m][n]); //将不是雷的方块压栈
            return;
        }
        else if(block[m][n].getAroundMineNumber()==0&&block[m][n].getIsOpen()==false){
            block[m][n].setIsOpen(true);
            notMineBlock.push(block[m][n]); //将不是雷的方块压栈
            for(int k=Math.max(m-1,0);k<=Math.min(m+1,row-1);k++) {
                for(int t=Math.max(n-1,0);t<=Math.min(n+1,column-1);t++)
                    show(k,t);
            }
        }
    }

    public boolean verifyWin(){
        boolean isOK = false;
        int number=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                if(block[i][j].getIsOpen()==false)
                    number++;
            }
        }
        //利用最终未开的数量等于雷数判断是否获得胜利
        if(number==mineCount){
            isOK =true;
        }
        return isOK;
    }

}
