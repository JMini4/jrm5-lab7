/*
 * Name: Julia Mini
 * Lab Section: Thursday Afternoon 1-4
 * Lab: Two Towers, Lab 7
 */

import structure5.*;
import java.util.Iterator;

// initialized from another iterator and a bit mask, and then iterates over
// elements from the first iterator that correspond to 1’s in the bit mask
public class SubsetIterator<E> implements Iterator<E> {

    private Iterator<E> it;
    private int bitMask;

    /* 
     * pre:
     * post: constructs iterator from another iterator and bit mask
     */
    public SubsetIterator(Iterator<E> it, int bitMask) {
	this.it = it;
	this.bitMask = bitMask;
    }

    /* 
     * post: True if there are more elements in this subset.
     */
    public boolean hasNext() {
	return bitMask != 0 && it.hasNext();
    }

    /* 
     * pre: hasNext() is true
     * post: returns current value and increments the iterator
     */
    public E next() {
	int b = 0;
	E next = null;
	while(b == 0){
	    b = bitMask & 1;
	    bitMask = bitMask >> 1;
	    next = it.next();
	}
	return next;
    }

    /* Does nothing */
    public void remove() { }
}


