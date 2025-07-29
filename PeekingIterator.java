//Time Complexity: O(1) for peek, next, and hasNext
// Space Complexity: O(1) for storing the peeked element

// Intuition: We need to implement a PeekingIterator that allows us to peek at the next element in 
// the iteration without advancing the iterator.
// We can achieve this by storing the next element in a variable when peek is called, 
// and then returning it when next is called.
// If peek is called again, we can return the stored element without advancing the iterator.
// If next is called, we return the stored element and reset the stored element to null.
// If hasNext is called, we check if the stored element is not null or if the iterator has a next element.
// This way, we can efficiently peek at the next element without losing the iterator's state.
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Integer peekInt;
    Iterator<Integer> basicItr;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.peekInt = null;
        this.basicItr = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekInt != null) {
            return peekInt;
        }
        peekInt = basicItr.next();
        return peekInt;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peekInt != null) {
            Integer temp = peekInt;
            peekInt = null;
            return temp;
        }
        return basicItr.next();
    }

    @Override
    public boolean hasNext() {
        if (peekInt != null) {
            return true;
        }
        return basicItr.hasNext();
    }
}