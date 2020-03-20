package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomialSolvertester {
       PolynomialSolver test =new PolynomialSolver();
       
	@Test
	void test0() {
		int[][] t= {{5,0},{3,2}};
		test.setPolynomial('A', t);
		assertEquals("3x^2+5",test.print('A'));
	}
	@Test
	void test1() {
		
	
		assertThrows(RuntimeException.class,()->{test.print('A');});
	}
	
	@Test
	void test2() {
		int[][] a= {{5,6},{2,-6}};
		int[][] b= {{5,0}};
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		assertEquals("5",test.print('B'));
		assertEquals("5x^6+2x^-6",test.print('A'));
	}
	
	@Test
	void test3() {
		int[][] t= {{5,111}};
		test.setPolynomial('A', t);
		assertEquals("5x^111",test.print('A'));
	}
	
	@Test
	void test4() {
		int[][] a= {{5,6},{2,-6}};
		int[][] b= {{5,0}};
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		assertEquals("5x^6+2x^-6",test.print('A'));
		assertEquals("5",test.print('B'));
	}
	
	@Test
	void test5() {
		int[][] a= {{5,6},{2,-6}};
		test.setPolynomial('A', a);
		test.clearPolynomial('A');
		assertThrows(RuntimeException.class,()->{test.print('A');});
		
	}
	
	@Test
	void test6() {
		int[][] a= {{5,6},{2,-2}};
		int[][] b= {{5,0},{2,2},{4,1}};
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		test.add('A', 'B');
		assertEquals("5x^6+2x^2+4x^1+5+2x^-2",test.print('R'));
	}
	
	@Test
	void test7() {
		int[][] a= {{5,6},{2,-2}};
		int[][] b= {{5,0},{2,2},{4,1}};
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		test.subtract('A', 'B');
		assertEquals("5x^6-2x^2-4x^1-5+2x^-2",test.print('R'));
	}
	
	@Test
	void test8() {
		int[][] a= {{-2,6},{2,-2}};
		int[][] b= {{1,0},{-2,-2},{4,1}};
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		test.subtract('A', 'B');
		assertEquals("-2x^6-4x^1-1+4x^-2",test.print('R'));
	}
	
	@Test
	void test9() {
		int[][] a= {{-2,6},{2,2}};
		test.setPolynomial('A', a);
	
		assertEquals(0,test.evaluatePolynomial('A', 0));
	}
	
	@Test
	void test10() {
		int[][] a= {{-2,2},{1,2}};
		test.setPolynomial('A', a);
	
		assertEquals(-12.25,test.evaluatePolynomial('A', 3.5f));
	}
	
	@Test
	void test11() {
		int[][] a= {{-2,6},{2,-2}};
		int[][] b= {{1,0},{-2,-2},{4,1}};
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		test.multiply('A', 'B');
		assertEquals("-8x^7-2x^6+4x^4+8x^-1+2x^-2-4x^-4",test.print('R'));
	}
	
	@Test
	void test12() {
		int[][] a= {{-2,0},{2,-2}};
		int[][] b= {{1,0}};
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		test.multiply('A', 'B');
		assertEquals("-2+2x^-2",test.print('R'));
	}
	
	
}
