/** @author Sarthak Goyal
 * 
 */

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SimplePriorityQueue<E> implements PriorityQueue<E> {
	//Declarations
	E[] arr;
	private int size;
	private Comparator<? super E> Comptor;
	
	//Constructor
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue() {
		arr = (E[]) new Object[2000];
		Comptor = null; 
		size = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue(Comparator<? super E> comptor) {
		arr = (E[]) new Object[2000];
		size = arr.length;
		Comptor = comptor;
	}
	
	/**
	 * Retrieves, but does not remove, the minimum element in this priority
	 * queue.
	 * 
	 * @return the minimum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	
	@Override
	public E findMin() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException("Length of the array is 0");
		}
		return arr[size-1]; //Assumes last element is the smallest element.
	}
	
	/**
	 * Retrieves and removes the minimum element in this priority queue.
	 * 
	 * @return the minimum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	@Override
	public E deleteMin() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException("Length of the array is 0");
		}
		E min; 
		min = arr[size-1]; //holds the min element
		arr[size - 1] = null; //sets the min placeholder to null
		size--; //decrements the size
		return min;
	}
	
	/**
	 * Inserts the specified element into this priority queue.
	 * 
	 * @param item - the element to insert
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insert(Object item) {
		E newVal = (E) item;		
		if(size == arr.length - 1) {                              // our resizing causes our timing method to fail so we could not graph insert()
			E[] tempArr = (E[]) new Object[size * 2];
			for(int i = 0; i < tempArr.length; i++) {
				tempArr[i] = arr[i];
			}
			arr = tempArr;
		}
		if(size == 0) {
				arr[0] = (E) item;
				size++;
			}
		
		else {
			int BSearchComparable = binarySearchHelper(arr,newVal);
				for(int i = size - 1; i >= BSearchComparable;  i--) {
					arr[i + 1] = arr[i];
				}
				
			arr[BSearchComparable] = (E) item;
			size++;
		}
	}

	/**
	 * Inserts the specified elements into this priority queue.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	@Override
	public void insertAll(Collection<? extends E> coll) {
		for(E a : arr) {
			insert(a);
		}
	}

	/**
	 * @return the number of elements in this priority queue
	 */
	@Override
	public int size() {
		return size; //gets the size of the array and returns size.
	}

	/**
	 * @return true if this priority queue contains no elements, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Removes all of the elements from this priority queue. The queue will be
	 * empty when this call returns.
	 */
	@Override
	public void clear() {
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public int binarySearchHelper(E[] arr, E target) {
		int low = 0; 
		int high = size - 1; 
		int mid = 0;
		int indexOfElement = -1;
		
		if(Comptor == null) {	                  // checks to see if we are using a comparator or a comparable.	
			
			while(low <= high) {
				mid = (low + high) / 2;
				if(((Comparable<? super E>) target).compareTo(arr[mid]) == 0) {
					low = mid + 1;
				}
				
				if(((Comparable<? super E>) target).compareTo(arr[mid]) < 0) {
					low = mid + 1;
				}
				
				if(((Comparable<? super E>) target).compareTo(arr[mid]) > 0) {
					high = mid - 1;
				}
				indexOfElement = low;
				}
		}

		if(Comptor != null) {
			while(low <= high) {
				mid = (low + high) / 2;
				if(Comptor.compare(target, arr[mid]) == 0) {
					low = mid + 1;
				}
				
				if(Comptor.compare(target, arr[mid]) < 0) {
					low = mid + 1;
				}
				
				if(Comptor.compare(target, arr[mid]) > 0) {
					high = mid - 1;
				}
				indexOfElement = low;
				}
		}
		return indexOfElement;
	}
}
