/**
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:

Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Day22_RandomPointInNonOverlappingRectangles {
    Random random;
    TreeMap<Integer,int[]> map;
    int areaSum = 0;
    public Solution(int[][] rects) {
        random = new Random();
        map = new TreeMap<>();
        
        for(int i = 0; i < rects.length; i++){
            int[] rectangleCoordinates = rects[i];
            int length = rectangleCoordinates[2] - rectangleCoordinates[0] + 1;
            int breadth = rectangleCoordinates[3] - rectangleCoordinates[1] + 1;
            
            areaSum += length * breadth;
            
            map.put(areaSum,rectangleCoordinates);
        }
    }
    
    public int[] pick() {
        //random.nextInt gives a int in the range of 0 to areaSum and ceilingKey returns a key greater than or equal to the argument passed
        //to it.
        int key = map.ceilingKey(random.nextInt(areaSum) + 1);
        int[] rectangle = map.get(key);
        
        int length = rectangle[2] - rectangle[0] + 1;
        int breadth = rectangle[3] - rectangle[1] + 1;
        
        //length denotes the no of x coordinates we can have.
        //breadth denotes the no of y coordinates we can have
        
        //random.nextInt gives a random value from x1 - x2-1 which we can add to the current x and we can have a valid x .
        //random.nextInt gives a random value from y1 - y2-1 which we can add to the current y and we can have a valid y .
        
        int x = rectangle[0] + random.nextInt(length);
        int y = rectangle[1] + random.nextInt(breadth);
        
        return new int[]{x,y};
    }
}