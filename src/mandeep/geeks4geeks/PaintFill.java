/**
 * 
 */
package mandeep.geeks4geeks;

/**
 * Given a 2D screen, location of a pixel in the screen and a color, 
 * replace color of the given pixel and all adjacent same colored pixels with the given color.
 * 
 * http://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
 * @author mandeep
 */
public class PaintFill {
	private static int m = 8;
	private static int n = 8;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] screen = {
				{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
           };
		
		int x = 4, y = 4, newColor = 3;
		
		fillPaint(screen, x, y, newColor);
		
		for(int i = 0; i < m ; i++){
			for(int j = 0; j < n; j++){
				System.out.print(screen[i][j]+" ");
			}	
			System.out.println();
		}
	}
	
	/**
	 * weakness: may result in stack overflow
	 * @param screen
	 * @param x
	 * @param y
	 * @param newColor
	 */

	private static void fillPaint(int[][] screen, int x, int y, int newColor) {
		
		int prevColor = screen[x][y];
		
		if(prevColor == newColor)
			return;
		
		floodFillPaint(screen, x, y, prevColor, newColor);
	}

	private static void floodFillPaint(int[][] screen, int x, int y, int prevColor, int newColor) {
		if(x < 0 || y < 0 || x >= screen.length || y >= screen[x].length )
			return;
		
		int currentColor = screen[x][y];
		if(currentColor != prevColor)
			return;
		
		screen[x][y] = newColor;
		
		floodFillPaint(screen, x + 1, y, prevColor, newColor); //right
		floodFillPaint(screen, x - 1, y, prevColor, newColor); //left
		floodFillPaint(screen, x, y + 1, prevColor, newColor); //up
		floodFillPaint(screen, x, y - 1, prevColor, newColor); //down
	}

}