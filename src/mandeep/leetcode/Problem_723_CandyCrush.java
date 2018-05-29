/**
 * This question is about implementing a basic elimination algorithm for Candy Crush.

Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:

If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
You need to perform the above rules until the board becomes stable, then return the current board.

Example 1:
Input:
board = 
[[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
Output:
[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]] 

 */
package mandeep.leetcode;

/**
 * @author mandeep
 * created on May 22, 2018, 4:29:54 PM
 */
public class Problem_723_CandyCrush {

	public static void main(String[] args){
		
	}
	
	public int[][] candyCrush(int[][] b){
		int r = b.length;
		int c = b[0].length;
		boolean todo = false;
		
		//column
		for(int i = 0; i < r; i++){
			for(int j = 0; j +2 < c; j++){
				int v = Math.abs(b[i][j]);
				if(v != 0 && v == Math.abs(b[i][j+1]) && v == Math.abs(b[i][j+2])){
					b[i][j] = b[i][j+1] = b[i][j+2] = -v;
					todo = true;
				}
			}
		}
		
		//row
		for(int i = 0; i +2 < r; i++){
			for(int j = 0; j < c; j++){
				int v = Math.abs(b[i][j]);
				if(v != 0 && v == Math.abs(b[i+1][j]) && v == Math.abs(b[i+2][j])){
					b[i][j] = b[i+1][j] = b[i+2][j] = -v;
					todo = true;
				}
			}
		}
		
		//gravity step
		for(int i = 0; i < c; i++){
			int wr = r - 1;
			for(int j = r-1; j >0; j--){
				if(b[i][j] > 0)
					b[wr--][i] = b[j][i];
				while(wr>= 0)
					b[wr--][i] = 0;
			}
		}
		return todo ? candyCrush(b) : b;
	}
}
