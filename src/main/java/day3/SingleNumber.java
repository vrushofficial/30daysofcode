package day3;

public class SingleNumber {
    public static void main(String[] args) {
        int a[]= {1,4,2,2,3,4,1};
        int unique= findSingle(a);
        System.out.println(unique);
    }
    /*x XOR x= 0
    x XOR 0= x

    find xor of whole array
    result = 1^4^2^2^3^4^1
           =(1^1)^(2^2)^(4^4)^3
           =0^0^0^1
           =3
    */

    static int findSingle(int num[])
    {
        int t=0;
        for (int i=0;i<num.length;i++)
        {
            t=t^num[i];
        }
        return t;
    }
}
