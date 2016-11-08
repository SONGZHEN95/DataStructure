package com.stack;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		Stack_Array s = new Stack_Array();
		int k;
		while(true){
			System.out.println("输入数字选择功能:1——入栈 2——出栈 3——获取栈顶元素 4——显示当前栈大小 0——结束程序");
			int sign = in.nextInt();
			if(sign==0) break;
			switch (sign){
				case 1:
					System.out.println("输入入栈元素以‘0’作为结束");
					while(true){
						k=in.nextInt();
						if(k==0) break;
						s.push(k);
						s.getStack();
					}
					break;
				case 2:
					System.out.println("输入1表示出栈，输入0表示操作结束");
					while(true){
						k=in.nextInt();
						if(k==0) break;
						k=(int)s.pop();
						System.out.println(k+"出栈");
						s.getStack();
					}
					break;
				case 3:
					System.out.println("栈顶元素:"+s.top());
					break;
				case 4:
					System.out.println("当前栈大小:"+s.getSize());
					break;
			}
		}
		in.close();
	}
}
