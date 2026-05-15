class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //1  2  3   4
        //5  6  7   8
        //9  10 11  12
        //13 14 15  16
        int[] ans = f(arr,arr.length,arr[0].length);
        for(int a : ans){
            System.out.print(" "+a);
        }
    }
    static int[] f(int[][] arr,int n, int m){
        int[] res = new int[m*n];
        int ind=0;
        for(int c=0;c<m;c++){
            int i=0;
            int j=m-1-c;
            int t=c;
            while(t>=0){
                res[ind++]=arr[i++][j++];
                t--;
            }
        }
        for(int r=1;r<m;r++){
            int i=r;
            int j=0;
            int t=r;
            while(t<m){
                res[ind++]=arr[i++][j++];
                t++;
            }
        }
        return res;
    }
}