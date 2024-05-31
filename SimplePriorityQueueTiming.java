/**
 * @author Sarthak Goyal
 */

import java.util.ArrayList;
import java.util.Random;


public class SimplePriorityQueueTiming {
	
		public static void main(String[] args) {
			int[] arr1 = new int[10000];

			  // Do 10000 lookups and use the average running time.
		    int timesToLoop = 10000;
		    
		    
		    
		    // For each problem size n . . .
		    for (int n = 100000; n <= 2000000; n += 100000) {
		      SimplePriorityQueue randIntArr = new SimplePriorityQueue();
		      
		      for(int i = 1000; i > 0 ; i--) {
		    	  randIntArr.insert(i);
				}

		      long startTime, midpointTime, stopTime;

		      startTime = System.nanoTime();
		      while (System.nanoTime() - startTime < 1000000000) { // empty block 
		      }

		      // Now, run the test.  
		      startTime = System.nanoTime();

		      for (int i = 0; i < timesToLoop; i++) {
		    	  randIntArr.findMin();
		      }

		      midpointTime = System.nanoTime();

		      for (int i = 0; i < timesToLoop; i++) {
		    	  for(int j = 100; j > 0; j--) {
		        randIntArr.insert(i);
		    	  }
		      }

		      stopTime = System.nanoTime();

		      // Compute the time, subtract the cost of running the loop
		      // from the cost of running the loop and doing the lookups.
		      // Average it over the number of runs.
		      double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
		          / timesToLoop;

		      System.out.println(n + "\t" + averageTime);
		  }

		}
		
}



