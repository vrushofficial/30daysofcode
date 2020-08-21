package day8;

class KadaneAlgo {

    static int maxSubArraySum(int a[])
    {
        var global_max=a[0];
        var local_max=0;
        for (int i=1;i<a.length;i++)
        {
            local_max=local_max+a[i];
            if(local_max>global_max)
                global_max=local_max;
            else if (local_max<0)
                local_max=0;
        }
        return global_max;
    }
    public static void main(String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(a));
    }

}