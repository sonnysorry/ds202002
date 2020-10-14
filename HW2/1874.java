import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        int idx = 0;
        for(int i = 0; i < N; i++){
            ans[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1; i <= N; i++){
            stack.add(i);
            sb.append("+\n");
            while(stack.peek() == ans[idx]){
                stack.pop();
                sb.append("-\n");
                idx++;
                if(stack.isEmpty())
                    break;
            }
        }
        if(stack.isEmpty())
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
