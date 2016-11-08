package com.queue;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Queue_Array s = new Queue_Array();
		Scanner in = new Scanner(System.in);
		int k,t,v;
		while(true){
			System.out.println("输入数字选择功能:1——入队 2——出队 3——获取队首元素 4——当前队列大小 0——退出程序");
			k=in.nextInt();
			if(k==0) break;
			switch(k){
				case 1:
					System.out.println("请输入待入队元素，以‘0’结束");
					while(true){
						t=in.nextInt();
						if(t==0) break;
						s.enqueue(t);
						System.out.print("当前队列元素: ");
						s.Traversal();
					}
					break;
				case 2:
					System.out.println("1——出队 0——结束");
					while(true){
						t=in.nextInt();
						if(t==0) break;
						v=(int)s.dequeue();
						System.out.print(v+"出队,");
						System.out.print("当前队列元素: ");
						s.Traversal();
					}
					break;
				case 3:
					System.out.println("队首元素："+s.front());
					break;
				case 4:
					System.out.println("当前队列大小:"+s.getSize());
			}
		}
		in.close();
	}
}
