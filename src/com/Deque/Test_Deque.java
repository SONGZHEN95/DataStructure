package com.Deque;

import java.util.*;

public class Test_Deque {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Deque_DLNode s = new Deque_DLNode();
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("选择功能:1——插入队首 2——删除队首 3——获得队首 4——插入队尾 5——删除队尾 6——获得队尾 7——是否空 8——队列规模 0——退出");
			a = in.nextInt();
			if(a==0) break;
			switch(a){
			case 1:
				while(true){
					System.out.println("1——插入队首 0——结束");
					b = in.nextInt();
					if(b==0) break;
					s.insertFirst(b);
					System.out.println("当前队列:");
					s.Traversal();
				}
				break;
			case 2:
				while(true){
					System.out.println("1——删除队首 0——结束");
					b = in.nextInt();
					if(b==0) break;
					c=(int)s.removeFirst();
					System.out.println(c+"  删除");
					System.out.println("当前队列:");
					s.Traversal();
				}
				break;
			case 3:
				System.out.println("当前队首:  "+s.first());
				break;
			case 4:
				while(true){
					System.out.println("1——插入队尾 0——结束");
					b = in.nextInt();
					if(b==0) break;
					s.insertLast(b);
					System.out.println("当前队列:");
					s.Traversal();
				}
				break;
			case 5:
				while(true){
					System.out.println("1——删除队尾 0——结束");
					b = in.nextInt();
					if(b==0) break;
					c=(int)s.removeLast();
					System.out.println(c+"  删除");
					System.out.println("当前队列:");
					s.Traversal();
				}
				break;
			case 6:
				System.out.println("当前队首:  "+s.last());
				break;
			case 7:
				if(s.isEmpty()) System.out.println("队列空");
				else System.out.println("队列非空");
				break;
			case 8:
				System.out.println("队列规模:"+s.getSize());
				break;
			}
		}
		in.close();
	}		
}
