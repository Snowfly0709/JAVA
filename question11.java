package stu.xjtu.Leon.Leetcode;

public class question11
{
    public static int maxArea(int[] height)
    {
        int i = 0,j = height.length-1,Area = 0;
        while (i<j)
        {
            Area = height[i] < height[j] ?
                    Math.max(Area,(j-i)*height[i++]):
                    Math.max(Area,(j-i)*height[j--]);
        }
        return Area;
    }

    public static void main(String[] args)
    {
        int[] height = {1,8,3,4,5,6,7};
        System.out.println(maxArea(height));
    }
}
