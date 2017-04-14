/* Name: Julia Mini    
 * Lab Section: Thursday Afternoon 1-4
 * Lab: Two Towers, Lab 7
 */
import structure5.*;

// program that solves the two tower problem by iterating over every possible subset
public class TwoTowers {

  
    public static void main(String args[]) {

	// Set n to 15 by default but allow user to specify with argument
	int n = 15;
	try {
	    n = Integer.parseInt(args[0]);
	} catch(ArrayIndexOutOfBoundsException e) {
	    System.out.println("Using default n of 15...");
	} catch(NumberFormatException e) {
	    System.out.println("n must be an integer. Using n = 15...");
	}
	// target height for a single tower, h/2
	double targetHeight = targetHeight(n);
	// best height so far
	double bestHeight = 0;
	// mask associated with best height
	int bestMask = 0;
	// top of the range used for mask
	double max = Math.pow(2, n);
	// iterate over all possible subsets of n blocks and stores the height
	// and mask if they are better than the best
	for(int mask = 0; mask < max; mask++){
	    double height = heightFromMask(mask, n);
	    if(height <= targetHeight && height > bestHeight){
		bestHeight = height;
		bestMask = mask;
	    }
	}
	System.out.println("First Tower");
	printBlocks(bestMask, n, 0);
	System.out.println("\nSecond Tower");
	printBlocks(bestMask, n, 1);
	System.out.println("\nBest Solution Height of One Tower");
	System.out.println(bestHeight);
	System.out.println("\nDifference in Tower Heights");
	System.out.println((targetHeight-bestHeight)*2);
    }

    // computes the total height of n blocks and divides by 2, the ideal solution
    public static double targetHeight(int n){
	double totalHeight = 0;
	for(int i=1; i<= n; i++){
	    totalHeight +=  Math.sqrt(i);
	}
	return totalHeight/2;
    }

    // converts bit mask to a height
    public static double heightFromMask(int mask, int n){
	double height = 0;
	for(int block = 1; block <= n; block++){
	    int b = mask & 1;
	    if(b == 1){
		height += Math.sqrt(block);
	    }
	    mask = mask >> 1;
	}
	return height;
    }
    
    // prints the number on the face of a block in a particular tower
    public static void printBlocks(int mask, int n, int tower){
	for(int block = 1; block <= n; block++){
	    int b = mask & 1;
            if(b == tower){
                System.out.println(block);
            }
            mask = mask >> 1;
	}
    }
    
    
}
