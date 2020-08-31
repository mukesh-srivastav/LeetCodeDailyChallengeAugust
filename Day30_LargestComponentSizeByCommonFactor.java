/**
 *  Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

 

Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

Note:

1 <= A.length <= 20000
1 <= A[i] <= 100000
 */
public class Day30_LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] A) {

		int maxVal = Integer.MIN_VALUE;
		for (int a : A) {
			maxVal = Math.max(maxVal, a);
		}

		UnionFind uf=new UnionFind(maxVal+1);
		for(int a:A){
			for(int i=2;i<=Math.sqrt(a);i++){
				if(a%i==0){
					uf.union(a,i);
					uf.union(a,a/i);
				}
			}
		}

		int max=1;
		Map<Integer, Integer> map = new HashMap<>();

		for(int a:A){
			int parent=uf.find(a);
			map.put(parent,map.getOrDefault(parent,0)+1);
			max=Math.max(max,map.get(parent));
		}

		return max;
	}

	class UnionFind{

		int[] ar;

		UnionFind(int len){
			ar=new int[len];
			for(int i=0;i<len;i++){
				ar[i]=i;
			}
		}

		int find(int x){
			if(x!=ar[x]){
				ar[x]=find(ar[x]);
			}
			return ar[x];
		}

		void union(int x,int y){
			ar[find(x)]=ar[find(y)];
		}
	} 
}