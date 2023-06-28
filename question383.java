package stu.xjtu.Leon.Leetcode;

public class question383
{
            public static boolean canConstruct(String ransomNote, String magazine) {
                String[] rM;
                String[] m;
                rM = ransomNote.split("");
                m = magazine.split("");
                while(true){
                    int i = 0;
                    int j = 0;
                    construct(rM,m,i,j);
                    int judge = 0;
                    for(int x = 0;x<ransomNote.length();x++) {
                        if(rM[x] == null)
                            judge++;
                    }
                    return judge == ransomNote.length();
                }

            }

            public static int construct(String[] rM, String[] M,int i, int j){
                int count = 0;
                for (String s : rM) {
                    if (s == null) {
                        count++;
                    }
                    if (count == rM.length)
                        return 1;
                }
                    while(rM[i]==null)
                    {
                        i = i + 1;
                    }
                    while(M[j]==null)
                    {
                        j = j + 1;
                        if(j == M.length)
                            break;
                    }
                    if(j== M.length)
                    {
                        return 1;
                    }

                    while(!(rM[i].equals(M[j]))){
                        j = j + 1;
                        if(j==M.length)
                            return 1;
                    }
                        while(rM[i].equals(M[j])) {
                            rM[i] = null;
                            M[j] = null;
                            i = i + 1;
                            j = j + 1;
                            if (i == rM.length || j == M.length) {
                                int ifOut = construct(rM, M,0,0);
                                if(ifOut == 1)
                                {
                                    return 1;
                                }
                            }
                        }
                        construct(rM, M,0,0);
                        return 1;
            }

        public static void main(String[] args)
        {
            System.out.println(canConstruct("abc","ab"));
        }

}
