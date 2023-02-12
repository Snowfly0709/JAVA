package stu.xjtu.Leon.ToObject.exams;

import javax.swing.*;
import java.awt.*;
import stu.xjtu.Leon.ToObject.exams.Block;

public class BlockView extends JPanel implements View4Block
{
    JLabel blockNameOrIcon; //用来显示Block对象的name、number和mineIcon属性
    JButton blockCover;     //用来遮挡blockNameOrIcon.
    CardLayout card;        //卡片式布局
    Block block;           //被提供视图的方块

    BlockView(){
        card=new CardLayout();
        setLayout(card);
        blockNameOrIcon=new JLabel("",JLabel.CENTER);
        blockNameOrIcon.setHorizontalTextPosition(AbstractButton.CENTER);
        blockNameOrIcon.setVerticalTextPosition(AbstractButton.CENTER);
        blockCover=new JButton();
        add("cover",blockCover);
        add("view",blockNameOrIcon);
    }
    public void acceptBlock(Block block){
        this.block = block;
    }

    public void setDataOnView(){
        if(block.isMine()){
            blockNameOrIcon.setText(block.getName());
            blockNameOrIcon.setIcon(block.getMineIcon());
        }
        else {
            int n=block.getAroundMineNumber();
            if(n>=1)
                blockNameOrIcon.setText(""+n);
            else
                blockNameOrIcon.setText(" ");
        }
    }
    public void seeBlockNameOrIcon(){
        card.show(this,"view");
        validate();
    }
    public void seeBlockCover(){
        card.show(this,"cover");
        validate();
    }
    public JButton getBlockCover(){
        return blockCover;
    }
}
