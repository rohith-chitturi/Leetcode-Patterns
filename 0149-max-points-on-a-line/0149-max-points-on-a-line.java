class Solution {
    public int maxPoints(int[][] points) {
        //need to calculate slope(y2-y1)/(x2-x1) of the points and this may produce some equal fraction to reduce that need to perform gcd suppose we got slopes as (1/2),(2/4)---> need to find gcd of (2,4) we get 2, divide (2/2,4/2) again results in (1,2)
        int maxSlope=0;
        int ans=0;
        for(int i=0;i<points.length;i++){
            Map<String,Integer> map=new HashMap<>();
            int[] point1=points[i];
            for(int j=i+1;j<points.length;j++){
                int[] point2=points[j];
                int dy=point2[1]-point1[1];
                int dx=point2[0]-point1[0];
                int g=gcd(Math.abs(dy),Math.abs(dx));
                dy=dy/g;
                dx=dx/g;
                if(dy==0 && dx==0){
                    continue;
                }
                if(dx<0){
                    dy=-dy;
                    dx=-dx;
                }
                if(dx==0){
                    dy=1;
                }
                String key=dy+"/"+dx;
                int count=map.getOrDefault(key,0)+1;
                map.put(key,count);
                maxSlope=Math.max(maxSlope,count);
            }
            ans=Math.max(ans,maxSlope+1);
        }
        return ans;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}