package day1;

class MaxSubArraySum
{ 
	public static void main (String[] args) 
	{ 
		int [] a = {-3,6,7,1,-1,-4,2,-9,-7,4};
		System.out.println("Maximum contiguous sum is " + findSum(a));
	} 

	static int findSum(int a[]) 
	{ 
		int globleMax = Integer.MIN_VALUE, localMax = 0;

		for (int a1:a) {
			localMax = localMax + a1;
			if (globleMax < localMax)
				globleMax = localMax;
			if (localMax < 0)
				localMax = 0;
		}
		return globleMax;
	} 
} 
