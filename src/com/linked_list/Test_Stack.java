package com.linked_list;

import java.util.*;

public class Test_Stack {
	public static void main(String[] args) {
		int k,j,l;
		Scanner in = new Scanner(System.in);
		Stack_List s = new Stack_List();
		while(true){
			System.out.println("1——入栈 2——出栈 3——查询规模 4——获取栈顶元素 5——是否栈空 0——结束");
			k = in.nextInt();
			if(k==0) break;
			switch(k){
				case 1:
					while(true){
						System.out.println("1——入栈 0——结束");
						j = in.nextInt();
						if(j==0) break;
						s.push(j);
						System.out.print("当前栈：");
						s.Traversal(s.top);
						System.out.println(" ");
					}
					break;
				case 2:
					while(true){
						System.out.println("1——出栈 0——结束");
						j = in.nextInt();
						if(j==0) break;
						l=(int)s.pop();
						System.out.println(l+" 出栈");
						System.out.print("当前栈：");
						s.Traversal(s.top);
						System.out.println(" ");
					}
					break;
				case 3:
					System.out.println("当前栈规模："+s.getSize());
					break;
				case 4:
					System.out.println("栈顶元素："+s.top());
					break;
				case 5:
					if(s.isEmpty()) System.out.println("栈空");
					else System.out.println("栈非空");
					break;
			}
		}
		in.close();
	}

}
