package check;

public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  System.out.println("hello world");
	 
//	  # Daily DSA Practice Summary — 27th October 2026
//
//	  ## Question 1 — HashMap (Easy)
//
//	  Question 1 was easy. I can easily write the code independently.
//
//	  The question was based on a HashMap, where I store the frequency of each element. When an element's frequency is equal to one, I simply return that element and break the condition.
//
//	  ## Question 2 — Meeting Room II (Greedy + Priority Queue)
//
//	  The second question was based on Meeting Room II. I used the greedy approach with a PriorityQueue.
//
//	  First, I sort the meetings based on their starting time. If the starting time is greater than or equal to the PriorityQueue's peak (minimum ending time), I simply poll the element. Otherwise, I add the meeting's ending time to the PriorityQueue.
//
//	  Finally, I return the PriorityQueue's size, which gives the number of rooms required.
//
//	  ## Question 3 — One Repair (Two Pointers + Array Reversal)
//
//	  The last question was a little difficult for me, but my approach was right. I just made a mistake in the implementation.
//
//	  Initially, I used two pointers, where the left pointer started from index zero and the right pointer started from the last index. If the left element was greater than the right element, I swapped them, then incremented the left pointer and decremented the right pointer.
//
//	  However, I faced an implementation issue. I fixed it with the help of GPT.
//
//	  I then used the first inversion from the left and the last inversion from the right to identify the segment that needed to be reversed. The left pointer started from zero, and the right pointer started from the last index. If the current element was greater than the next element, I identified the left inversion. Similarly, I identified the right inversion from the right side.
//
//	  After finding both boundaries, I reversed the elements between them. Finally, I checked the entire array. If any element was greater than the next element, I printed `NO`; otherwise, I printed `YES`.


	}

}
