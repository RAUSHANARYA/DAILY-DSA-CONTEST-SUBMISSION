package array;
import java.util.*;

public class WordCollection_Q2 {
	
	public ArrayList<ArrayList<String>> anagrams(String[] arr)
    {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            char brr[] =arr[i].toCharArray();
            Arrays.sort(brr);
            String s = new String(brr);
            
            if(!map.containsKey(s))
            {
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(arr[i]);
        
            
        }
         return new ArrayList<>(map.values());
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
