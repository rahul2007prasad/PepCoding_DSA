package com.dsa.level1.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Character> st = new Stack<>();
	
		for(int i=0 ; i < str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			}else if(ch == ')'){
				boolean handleClosing = handleClosing(st, '(');
				if(handleClosing == false) {
					System.out.println(handleClosing);
					return;
				}
			}else if(ch == '}') {
				boolean handleClosing = handleClosing(st, '{');
				if(handleClosing == false) {
					System.out.println(handleClosing);
					return;
				}
			}else if(ch == ']') {
				boolean handleClosing = handleClosing(st, '[');
				if(handleClosing == false) {
					System.out.println(handleClosing);
					return;
				}
			}else {
				
			}
		}
		if(st.size() ==0) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		
		
	}
	
	public static boolean handleClosing(Stack<Character> st ,char corresoch) {
		if(st.size() == 0) {
			System.out.println("false");
			return false;
		}else if(st.peek() != corresoch) {
			System.out.println("false");
			return false;
		}else {
			st.pop();
			return true;
		}
	}
}
