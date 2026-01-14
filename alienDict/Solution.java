import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public String findOrder(String[] dict, int n, int k){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;i++) adj.add(new ArrayList<>());

       //Adjacent list using given string word - directed graph
        for(int i=0;i<n-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.max(s1.length(),s2.length());
            for(int ptr=0;ptr<len;ptr++){
                if(s1.charAt(ptr)!=s2.charAt(ptr))
                {
                    //making the list (0,1,2,3)->(a,b,c,d)
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }

            }
        }
        //getting topo sort for adjacent list
        List<Integer> list =topo(k,adj);
        String ans ="";
        for(Integer it : list){
            ans += (char)(it + (int)'a');
        }
        return ans;
    }

    private List<Integer> topo(int k, List<List<Integer>> adj){
        int[] indegree = new int[k];
        // storing degree
        for(int i=0;i<k;i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }
        //In Acyclic getting O degree & storing in Queue DS
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(indegree[i]==0)q.offer(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int temp=q.peek();
            ans.add(temp);
            q.remove();
            for(Integer it : adj.get(temp)){
                indegree[it]--;
                //adding in queue when degree 0
                if(indegree[it]==0)
                    q.offer(it);
            }

        }
        return ans;
    }
}
