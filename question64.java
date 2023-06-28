package stu.xjtu.Leon.Leetcode;

public class question64
{
    public static void main(String[] args)
    {
        int[][] ex = {{1,2},{1,1}};
        for(int i = 0;i < ex.length;i++)
        {
            for(int j = 0;j<ex[i].length;j++)
            {
                if(i!=0&&j!=0)
                    ex[i][j] = ex[i][j] + Math.min(ex[i-1][j] ,ex[i][j-1]);
                if(i==0&&j!=0)
                    ex[i][j] = ex[i][j] + ex[i][j-1];
                if(i!=0&&j==0)
                    ex[i][j] = ex[i][j] + ex[i-1][j];
            }
        }
        System.out.println(ex[ex.length-1][ex[ex.length-1].length-1]);
    }

}
