package mandeep.leetcode;

/**
 * https://leetcode.com/discuss/interview-question/394347/
 * @author mandeep
 */
public class Problem_WateringFlowers {
    public static void main(String args[]) {
        int[] plants = {2, 4, 5, 1, 2, 2};
        int capacity1 = 5;
        int capacity2 = 7;
        int numberOfRefills = solution(plants, capacity1, capacity2);
        System.out.println(numberOfRefills);
    }

    public static int solution(int[] plants, int capacity1, int capacity2) {
        if(plants == null || plants.length == 0)
            return 0;

        if(plants.length == 1 && (plants[0] <= Math.max(capacity1, capacity2)))
            return 1;

        int refills = 2; // one for each friend at starting point
        int cap1 = capacity1;

        // iterate for first half (left -> right)
        for(int i = 0; i < plants.length/2; i++) {
            if(cap1 >= plants[i]) {
                cap1 -= plants[i];
            } else {
                refills++;
                cap1 = capacity1;
                cap1 -= plants[i];
            }
        }

        int cap2 = capacity2;
        int mid = plants.length/2;
        if(plants.length%2 == 0 ) {
            mid = mid - 1;
        }
        //iterate right -> left for half the array
        for(int i = plants[plants.length-1]; i > mid ; i--) {
            if(cap2 >= plants[i]) {
                cap2 -= plants[i];
            } else {
                refills++;
                cap2 = capacity2;
                cap2 -= plants[i];
            }
        }

        // check the middle element for odd length
        if(plants.length%2 == 1) {
            if(cap1 + cap2 < plants[plants.length/2])
                refills++;
        }
        return refills;
    }
}
