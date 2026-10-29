class Solution {
    int timer=0;
    int[] tin,tout,depth;
    int[][] up;
    int[] bit;
    int[] val;
    List<Integer>[] adj;
    int n;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n=n;
        tin=new int[n];
        tout=new int[n];
        depth=new int[n];
        up=new int[n][20];
        bit=new int[n+2];
        val=new int[n];
        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
            val[i]=1<<(s.charAt(i)-'a');
        }
        for(int[] e:edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        dfs(0,0,0);
        for(int i=0;i<n;i++){
            add(tin[i],val[i]);
            add(tout[i]+1,val[i]);
        }
        List<Boolean> ans=new ArrayList<>();
        for(String q:queries){
            if(q.charAt(0)=='u'){
                int firstSpace=q.indexOf(' ');
                int secondSpace=q.lastIndexOf(' ');
                int u=Integer.parseInt(q.substring(firstSpace+1,secondSpace));
                int newVal=1<<(q.charAt(secondSpace+1)-'a');
                int change=val[u]^newVal;
                val[u]=newVal;
                add(tin[u],change);
                add(tout[u]+1,change);
            }else{
                int firstSpace=q.indexOf(' ');
                int secondSpace=q.lastIndexOf(' ');
                int u=Integer.parseInt(q.substring(firstSpace+1,secondSpace));
                int v=Integer.parseInt(q.substring(secondSpace+1));
                int lca=getLca(u,v);
                int mask=query(tin[u])^query(tin[v])^val[lca];
                ans.add((mask&(mask-1))==0);
            }
        }
        return ans;
    }
    private void dfs(int u,int p,int d){
        tin[u]=++timer;
        depth[u]=d;
        up[u][0]=p;
        for(int i=1;i<20;i++){
            up[u][i]=up[up[u][i-1]][i-1];
        }
        for(int v:adj[u]){
            if(v!=p){
                dfs(v,u,d+1);
            }
        }
        tout[u]=timer;
    }
    private int getLca(int u,int v){
        if(depth[u]<depth[v]){
            int temp=u;
            u=v;
            v=temp;
        }
        for(int i=19;i>=0;i--){
            if(depth[u]-(1<<i)>=depth[v]){
                u=up[u][i];
            }
        }
        if(u==v) return u;
        for(int i=19;i>=0;i--){
            if(up[u][i]!=up[v][i]){
                u=up[u][i];
                v=up[v][i];
            }
        }
        return up[u][0];
    }
    private void add(int idx,int v){
        for(;idx<=n;idx+=idx&-idx){
            bit[idx]^=v;
        }
    }
    private int query(int idx){
        int res=0;
        for(;idx>0;idx-=idx&-idx){
            res^=bit[idx];
        }
        return res;
    }
}