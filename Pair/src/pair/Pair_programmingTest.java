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
		assertFalse("随机数产生错误！！", left < 0 || left > 100 || right < 0 || right > 100 || operator < 0 || operator > 3 ) ;
	}

	@Test
	public void testAdd() {
		int answer ;
		answer = Pair_Test.add(5, 20) ;
		assertEquals("加法错误！！", 25, answer) ;
		answer = Pair_Test.add(30, 40) ;
		assertEquals("加法错误！！", 70, answer) ;
		answer = Pair_Test.add(49, 51) ;
		assertEquals("加法错误！！", 100, answer);
		answer = Pair_Test.add(50, 52) ;
		assertNotEquals("加法错误！！", 102, answer);
		
	} 

	@Test
	public void testSubtract() {
		int answer ;
		answer = Pair_Test.subtract(50, 20) ;
		assertEquals("减法错误！！", 30, answer) ;
		answer = Pair_Test.subtract(70, 10) ;
		assertEquals("减法错误！！", 60, answer) ;
		answer = Pair_Test.subtract(60, 60) ;
		assertEquals("减法错误！！", 0, answer) ;
		answer = Pair_Test.subtract(50, 100) ;
		assertTrue("减法错误！！", answer > 0) ;
	}

	@Test
	public void testMultiple() {
		int answer ;
		answer = Pair_Test.multiple(3, 10) ;
		assertEquals("乘法错误！！", 30, answer) ;
		answer = Pair_Test.multiple(25, 3) ;
		assertEquals("乘法错误！！", 75, answer) ;
		answer = Pair_Test.multiple(10, 10) ;
		assertEquals("乘法错误！！", 100, answer) ;
		answer =  Pair_Test.multiple(50, 100) ;
		assertTrue("乘法错误！！", answer <= 100) ;

	}

	@Test
	public void testDivision() {
		int left, right, answer ;
		answer = Pair_Test.division(20, 5) ;
		assertEquals("除法错误！！", 4, answer) ;
		answer = Pair_Test.division(27, 3) ;
		assertEquals("除法错误！！", 9, answer) ;
		
		answer = Pair_Test.division(30, 9) ;
		left = Pair_Test.Getleft();
		right = Pair_Test.Getright();
		if(left/right != 3) {
			assertTrue("除法错误！！", answer != 3);
		}
		answer = Pair_Test.division(71, 30) ;
		left = Pair_Test.Getleft();
		right = Pair_Test.Getright();
		if(left/right != 2) {
			assertTrue("除法错误！！", answer != 2);
		}
		
		answer = Pair_Test.division(40, 0) ;
	}
	
	@Test
	public void testUser_Answer() {
			// 尝试输入字符或小于0的数
			assertFalse("请输入大于0的答案", Pair_Test.User_Answer() < 0) ;
	}
}
