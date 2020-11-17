package ch3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.next());
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random();
		for(int k = 0; k < n; k++) {
			int i=rand.nextInt(10000);
			queue.add(i);
		}
		while(true) {
			if(stack.empty()) {
				stack.push(queue.peek());
			}
			else {
				int a = queue.peek();
				int b = stack.pop();
				if (a > b) {
					queue.add(b);
				}
				else {
					stack.push(a);
					if (queue.isEmpty()) {
						break;
					}
				}
			}
		}
		for(int j = 0; j <= n; j++) {
			System.out.println(stack.pop());
			if (stack.empty()) {
				break;
			}
		}	
	}
	}
	


