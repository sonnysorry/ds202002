package seg;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static long[] treeArr;
	static long[] rmin;
	static long[] rmax;
	static long[] rsum;
	static int[] v;
	
	static long init_sum(int[] v, int a, int b, int node) {
		if(a==b){
			return treeArr[node] = v[a];
		}
		int mid = (a+b)/2;
		
		return treeArr[node]=init_sum(v,a,mid,node*2) + init_sum(v,mid+1,b,node*2+1);
	}

	static long sum(int node, int a, int b, int left, int right){
		if(left > b || right < a){
			return 0;
		}
		if(left <= a && b <= right){
			return treeArr[node];
		}
		int mid=(a+b)/2;
		return sum(node*2,a,mid,left,right)+sum(node*2+1,mid+1,b,left,right);
	}
	
	static long init_min(int node, int a, int b){
		if(a == b){
			return treeArr[node]= v[a];
		}
		
		int mid = (a+b)/2;
		
		return treeArr[node]= Math.min(init_min(node*2, a, mid) , init_min(node*2+1, mid+1, b));
	}
	static long min_num(int node, int a, int b, int left, int right){
		if(a>right || b<left){
			return Integer.MAX_VALUE;
		}
		if(left<=a && b<=right){
			return treeArr[node];
		}
		int mid = (a+b)/2;
		
		return Math.min(min_num(node*2,a,mid,left,right), min_num(node*2+1,mid+1,b,left,right));
	}
	static long init_max(int node, int a, int b){
		if(a == b){
			return treeArr[node]= v[a];
		}
		
		int mid = (a+b)/2;
		
		return treeArr[node]= Math.max(init_max(node*2, a, mid) , init_max(node*2+1, mid+1, b));
	}
	static long max_num(int node, int a, int b, int left, int right){
		if(a>right || b<left){
			return Integer.MIN_VALUE;
		}
		if(left<=a && b<=right){
			return treeArr[node];
		}
		int mid = (a+b)/2;
		
		return Math.max(max_num(node*2,a,mid,left,right), max_num(node*2+1,mid+1,b,left,right));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(1000);
		int n = sc.nextInt();
		v = new int[n];
		for(int i = 0; i<n; i++) 
			{
			v[i] = rand.nextInt();
			}
		int k = sc.nextInt();
		int[] a = new int[k];
		int[] b = new int[k];
		int p = (int) Math.ceil(Math.log(n)/Math.log(2));
		int size = (int)Math.pow(2, p)*2;
		
		treeArr = new long[size];
		
		
		for(int i = 0; i < k; i++) {
			int x = rand.nextInt(n);
			int y = rand.nextInt(n);
			a[i] = x;
			a[i] = y;	
			init_min(1, 0, n-1);
			init_max(1, 0, n-1);
			init_sum(v, 0, n-1, 1);
		}
		long t = System.currentTimeMillis();
		for (int q = 0; q < a.length; q++) {
			long min = v[a[q] -1];
			long max = v[a[q] -1];
			long sum = v[a[q] -1];
			for(int r = 0; r < q; r++) {
				min = min_num(1, 0, n-1, (a[r]-1), (b[r]-1));
				max = max_num(1, 0, n-1, (a[r]-1), (b[r]-1));
				sum = sum(1, 0, n-1, (a[r]-1), (b[r]-1));
			}
		}
		System.out.println("elapsed : " + (System.currentTimeMillis()-t));
	}

}
