package check;
import java.util.Scanner;

public class OneRepair_Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        

        int left = 0;
        int right = n - 1;

        // Find first index  from left
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // Already sorted
        if (left == n - 1) {
            System.out.println("YES");
            sc.close();
            return;
        }

        // Find last index from right
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Reverse the selected segment
        int l = left;
        int r = right;
        
       
        
        while(l<r)
        {
        	if(arr[l]>arr[r]){
        	int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        	}

            l++;
            r--;
        }
        
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
	}

}
