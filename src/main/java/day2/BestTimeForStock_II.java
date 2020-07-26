package day2;

public class BestTimeForStock_II {
    public static void main(String[] args) {
        int stockPrice[]={7,1,5,3,6,4};
        int profit= maxProfit(stockPrice);
        System.out.println("Maximum profit during transaction is:"+profit);
    }
    static int maxProfit(int[] price)
    {
       int profit=0;
           for(int i=1;i<price.length;i++)
       {
           int diff=price[i]-price[i-1];
           if(diff>0)
                profit=profit+diff;
       }
       return profit;
    }

}
