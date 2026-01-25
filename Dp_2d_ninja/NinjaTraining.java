we can code like this to avoid confusion

class Solution {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
       int[] dp = new int[3];
       dp[0] = Math.max(matrix[0][1],matrix[0][2]); 
       dp[1] = Math.max(matrix[0][0],matrix[0][2]); 
       dp[2] = Math.max(matrix[0][0],matrix[0][1]); 
       for(int i=1;i<n;i++){
        int[] temp = new int[3];
        for(int last=0;last<3;last++){
            temp[last]=0;
            for(int task=0;task<3;task++){
                if(task!=last){
                    int points = matrix[i][task]+dp[task];
                    temp[last]=Math.max(temp[last],points);
                }
            }
        }
        dp=temp;
       }
       return Math.max(dp[0],Math.max(dp[1],dp[2]));
    }
}