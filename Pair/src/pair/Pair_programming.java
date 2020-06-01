package pair;

import java.util.Random;
import java.util.Scanner;

public class Pair_programming {

	private int left;
	private int right;
	private int operator;
	
	// ��ȡ��д��get��set
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
	 * function������3����������ֱ��Ӧ������1��������2������� error��random���������������� 
	 * write��MaLe
	 * guide��DingTao
	 **/
	public void random() {
		int left, right, operator ;
		Random rand = new Random();
		left = (int) (Math.random() * 100) ;
		right = (int) (Math.random() * 100);
		operator = rand.nextInt(3); // 0-3,0����+��1����-��2����*��3����/
		Setright(right) ;
		Setleft(left) ;
		Setoperator(operator) ;
	}

	/*
	 * function������һ����������ʽ
	 * write��DingTao guide��MaLe
	 */
	
	// �ӷ�
	public int add(int left, int right) {
		while (left + right > 100) {
			random() ;
			left = Getleft() ;
			right = Getright() ;
		}
		System.out.println(left + "+" + right + "=" + "?"); // 50+20=?
		return left + right ;
	}
	// ����
	public int subtract(int left, int right) {
		while (left - right < 0) {
			random() ;
			left = Getleft() ;
			right = Getright() ;
		}
		System.out.println(left + "-" + right + "=" + "?"); // 50-20=?
		return left - right ;
	}
	// �˷�
	public int multiple(int left, int right) {
		while (left * right > 100) {
			random() ;
			left = Getleft() ;
			right = Getright() ;
		}
		System.out.println(left + "*" + right + "=" + "?");
		return left * right ;
	}
	// ����
	public int division(int left, int right) {
		while (right == 0 || left % right != 0) {
			random() ;
			left = Getleft() ;
			right = Getright();
		}
		System.out.println(left + "/" + right + "=" + "?"); // 40/20=?
		return left / right ;
	}
	
	// ����һ������ʽ
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
			System.out.println("�������������󣡣���");
			return -1;
		}
		return sys_answer;
	}
	
	public int User_Answer() {
		int answer ;
		Scanner input = new Scanner(System.in) ;
		try {
			System.out.println("������𰸣�����������");
			answer = input.nextInt() ;
			if(answer <0 ) {
				System.out.println("�����Ϊ�������������룺") ;
				return -1;
			}
		} catch(Exception e) {
			System.out.println("������������") ;
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
	 * function:��������10����Ŀ���ж��Դ�������ȷ���������� 
	 * question:Cannot make a static reference to the non-static method create() from the type main
	 * solve:����һ��Pair_programming��Ķ���pair,���µ��øö����е�create()������
	 * write��Ma Le ��Ding Tao
	 * 
	 */
	public static void main(String[] args) {
		int sys_answer, user_answer, count = 0, score = 0 ;// count��ȷ����Ŀ��
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
		System.out.println("��������" + count + "��Ŀ,��ĵ÷�Ϊ" + score);
	}
}
