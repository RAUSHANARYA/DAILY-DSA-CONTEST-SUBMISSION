package array;

import java.util.Scanner;

public class TheLongestRun_Q1 {
	
//	public static int run(int arr[],int n)
//	{
//		int max =1;
//		int length =0;
//		for(int r=1;r<n;r++)
//		{
//			if(arr[r]>arr[r-1])
//			{
//				length++;
//			}
//			else
//			{
//				length=1;
//			}
//			max=Math.max(max, length);
//		}
//		return max;
//	}
	
	// by slinding window 

public static int run(int[] arr, int n) {
    int left = 0;
    int max = 1;

    for (int right = 1; right < n; right++) {
        if (arr[right] <= arr[right - 1]) {
            left = right;
        }

        max = Math.max(max, right - left + 1);
    }

    return max;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(run(arr,n));
        
	}

}
