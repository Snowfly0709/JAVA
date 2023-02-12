package stu.xjtu.Leon.ToObject.exams;

public interface View4Block
{
    public void acceptBlock(Block block);//确定视图
    public void setDataOnView(); //设置视图上显示的数据
    public void seeBlockNameOrIcon();//显示图标名字或图标
    public void seeBlockCover();     //显示遮挡物
    public Object getBlockCover();   //得到遮挡物
}
