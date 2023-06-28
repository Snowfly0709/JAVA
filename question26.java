package stu.xjtu.Leon.Leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class question26
{
    public static int removeDuplicates(int[] nums)
    {
        Set<Integer> list=new LinkedHashSet<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int i=0;
        for (Integer integer : list) {
            nums[i]=integer;
            i++;
        }
        return list.size();
    }

    public static void main(String[] args)
    {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedNums = {0,1,2,3,4};
        int k = removeDuplicates(nums);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

    }
}
