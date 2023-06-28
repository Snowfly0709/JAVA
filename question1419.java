package stu.xjtu.Leon.Leetcode;

public class question1419
{
    public static int minNumberOfFrogs(String croakOfFrogs){
        String[] sounds;
        sounds = croakOfFrogs.split("");
        int c = 0,r = 0,o = 0,a = 0,k = 0;
        int total = 0;
        for (String sound : sounds) {

            if (sound.equals("c"))
                c = c + 1;
            if (sound.equals("r"))
                r = r + 1;
            if (sound.equals("o"))
                o = o + 1;
            if (sound.equals("a"))
                a = a + 1;
            if (sound.equals("k"))
                k = k + 1;
            total = Math.max(c - k, total);
            if (c < r || r < o || o < a || a < k)
                return -1;
        }
        if (c==r&&r==o&&o==a&&a==k)
            return total;
        else
            return -1;
    }

    public static void main(String[] args)
    {
        String example = "crocracokrakoak";
        int result = minNumberOfFrogs(example);
        System.out.println(result);
    }

}
