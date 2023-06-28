package stu.xjtu.Leon.Leetcode;

public class question28
{
    public static int strStr(String haystack, String needle){
        String[] h = haystack.split("");
        String[] n = needle.split("");
        if(h.length<n.length)
            return -1;
        for(int i = 0;i<h.length;i++)
        {
            if(h[i].equals(n[0])&&(i+n.length<=h.length)){
                int flag = 0;
                for(int j = 0;j<n.length;j++)
                {
                    if(h[i+j].equals(n[j]))
                    {
                        flag++;
                    }
                }
                if(flag==n.length)
                    return i;

            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String hay = "sadbutsad";
        String nee = "but";
        System.out.println(strStr(hay,nee));
    }
}
