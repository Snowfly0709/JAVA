package stu.xjtu.Leon.Leetcode;

import java.util.Scanner;

public class question2485
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int flag = 0;
        for(int i = 1;i<=input;i++)
        {
            int beyond = (1+i)*i/2;
            int latter = (i+input)*(input-i+1)/2;
            if(beyond==latter){
                System.out.println(i);
                flag = 1;
                break;
            }
        }
        if(flag==0)
        {
            System.out.println(-1);
        }
    }
}
