import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SimplePriorityQueueTest {
	
	SimplePriorityQueue a = new SimplePriorityQueue();
	
	int arr01[] = new int[] {6,5,3,2,1};
	int arr02[] = new int[] {6};
	int arr04[] = new int[] {3,2,1};
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	@Test
	public void FindMinTestTrue() {
		a.insert(4);
		a.insert(3);
		a.insert(3);
		a.insert(1);
		assertEquals(1, a.findMin());
	}
	
	@Test
	public void FindMinTest2() {
		a.insert(6);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(1);
		a.insert(5);
		assertEquals(1, a.findMin());
	}
	
	@Test
	public void FindMinTest3() {
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.insert(6);
		assertEquals(1, a.findMin());
	}
	
	@Test
	public void FindMinTestStrings() {
		a.insert("studentA");
		a.insert("studentB");
		a.insert("studentC");
		a.insert("studentD");	
		a.insert("studentE");
		a.insert("studentF");
		assertEquals("studentA", a.findMin());
	}
	
	@Test
	public void deleteMinTest() {
		a.insert(6);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(1);
		a.insert(5);
		assertEquals(1, a.deleteMin());
	}
	
	
	@Test
	public void clearTest() {
		a.insert("studentA");
		a.insert("studentB");	
		a.insert("studentC");
		a.insert("studentD");
		a.clear();
		assertTrue(a.isEmpty());
	}
	
	@Test
	public void isNotEmptyTest() {
		a.insert("studentA");
		a.insert("studentB");	
		a.insert("studentC");
		a.insert("studentD");
		assertFalse(a.isEmpty());
	}
	
	@Test
	public void clearTestInt() {
		a.insert(6);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(1);
		a.insert(5);
		a.clear();
		assertTrue(a.isEmpty());
	}
	
	@Test
	public void isNotEmptyTestInt() {
		a.insert(6);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(1);
		a.insert(5);
		assertFalse(a.isEmpty());
	}
	
	@Test
	public void sizeTest() {
		a.insert(6);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(1);
		a.insert(5);
		assertEquals(6, a.size());
	}
	
	@Test
	public void sizeTestString() {
		a.insert("studentA");
		a.insert("studentB");	
		a.insert("studentC");
		a.insert("studentD");
		assertEquals(4, a.size());
	}

}
