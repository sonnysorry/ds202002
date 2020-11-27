package termproject;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main5 {
	public static int[][] convertArrayToDividedArray(int[] target, int k)
    {
        int n = target.length;
        int[][] dividedArr = new int[k][];
        int[] dividedIndex = new int[k+1];
        Random r = new Random();
        Arrays.fill(dividedIndex,-1);
        dividedIndex[0] = 0;
        dividedIndex[k] = n;
        // 구간 나누기
        for(int i = 1; i < k; i ++)
        {
            int index = r.nextInt(n-1)+1;
            while (isOverlapped(index,dividedIndex,k+1))
            {
                index = r.nextInt(n-1)+1;
            }
            dividedIndex[i] = index;
        }
        Arrays.sort(dividedIndex);
        // 나눈 구간대로 값 집어넣기
        for(int i = 0; i < k; i ++)
        {
            int cnt = 0;
            int interval = dividedIndex[i+1] - dividedIndex[i];
            dividedArr[i] = new int[interval];    
            for(int j = dividedIndex[i]; j < dividedIndex[i+1]; j ++)
            {
                dividedArr[i][cnt++] = target[j];
            }
        }
        return dividedArr;
    }
    public static boolean isOverlapped(int index, int[] target, int k)
    {
        for(int i = 0; i < k; i++)
        {
            if(target[i] == index)
            {
                return true;
            }
        }
        return false;
    }
    

    public static void main(String[] args){
    	long start = System.currentTimeMillis();
    	Scanner sc = new Scanner(System.in);
    	Random r = new Random();
		int n = sc.nextInt();
		int k = sc.nextInt();	
    	int target[] = new int[n];
		for(int i = 0; i < n; i++) {
			target[i] = r.nextInt(100); 
			System.out.println(target[i]);
		}
    	
        int[][] divided = convertArrayToDividedArray(target,k);
        for(int i = 0; i < k; i ++)
        {
            System.out.println((i+1) + "번째 구간");
            int min = 100;
        	int max = -1;
        	int cnt = 0;
            for(int j = 0; j < divided[i].length; j++)
            {
                System.out.print(divided[i][j]);
                
                if (divided[i][j] > max) {
                	max = divided[i][j];
                if (divided[i][j] < min) {
                	min = divided[i][j];
                }
                }
                cnt += divided[i][j];
            }
            System.out.println();
            System.out.println("최대 : " + max );
            System.out.println("최소 : " + min );
            System.out.println("합계 : " + cnt);
        }
        System.out.println("done");
        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

    }
   
	}


