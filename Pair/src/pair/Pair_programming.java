package pair;
import java.util.Random;
import java.util.Scanner;
	
public class Pair_programming {
	
		public int a;
		public int b;
		public int n;
		
		/*
		 *	作用：产生3个随机数，分别对应第一个值、第二个值、运算符
		 *	问题：random函数如何生成随机数
		 *	write：马乐；
		 *	guide：丁涛
		 *	*/
		public void random() {
			Random rand = new Random();
			a = (int)(Math.random()*100);
			b = (int)(Math.random()*100);
			n = rand.nextInt(3);	//0-3,0代表+，1代表-，2代表*，3代表/
		}
		
		/*
		 * 作用：创建一个四则运算
		 * 问题：函数调用，无法传递参数，random(int ,int ,int)为形参，无法传递三个值
		 * 解决：创建全局变量
		 * write：DingTao
		 * guide：MaLe
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
		 * function:机器创建10道题目，用户输入答案，判定对错，给出正确数及分数。
		 * question:Cannot make a static reference to the non-static method create() from the type main
		 * answer:创建一个Pair_programming类的对象pair,重新调用该对象中的create()函数。
		 *  write：MaLe
		 *  guide：DingTao
		 *  write：DingTao
		 *  guide：Male
		 * */
		public static void main(String[] args) {
			Scanner in=new Scanner(System.in);
			int answersys,answerpeo,count=0,score=0;//count正确的题目数
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
			System.out.println("你做对了"+count+"题目,你的得分为"+score);	
		}
}

