package priorityqueus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class MaxPriorityQueue {
    /* Code : Max Priority Queue
    Send Feedback
    Implement the class for Max Priority Queue which includes following functions -
    1. getSize -
    Return the size of priority queue i.e. number of elements present in the priority queue.
    2. isEmpty -
    Check if priority queue is empty or not. Return true or false accordingly.
    3. insert -
    Given an element, insert that element in the priority queue at the correct position.
    4. getMax -
    Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
    5. removeMax -
    Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
    Note : main function is given for your reference which we are using internally to test the class.*/

    public class PQ {

        private ArrayList<Integer> heap;

        public PQ() {
            heap = new ArrayList<Integer>();
        }

        boolean isEmpty() {
            return heap.size() == 0;
        }

        int getSize() {
            return heap.size();
        }

        int getMax() {
            // Implement the getMax() function here
            if(heap.size()==0){
                return Integer.MIN_VALUE;
            }
            return heap.get(0);
        }

        void insert(int element) {
            heap.add(element);
            int childIndex = heap.size() - 1;
            int parentIndex = (childIndex - 1) / 2;

            while (childIndex > 0) {
                if (heap.get(childIndex) > heap.get(parentIndex)) {
                    int temp = heap.get(childIndex);
                    heap.set(childIndex, heap.get(parentIndex));
                    heap.set(parentIndex, temp);
                    childIndex = parentIndex;
                    parentIndex = (childIndex - 1) / 2;
                } else {
                    return;
                }
            }
        }

        int removeMax() {
            // Implement the removeMax() function here
            if(heap.size()==0){
                return Integer.MIN_VALUE;
            }
            int ans = heap.get(0);
            heap.set(0,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            int parentIndex=0;
            int leftChildIndex= 1;
            int rightChildIndex=2;
            while(leftChildIndex<heap.size()){
                int maxIndex = parentIndex;
                if(heap.get(leftChildIndex)>heap.get(maxIndex)){
                    maxIndex=leftChildIndex;
                }
                if(rightChildIndex<heap.size() && heap.get(rightChildIndex)>heap.get(maxIndex)){
                    maxIndex=rightChildIndex;
                }
                if (maxIndex == parentIndex) {
                    break;
                }
                int temp = heap.get(maxIndex);
                heap.set(maxIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
                parentIndex=maxIndex;
                leftChildIndex = (2 * parentIndex) + 1;
                rightChildIndex = (2 * parentIndex) + 2;
            }
            return ans;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public void main(String[] args) throws NumberFormatException, IOException {
        st = new StringTokenizer(br.readLine());
        PQ pq = new PQ();
        int choice = Integer.parseInt(st.nextToken());
        while(choice != -1) {
            switch(choice) {
                case 1 : // insert
                    int element = Integer.parseInt(st.nextToken());
                    pq.insert(element);
                    break;
                case 2 : // getMax
                    System.out.println(pq.getMax());
                    break;
                case 3 : // removeMax
                    System.out.println(pq.removeMax());
                    break;
                case 4 : // size
                    System.out.println(pq.getSize());
                    break;
                case 5 : // isEmpty
                    System.out.println(pq.isEmpty());
                default :
                    return;
            }
            choice = Integer.parseInt(st.nextToken());
        }
    }

}