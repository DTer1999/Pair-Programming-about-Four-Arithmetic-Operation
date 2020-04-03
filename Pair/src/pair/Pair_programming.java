package pair;
import java.util.Random;
import java.util.Scanner;
	
public class Pair_programming {
	
		public int a;
		public int b;
		public int n;
		
		/*
		 *	���ã�����3����������ֱ��Ӧ��һ��ֵ���ڶ���ֵ�������
		 *	���⣺random����������������
		 *	write�����֣�
		 *	guide������
		 *	*/
		public void random() {
			Random rand = new Random();
			a = (int)(Math.random()*100);
			b = (int)(Math.random()*100);
			n = rand.nextInt(3);	//0-3,0����+��1����-��2����*��3����/
		}
		
		/*
		 * ���ã�����һ����������
		 * ���⣺�������ã��޷����ݲ�����random(int ,int ,int)Ϊ�βΣ��޷���������ֵ
		 * ���������ȫ�ֱ���
		 * write��DingTao
		 * guide��MaLe
		 * */
		public int create() {
			int answer;
			random();
			switch(n) {
				case 0:	
					while(a+b>100) {random();}
					answer=a+b;
					System.out.println(a+"+"+b+"="+"?");	//50+20=?
					break;
				case 1:
					while(a-b<0) {random();}
					answer=a-b;
					System.out.println(a+"-"+b+"="+"?");	//50-20=?
					break;
				case 2:
					while(a*b>100) {random();}
					answer=a*b;
					System.out.println(a+"*"+b+"="+"?");
					break;
				case 3:
					while(b==0 || a%b!=0) {random();}
					answer=a/b;
					System.out.println(a+"/"+b+"="+"?");	//40/20=?
					break;
				default:
					answer=-1;
			}
			return answer;
		}
		
		
		/*
		 * function:��������10����Ŀ���û�����𰸣��ж��Դ�������ȷ����������
		 * question:Cannot make a static reference to the non-static method create() from the type main
		 * answer:����һ��Pair_programming��Ķ���pair,���µ��øö����е�create()������
		 *  write��MaLe
		 *  guide��DingTao
		 *  write��DingTao
		 *  guide��Male
		 * */
		public static void main(String[] args) {
			Scanner in=new Scanner(System.in);
			int answersys,answerpeo,count=0,score=0;//count��ȷ����Ŀ��
			Pair_programming pair = new Pair_programming();
			for(int i=0;i<10;i++) {
				answersys=pair.create();
				answerpeo=in.nextInt();
				if(answerpeo==answersys) {
					System.out.println("true");
					count++;
					score+=10;
				}
				else {
					System.out.println("false");
				}
			}
			System.out.println("��������"+count+"��Ŀ,��ĵ÷�Ϊ"+score);	
		}
}

