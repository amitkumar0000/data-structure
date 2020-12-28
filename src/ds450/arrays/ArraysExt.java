package ds450.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class ArraysExt {

    public int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(n == 0)
            return 0;
        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;

        for(int i=0; i<n; i++) {
            if(map.containsKey(k-arr[i])){
                if(map.get(k-arr[i]) != 0) {

                    count += map.get(k-arr[i]);

                    if(k - arr[i] == arr[i])
                        count -= 1;
                }
            }
        }

        return count/2;
    }

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        // code here
        int a = 0;
        int b = 0;
        int c = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        while(a < n1 && b < n2 && c < n3) {
            if(A[a] == B[b] && A[a] == C[c]){
                if(!res.contains(A[a]))
                 res.add(A[a]);
                a++;
                b++;
                c++;
            }else {
                int min = Math.min(A[a], Math.min(B[b], C[c]));
                if(min == A[a]) {
                    a++;
                }else if(min == B[b]){
                    b++;
                }else {
                    c++;
                }
            }
        }

        return res;
    }
}
