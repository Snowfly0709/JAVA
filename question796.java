package stu.xjtu.Leon.Leetcode;

public class question796
{
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
        {
            return false;
        }
        s = s + s;
        String[] before = s.split("");
        String[] after = goal.split("");
        int Point = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(after[0].equals(before[i]))
            {
                Point = i;
                int length = 0;
                for(int j = 0;j<after.length;j++)
                {
                    if(j+Point==before.length)
                    {
                        return false;
                    }
                    if(after[j].equals(before[j+Point]))
                    {
                        length++;
                    }
                }
                if(length== after.length)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(rotateString("abcde","abced"));
    }
}
