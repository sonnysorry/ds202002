package hw2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int repeat = Integer.parseInt(scan.next());
		for (int j = 0; j < repeat; j++) {

			String input = scan.next();
			String res = "YES";
			Stack st = new Stack<>();
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {
					st.push(1);
				} else if (input.charAt(i) == ')') {
					if (st.isEmpty()) {
						res = "NO";
						break;
					} else {
						st.pop();
					}
				}
		}
		if(!st.isEmpty()) {
			res = "NO";
		}
		System.out.println(res);
		}
	}

}

