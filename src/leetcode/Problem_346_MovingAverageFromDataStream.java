/**
 * Problem_346_MovingAverageFromDataStream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Example:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author mandeep
 */
public class Problem_346_MovingAverageFromDataStream {
    int size;
    // approach 1 using arrays
    private List<Integer> queue = new ArrayList<>();
    
    //approach 2 using dequeues
    private Deque<Integer> dequeue = new ArrayDeque<>();
    private int dequeueWindowSum = 0, count = 0;
    
    private Problem_346_MovingAverageFromDataStream(int size) {
        this.size = size;
    }
    
    public static void main(String args[]) {
        int size = 3;
        Problem_346_MovingAverageFromDataStream obj = new Problem_346_MovingAverageFromDataStream(size);
        int val = 1;
        // using arrays
        double param_1 = obj.next(val);
        System.out.println(param_1);
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
        
        // using double ended queue
        System.out.println("using dequeue");
        Problem_346_MovingAverageFromDataStream obj2 = new Problem_346_MovingAverageFromDataStream(size);
        System.out.println(obj2.approach2(1));
        System.out.println(obj2.approach2(10));
        System.out.println(obj2.approach2(3));
        System.out.println(obj2.approach2(5));
    }
    
    /**
     * approach 1 using arrays
     * Time complexity: O(n); n is size of moving window
     * Space Complexity: O(m); m is size of queue (i.e all elements that were added to stream at point t)
     *
     * @param val
     * @return
     */
    public double next(int val) {
        queue.add(val);
        int windowSum = 0;
        for (int i = Math.max(0, queue.size() - size); i < queue.size(); i++) {
            windowSum += (int) queue.get(i);
        }
        return windowSum * 1.0 / Math.min(queue.size(), size);
    }
    
    /**
     * approach 2 using concept of double ended queue
     * Time: O(1)
     * Space: O(n); n is size of moving window
     *
     * @param val
     * @return
     */
    public double approach2(int val) {
        count++;
        dequeue.add(val);
        int valAtHead = count > size ? dequeue.poll() : 0;
        dequeueWindowSum = dequeueWindowSum - valAtHead + val;
        return dequeueWindowSum * 1.0 / Math.min(size, count);
    }
}
