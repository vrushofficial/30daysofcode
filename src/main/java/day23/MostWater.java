package day23;


public class MostWater {

    int solution(int[] ip)
    {
        int globleMax= 0;
        for(int i=0;i<ip.length;i++)
       {
           int localMax=0;
           for(int j=i+1;j<ip.length;j++)
           {
               int container=Math.min(ip[i],ip[j]);
               localMax=Math.max(localMax,container*(j-i));
           }
          globleMax=Math.max(globleMax,localMax);
       }
        return globleMax;
    }

    public static void main(String[] args) {
        System.out.println(new MostWater().solution(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
