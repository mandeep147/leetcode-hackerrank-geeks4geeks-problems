/**
 * 
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
