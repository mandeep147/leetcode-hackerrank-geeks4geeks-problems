/**
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mandeep
 * created on Mar 1, 2018, 1:00:35 AM
 */
public class Problem_56_MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		
		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		
		List<Interval> res = merge(list);
		
		for(Interval inter : res){
			System.out.print(inter.start+" "+inter.end);
			System.out.println();
		}
	}

	/**
	 * TIme: O(nlogn)
	 * Space: O(n)
	 * @param intervals
	 * @return
	 */
	private static List<Interval> merge(List<Interval> intervals){
		Collections.sort(intervals, new IntervalComparator());
		LinkedList<Interval> merged = new LinkedList<>();
		for(Interval inter: intervals){
			if(merged.isEmpty() || merged.getLast().end < inter.start)
				merged.add(inter);
			else
				merged.getLast().end = Math.max(merged.getLast().end, inter.end);
		}
		
		return merged;
	}
	
	private static class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval a, Interval b){
			return a.start < b.start ? -1: a.start == b.start? 0 : 1;
		}
	}
}

class Interval{
	int start;
	int end;
	
	public Interval(){
		start = 0;
		end = 0;
	}
	
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}