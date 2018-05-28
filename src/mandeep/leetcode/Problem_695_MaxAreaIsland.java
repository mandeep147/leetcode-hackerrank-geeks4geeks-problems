/**
 * Problem 695: Max Area of Island
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
package mandeep.leetcode;

/**
 * @author mandeep
 *
 */
public class Problem_695_MaxAreaIsland {

	static private boolean[][] seen;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}	 
			};
		
		System.out.println("max area of an island is: "+maxArea(grid));
	}

	/**
	 * Time = O(row * col) 
	 * Space = O(row * col) + stack space
	 * @param grid
	 * @return
	 */
	private static int maxArea(int[][] grid) {
		seen = new boolean[grid.length][grid[0].length];
		int res = 0;
		
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++)
				res = Math.max(res, area(grid, row, col));
		}
		return res;
	}

	/**
	 * @param row
	 * @param col
	 * @return
	 */
	private static int area(int[][] grid, int row, int col) {
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || seen[row][col] || grid[row][col] == 0)
			return 0;
		
		seen[row][col] = true;
		return (1 + area(grid, row+1, col) + area(grid, row-1, col) + area(grid, row, col+1) + area(grid, row, col-1));
	}

}