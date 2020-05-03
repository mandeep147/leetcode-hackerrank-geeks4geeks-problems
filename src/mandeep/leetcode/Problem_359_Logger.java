/**
 * 359. Logger
 * https://leetcode.com/problems/logger-rate-limiter/
 *
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed
 * if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given
 * timestamp, otherwise returns false.
 * It is possible that several messages arrive roughly at the same time.
 *
 * Example:
 *
 * Logger logger = new Logger();
 *
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 *
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */
package mandeep.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class Problem_359_Logger {

    public static void main(String args[]) {
        Problem_359_Logger obj = new Problem_359_Logger();

        System.out.println(obj.shouldPrintMessage(0,""));
        System.out.println(obj.shouldPrintMessage(1,"foo"));
        System.out.println(obj.shouldPrintMessage(2,"bar"));
        System.out.println(obj.shouldPrintMessage(3,"foo"));
        System.out.println(obj.shouldPrintMessage(8,"bar"));
        System.out.println(obj.shouldPrintMessage(10,"foo"));
        System.out.println(obj.shouldPrintMessage(11,"foo"));

    }

    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Problem_359_Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.map.containsKey(message)){ //if message doesn't exist in map print it
            this.map.put(message, timestamp);
            return true;
        }
        Integer time = this.map.get(message); //time msg was printed last
        if(timestamp - time >= 10) {
            this.map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */