package com.linked_list;

import java.util.Scanner;

public class Test_Queue {
	public static void main(String[] args) {
		int k,j,l;
		Scanner in = new Scanner(System.in);
		Queue_List s = new Queue_List();
		while(true){
			System.out.println("1——入队 2——出队 3——查询规模 4——获取队首元素 5——是否队空 0——结束");
			k = in.nextInt();
			if(k==0) break;
			switch(k){
				case 1:
					while(true){
						System.out.println("1——入队 0——结束");
						j = in.nextInt();
						if(j==0) break;
						s.enqueue(j);
						System.out.print("当前栈：");
						s.Traversal();
						System.out.println(" ");
					}
					break;
				case 2:
					while(true){
						System.out.println("1——出队 0——结束");
						j = in.nextInt();
						if(j==0) break;
						l=(int)s.dequeue();
						System.out.println(l+" 出队");
						System.out.print("当前队列：");
						s.Traversal();
						System.out.println(" ");
					}
					break;
				case 3:
					System.out.println("当前栈规模："+s.getSize());
					break;
				case 4:
					System.out.println("栈顶元素："+s.front());
					break;
				case 5:
					if(s.isEmpty()) System.out.println("队列空");
					else System.out.println("队列非空");
					break;
			}
		}
		in.close();
	}

}
