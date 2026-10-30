package questionOne;

import java.util.*;

public class xorBasic {

    static int findXOR(List<Integer> arr) {
        int xor = 0;

        for (int x : arr) {
            xor ^= x;
        }

        return xor;
    }
   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(findXOR(arr));

        sc.close();
    }
}