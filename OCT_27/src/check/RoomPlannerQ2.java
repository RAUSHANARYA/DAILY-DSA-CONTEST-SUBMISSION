package check;
import java.util.*;

public class RoomPlannerQ2 {
	
	public static int meetingRoom2(int arr[][] , int n )
	{
		  PriorityQueue<Integer> q = new PriorityQueue<>();
		Arrays.sort(arr,(a,b)->a[0]-b[0]);
		
		q.offer(arr[0][1]);
		for(int j =1;j<n;j++)
		{
			if(arr[j][0]>=q.peek()) q.poll();
			
			q.offer(arr[j][1]);
		}
		return q.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int[][] arr = new int[n][2];

	        for (int i = 0; i < n; i++) {
	            arr[i][0] = sc.nextInt(); // start time
	            arr[i][1] = sc.nextInt(); // end time
	        }

	        System.out.println(meetingRoom2(arr, n));
	}

}
