
package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class doubletest {


	doubly_linkedlist test= new doubly_linkedlist();
	
		
	

	@Test
	void test1() {
		
		test.add(5);
		assertEquals(5,test.get(0));
	
		assertThrows(RuntimeException.class,()->{test.get(6);});
		
	}
	
	
	@Test
	void test2() {
		test.add(5);
		test.add(0,888);
		assertEquals(888,test.get(0));
		assertEquals(5,test.get(1));
		assertThrows(RuntimeException.class,()->{test.add(6,700);});
		
	}
	
	@Test
	void test3() {
		test.add(5);
		test.set(0, 10000);
		assertEquals(10000,test.get(0));
		assertThrows(RuntimeException.class,()->{	test.set(5, 10000);});
	}
	
	@Test
	void test4() {
		test.add(5);
		assertEquals(5,test.sublist(0, 0).get(0));
		
		assertEquals(1,test.sublist(0,0 ).size());
		assertThrows(RuntimeException.class,()->{test.sublist(1, 3).get(6);});
		
	}
	
	
	@Test
	void test5() {
		test.add(5);
		test.remove(0);
		assertEquals(0,test.size());
		assertThrows(RuntimeException.class,()->{test.get(0);});
		assertThrows(Exception.class,()->{test.remove(0);});
		
		
	}
	
	@Test
	void test6() {
		test.add(5);
		assertEquals(true,test.contains(5));
		assertEquals(false,test.contains(700));
		
	}
	
	
	@Test
	void test7() {
		test.add(5);
		test.clear();
		assertEquals(0,test.size());
		assertThrows(RuntimeException.class,()->{test.get(0);});
		assertThrows(RuntimeException.class,()->{test.clear();});
	
		
		
	}
	
	@Test
	void test8() {
		
		test.add(5);
		test.add(100);
		test.add(80);
		test.add(555);
		test.add(333);
		test.add(2,222);
		assertEquals(222,test.get(2));
		assertEquals(80,test.get(3));
		assertEquals(555,test.get(4));
		assertEquals(333,test.get(5));
	
		assertThrows(RuntimeException.class,()->{test.get(6);});
		
	}
	
	@Test
	void test9() {
	
		assertThrows(RuntimeException.class,()->{test.clear();});
	}
	
	
	@Test
	void test10() {
		
		test.add(5);
		test.add(100);
		test.add(80);
		test.add(555);
		test.add(333);
		
assertEquals(100,test.sublist(1, 2).get(0));
assertEquals(80,test.sublist(1, 2).get(1));

		
		assertEquals(2,test.sublist(1,2 ).size());
		assertThrows(RuntimeException.class,()->{test.sublist(1, 2).get(6);});
	}
}
