class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] e:invocations) adj[e[0]].add(e[1]);
        boolean[] susp=new boolean[n];
        dfs(k,adj,susp);
        for(int[] e:invocations){
            if(!susp[e[0]] && susp[e[1]]){
                List<Integer> all=new ArrayList<>(n);
                for(int i=0;i<n;i++){
                    all.add(i);
                }
                return all;
            }
        }
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(!susp[i]) res.add(i);
            }
            return  res;
        }
        private void dfs(int u,List<Integer>[] adj,boolean[] susp){
            susp[u]=true;
            for(int v:adj[u]){
                if(!susp[v]) dfs(v,adj,susp);
            }
        }
    }
     
