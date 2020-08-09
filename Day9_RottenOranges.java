/**
 * In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
 */
public class Day9_RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid.length==0 || grid[0].length == 0)
           return 0;
        
        int n= grid.length;
        int m= grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        int freshOranges = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j< grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] {i, j});
                
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        
        if (freshOranges == 0)
            return 0;
        
        int res = 0;
        int convertCount = 0;
        int dir[][] = {{1, 0}, {-1, 0}, {0,1}, {0, -1}};
            
        while (q.isEmpty() == false) {
            int qSize = q.size();
            
            if (convertCount == freshOranges)
                return res;
            for (int i=0; i<qSize; i++) {
                int point[] = q.poll();
                
                for (int in=0; in<dir.length; in++) {
                    int nx = point[0] + dir[in][0];
                    int ny = point[1] + dir[in][1];
                    
                    if (nx >=0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        convertCount++;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
            res++;
        }
        
        return -1;
    }
}