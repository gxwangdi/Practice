import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> mIterator;
    private Integer mPeek;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    mIterator = iterator;
	    if (mIterator.hasNext()) {
	        mPeek = mIterator.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return mPeek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = mPeek;
	    if (mIterator.hasNext()) {
	        mPeek = mIterator.next();
	    } else {
	        mPeek = null;
	    }
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return mIterator.hasNext() || mPeek!=null;
	}
}


