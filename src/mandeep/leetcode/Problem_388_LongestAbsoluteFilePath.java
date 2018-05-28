/**
 * Problem 388
 * Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
package mandeep.leetcode;

import java.util.HashMap;

/**
 * @author mandeep
 * created on May 27, 2018, 11:14:54 PM
 */
public class Problem_388_LongestAbsoluteFilePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println("the longest file path: "+absoluteFilePath(str));
	}

	/**
	 * @param str
	 * @return
	 */
	private static int absoluteFilePath(String str) {
		if( str.length() == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		String[] paths = str.split("\n");
		for(String path : paths){
			String dir = path.replaceFirst("\\t*", "");
			int level = path.lastIndexOf("\t") +1;
			int prefix = 0;
			if(level > 0)
				prefix = map.get(level-1);
			int pathlen = prefix + dir.length();
			if(dir.contains("."))
				max = Math.max(pathlen+level, max);
			map.put(level, pathlen);
		}
		return max;
	}

}
