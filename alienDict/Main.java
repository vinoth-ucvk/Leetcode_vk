public class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        //Input string words
        //only 4 letters - (0,1,2,3)->(a,b,c,d)
        String[] word0 = {"b","a","ccc","ccd"};
        String[] word1 = {"b","a","ddd","ccc"};
        String[] word2 = {"baa","abcd","abca","cab"};

        String[][] pass = new String[3][3];
        pass[0]=word0;
        pass[1]=word1;
        pass[2]=word2;

            for(int i=0;i<pass.length;i++) {
                String finalans = sol.findOrder(pass[i], 4, 4);
                System.out.println(finalans);
            }
        }
    }

