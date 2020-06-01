package pair;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Pair_programmingTest {
	public static Pair_programming Pair_Test = new Pair_programming() ;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandom() {
		int left, right, operator ;
		Pair_Test.random() ;
		left = Pair_Test.Getleft() ;
		right = Pair_Test.Getright() ;
		operator = Pair_Test.Getoperator() ;
		assertFalse("������������󣡣�", left < 0 || left > 100 || right < 0 || right > 100 || operator < 0 || operator > 3 ) ;
	}

	@Test
	public void testAdd() {
		int answer ;
		answer = Pair_Test.add(5, 20) ;
		assertEquals("�ӷ����󣡣�", 25, answer) ;
		answer = Pair_Test.add(30, 40) ;
		assertEquals("�ӷ����󣡣�", 70, answer) ;
		answer = Pair_Test.add(49, 51) ;
		assertEquals("�ӷ����󣡣�", 100, answer);
		answer = Pair_Test.add(50, 52) ;
		assertNotEquals("�ӷ����󣡣�", 102, answer);
		
	} 

	@Test
	public void testSubtract() {
		int answer ;
		answer = Pair_Test.subtract(50, 20) ;
		assertEquals("�������󣡣�", 30, answer) ;
		answer = Pair_Test.subtract(70, 10) ;
		assertEquals("�������󣡣�", 60, answer) ;
		answer = Pair_Test.subtract(60, 60) ;
		assertEquals("�������󣡣�", 0, answer) ;
		answer = Pair_Test.subtract(50, 100) ;
		assertTrue("�������󣡣�", answer > 0) ;
	}

	@Test
	public void testMultiple() {
		int answer ;
		answer = Pair_Test.multiple(3, 10) ;
		assertEquals("�˷����󣡣�", 30, answer) ;
		answer = Pair_Test.multiple(25, 3) ;
		assertEquals("�˷����󣡣�", 75, answer) ;
		answer = Pair_Test.multiple(10, 10) ;
		assertEquals("�˷����󣡣�", 100, answer) ;
		answer =  Pair_Test.multiple(50, 100) ;
		assertTrue("�˷����󣡣�", answer <= 100) ;

	}

	@Test
	public void testDivision() {
		int left, right, answer ;
		answer = Pair_Test.division(20, 5) ;
		assertEquals("�������󣡣�", 4, answer) ;
		answer = Pair_Test.division(27, 3) ;
		assertEquals("�������󣡣�", 9, answer) ;
		
		answer = Pair_Test.division(30, 9) ;
		left = Pair_Test.Getleft();
		right = Pair_Test.Getright();
		if(left/right != 3) {
			assertTrue("�������󣡣�", answer != 3);
		}
		answer = Pair_Test.division(71, 30) ;
		left = Pair_Test.Getleft();
		right = Pair_Test.Getright();
		if(left/right != 2) {
			assertTrue("�������󣡣�", answer != 2);
		}
		
		answer = Pair_Test.division(40, 0) ;
	}
	
	@Test
	public void testUser_Answer() {
			// ���������ַ���С��0����
			assertFalse("���������0�Ĵ�", Pair_Test.User_Answer() < 0) ;
	}
}
