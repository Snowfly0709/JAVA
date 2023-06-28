package stu.xjtu.Leon.Leetcode;

public class question13
{
    public static int romanInt(String s){
        String[] roman = s.split("");
        int[] romanNum = new int[roman.length];
        int num = 0;
        //int m = 1000,d = 500,c = 100,l = 50,x = 10,v = 5,i = 1;
        for(int j = 0;j<roman.length;j++)
        {
            switch (roman[j])
            {
                case "M":
                    romanNum[j] = 1000;
                    break;
                case "D":
                    romanNum[j] = 500;
                    break;
                case "C":
                    romanNum[j] = 100;
                    break;
                case "L":
                    romanNum[j] = 50;
                    break;
                case "X":
                    romanNum[j] = 10;
                    break;
                case "V":
                    romanNum[j] = 5;
                    break;
                case "I":
                    romanNum[j] = 1;
                    break;
            }
        }
        for(int i = 0;i<romanNum.length;i++)
        {
            if(romanNum[i]>=romanNum[i+1])
            {
                num = num + romanNum[i];
            }
            else
            {
                
            }
        }
        return 0;
    }
}
