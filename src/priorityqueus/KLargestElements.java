package priorityqueus;

/*  K Largest Elements
    You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
    Time complexity should be O(nlogk) and space complexity should be not more than O(k).
    Order of elements in the output is not important.
    Input Format :
    Line 1 : Size of array (n)
    Line 2 : Array elements (separated by space)
    Line 3 : Integer k
    Output Format :
    k largest elements
    Sample Input :
    13
    2 12 9 16 10 5 3 20 25 11 1 8 6
    4
    Sample Output :
    12
    16
    20
    25*/
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[]arr={2 ,12, 9 ,16 ,10 ,5 ,3 ,20 ,25 ,11, 1, 8, 6};
        System.out.println( kLargest(arr,4));
    }

    public static ArrayList<Integer> kLargest(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (pq.peek() < input[i]) {
                pq.add(input[i]);
                pq.remove();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        return ans;
    }
}