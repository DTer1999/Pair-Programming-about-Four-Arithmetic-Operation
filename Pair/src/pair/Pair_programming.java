package pair;

import java.util.Random;
import java.util.Scanner;

public class Pair_programming {

	private int left;
	private int right;
	private int operator;
	
	// 读取和写入get、set
	public void Setleft(int left) {
		this.left = left ;
	}	
	public int Getleft() {
		return left;
	}
	public void Setright(int right) {
		this.right = right ;
	}	
	public int Getright() {
		return right;
	}
	public void Setoperator(int operator) {
		this.operator = operator ;
	}	
	public int Getoperator() {
		return operator;
	}
	
	/*
	 * function：产生3个随机数，分别对应运算数1、运算数2、运算符 error：random函数如何生成随机数 
	 * write：MaLe
	 * guide：DingTao
	 **/
	public void random() {
		int left, right, operator ;
		Random rand = new Random();
		left = (int) (Math.random() * 100) ;
		right = (int) (Math.random() * 100);
		operator = rand.nextInt(3); // 0-3,0代表+，1代表-，2代表*，3代表/
		Setright(right) ;
		Setleft(left) ;
		Setoperator(operator) ;
	}

	/*
	 * function：创建一个四则运算式
	 * write：DingTao guide：MaLe
	 */
	
	// 加法
	public int add(int left, int right) {
		while (left + right > 100) {
			random() ;
			left = Getleft() ;
			right = Getright() ;
		}
		System.out.println(left + "+" + right + "=" + "?"); // 50+20=?
		return left + right ;
	}
	// 减法
	public int subtract(int left, int right) {
		while (left - right < 0) {
			random() ;
			left = Getleft() ;
			right = Getright() ;
		}
		System.out.println(left + "-" + right + "=" + "?"); // 50-20=?
		return left - right ;
	}
	// 乘法
	public int multiple(int left, int right) {
		while (left * right > 100) {
			random() ;
			left = Getleft() ;
			right = Getright() ;
		}
		System.out.println(left + "*" + right + "=" + "?");
		return left * right ;
	}
	// 除法
	public int division(int left, int right) {
		while (right == 0 || left % right != 0) {
			random() ;
			left = Getleft() ;
			right = Getright();
		}
		System.out.println(left + "/" + right + "=" + "?"); // 40/20=?
		return left / right ;
	}
	
	// 创建一个运算式
	public int create() {
		int left, right, operator, sys_answer ;
		left = Getleft() ;
		right = Getright() ;
		operator = Getoperator() ;
		switch (operator) {
		case 0:
			sys_answer = add(left, right) ;
			break;
		case 1:
			sys_answer = subtract(left, right) ;
			break;
		case 2:
			sys_answer = multiple(left, right) ;
			break;
		case 3:
			sys_answer = division(left, right) ;
			break;
		default:
			System.out.println("运算符随机数错误！！！");
			return -1;
		}
		return sys_answer;
	}
	
	public int User_Answer() {
		int answer ;
		Scanner input = new Scanner(System.in) ;
		try {
			System.out.println("请输入答案（正整数）：");
			answer = input.nextInt() ;
			if(answer <0 ) {
				System.out.println("结果需为正，请重新输入：") ;
				return -1;
			}
		} catch(Exception e) {
			System.out.println("请输入整数：") ;
			return -1;
		} 
		return answer ;
	}
	
	public int check(int user_answer, int sys_answer) {
		if(user_answer == sys_answer) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	/*
	 * function:机器创建10道题目，判定对错，给出正确数及分数。 
	 * question:Cannot make a static reference to the non-static method create() from the type main
	 * solve:创建一个Pair_programming类的对象pair,重新调用该对象中的create()函数。
	 * write：Ma Le 、Ding Tao
	 * 
	 */
	public static void main(String[] args) {
		int sys_answer, user_answer, count = 0, score = 0 ;// count正确的题目数
		Pair_programming pair = new Pair_programming() ;
		for (int i = 0; i < 10; i++) {
			pair.random() ;
			sys_answer = pair.create() ;
			do {
				user_answer = pair.User_Answer() ;
			}
			while (user_answer == -1);
			 
			if( pair.check(user_answer, sys_answer) == 1) {
				count++ ;
				score += 10 ;
				System.out.println("true") ;
			} else {
				System.out.println("false") ;
			}
		}
		System.out.println("你做对了" + count + "题目,你的得分为" + score);
	}
}
