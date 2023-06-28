package stu.xjtu.Leon.Leetcode;

public class question1010
{
    public static int function(int[] time){
        long total = 0;
        int[] rest = new int[60];
        for (int j : time) {
            rest[j % 60] = rest[j % 60] + 1;
        }
        total = total + (long) rest[0] *(rest[0]-1)/2;
        for(int i = 1;i<30;i++)
        {
            total = total + (long) rest[i] *rest[60-i];
        }
        total = total + (long) rest[30] *(rest[30]-1)/2;
        return (int)total;
    }

    public static void main(String[] args)
    {
        int[] time = {60,60,60,60};
        System.out.println(function(time));
    }
}
