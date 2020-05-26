/**
 * Problem 200 Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
package leetcode;

/**
 * @author mandeep
 * created on Feb 27, 2018, 11:19:21 PM
 */
public class Problem_200_NumberOfIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};
		
		System.out.println("number of islands: "+numIslands(grid));
	}

	/**
	 * DFS
	 * Time: O(m*n)
	 * Space: O(m*n)
	 * @param grid
	 * @return
	 */
	private static int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		
		int count = 0;
		int nr = grid.length;
		int nc = grid[0].length;
		
		for(int i = 0; i < nr; i++){
			for(int j = 0; j < nc; j++){
				if(grid[i][j] == '1'){
					count++;
					dfs(grid, i, j);
				}
			}
		}
		
		return count;
	}

	/**
	 * @param grid
	 * @param row
	 * @param col
	 */
	private static void dfs(char[][] grid, int row, int col) {
		int nr  = grid.length;
		int nc = grid[0].length;
		
		if(row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0')
			return;
		
		grid[row][col] = '0';
		dfs(grid, row-1, col);
		dfs(grid, row+1, col);
		dfs(grid, row, col-1);
		dfs(grid, row, col+1);
	}

}