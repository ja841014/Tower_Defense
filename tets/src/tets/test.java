package tets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class test {
	static int ROW;
    static int COLUMN;
    static char[][] table;
    static String WORD;
	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		List<Integer>[] list_array = new ArrayList[4];
//		list_array[0]=new ArrayList<Integer>();
//		list_array[0].add(3);
//		list_array[0].add(10);
//		
//		list_array[1]=new ArrayList<Integer>();
//		list_array[1].add(4);
//		
//		list_array[2]=new ArrayList<Integer>();
//		list_array[2].add(5);
//		
//		list_array[3]=new ArrayList<Integer>();
//		list_array[3].add(6);
//		List<List<Integer> > list = new ArrayList<>();
//		List<Integer> tmp = new ArrayList<>();
//		List<Integer> tmp_ = new ArrayList<>();
//
//		tmp.add(6);
//		tmp.add(7);
//		tmp_.add(10);
//		tmp_.add(11);
//		
//		list.add(tmp);
//		list.add(tmp_);
//		int[][] target = {{1,2},{3,4},{5,6},{6,7},{8,9},{7,8}, {1,4}};
//		
//		Map<Character, Integer> map = new HashMap<>();
//		System.out.println("hi:"+map.containsKey(1));
//		
//		System.out.println(possibleBipartition(10, target));
//		int[] nums = {1,1,1,1,1,2,2,3,3,3,3,4};
//		int k = 2;
//		topKFrequent(nums,k);
//		for(Object te : topKFrequent(nums,k)) {
//			System.out.println(": "+te);
//		}
		
		
		char[][] board = 
//			{{'A','B'}, {'C','D'}};
			{{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		String word  = "ABCCED";
		ROW = board.length;
        COLUMN = board[0].length;
        table = board;
        WORD = word;
//        if(ROW == 0) {
//        	return false;
//        }
		for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if (find_word(i, j, 0, board) == true) {
                        System.out.println("true");
                    }
                    else {
                    	System.out.println("false");
                    }
                }
            }
        }
		
		char[][] grid = {{'1', '1', '0', '0', '0'},
						{'1', '1', '0', '0', '0'},
						{'1', '0', '1', '0', '0'},
						{'0', '0', '0','1', '1'}};
		
		int island = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    island++;
                    find_island(i, j, grid);
                }
            }
        }
		
		
		
		
		
		
		
	}
	
	public static void find_island(int row, int col, char[][] grid) {
        // boolean check = false; 
        // left
        if(row >= 0 && row < grid.length && col - 1 >= 0) {
            if(grid[row][col - 1] == '1') {
                grid[row][col - 1] = '0';
                find_island(row, col - 1, grid);
            }
        }
        // right
        if(row < grid.length && row >= 0 && col + 1<= grid[0].length - 1) {
            if(grid[row][col + 1] == '1') {
                grid[row][col + 1] = '0';
                find_island(row, col + 1, grid);
            }
        }
        // up
        if(row - 1 >= 0 && col >= 0 && col <= grid[0].length - 1) {
            if(grid[row - 1][col] == '1') {
                grid[row - 1][col] = '0';
                find_island(row - 1, col, grid);
            }
        }
        // down
        if(row + 1 < grid.length && col >= 0 && col <= grid[0].length - 1) {
            if(grid[row + 1][col] == '1') {
                grid[row + 1][col] = '0';
                find_island(row + 1, col, grid);
            }
        }
	}
	public static boolean find_word(int row, int col, int cnt, char[][] board) {
	       
        boolean found = false;
//        if(WORD.charAt(cnt) == board[row][col]) {
//        	return true;
//        }
        if(cnt < WORD.length() && col - 1 >= 0 && table[row][col - 1] ==  WORD.charAt(cnt)) {
            table[row][col - 1] = '#';
//                cnt++;
//            if(cnt+1 < WORD.length()) {
            
            	found = find_word(row, col - 1, cnt+1, board);
//            }    
        }
        //right
        if(cnt < WORD.length() && col + 1 <= COLUMN - 1 && table[row][col + 1] ==  WORD.charAt(cnt)) {
            table[row][col + 1] = '#';
//                cnt++;
//            if(cnt+1 < WORD.length()) {
            	found = find_word(row, col + 1, cnt+1, board);
//            }
        }
        //up
        if(cnt < WORD.length() && row - 1 >= 0 && table[row - 1][col] ==  WORD.charAt(cnt)) {
            table[row - 1][col] = '#';
//                cnt++;
//            if(cnt+1< WORD.length()) {
            	found = find_word(row - 1, col, cnt+1, board);
//            }
        }
        //down
        if(cnt < WORD.length() && row + 1 <= ROW - 1 && table[row + 1][col] ==  WORD.charAt(cnt) ) {
            table[row + 1][col] = '#';
//                cnt++;
//            if(cnt+1< WORD.length()) {
            	found = find_word(row + 1, col, cnt+1, board);
//            }
        }
//        }
//        if(found == false) {
//        	visited[row][col] = false;
//        }
        if(cnt == WORD.length()-1) {
        	found = true;
            return found;
        }
        else {
        	return found;
        }
        
    }
	
	
	
	
	    public static List<Integer> topKFrequent(int[] nums, int k) {
	        List<Integer> list = new ArrayList<Integer>(); 
	        Map<Integer, Integer> map = new HashMap<>();
	        // lambda expression
	        Queue<Integer> maxheap = new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));
	        for(int i = 0; i < nums.length; i++) {
	            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
	        }  
	        // map only has keySet(), values(), entrySet()
	        for(Integer key: map.keySet()) {
	            maxheap.add(key);
	        }
	        
	         for(int i = 0; i < k; i++) {
	             list.add(maxheap.poll());
	         }
	        return list;
	    }




	
	
	
	 public static boolean possibleBipartition(int N, int[][] dislikes) {
		 Map<Integer, Set<Integer>> edgemap = new HashMap<>();
	        for(int i = 0; i < N; i++) {
	            edgemap.put(i, new HashSet<>());
	        }
	        for(int i = 0; i < dislikes.length; i++) {
	            edgemap.get(dislikes[i][0]).add(dislikes[i][1]);
	            edgemap.get(dislikes[i][1]).add(dislikes[i][0]);
	        }
	        Iterator set_it = edgemap.get(1).iterator(); 
	        while(set_it.hasNext()) {
	        	System.out.println(set_it.next());
	        }
	        
		 return true;
		 	
	 }

}
