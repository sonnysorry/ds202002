import java.util.Scanner;

public class Main {
	// 분할 정복을 위한 함수
	// 배열 v에서 범위(a, b) 구간에서 최대크기의 직사각형 넓이 반환 
	static int histo(int[] v, int a, int b) {
		// 우선 a, b가 동일할 시 출력되는 값을 입력합니다.
		// a b는 범위이므로 3,3처럼 동일할 시, 배열 중 한 사각형만 나옵니다.
		long res;
		if(a == b) {
			res = v[a];
			return (int) res;
		}
		else {
			// 분할 정복을 위해 중간 값을 구합니다.
			int c = (a+b)/2;
			// 왼쪽과 오른쪽으로 나뉜 값을 설정합니다.
			int left = histo(v, a, c);
			int right = histo(v, c+1, b);
			// 왼쪽과 오른쪽 중 넓이가 더 큰 쪽을 선택합니다.
			res = Math.max(left, right);
			// 중앙에 있는 왼쪽과 오른쪽의 초기 값에서 한칸씩 이동합니다.
			int leftIndex = c - 1, rightIndex = c + 2;
			// 높이의 최소 값을 구하기 위해 minv 변수를 설정합니다.  
			// 처음 시작 중앙점에서 낮은 값으로 최소 높이 초기화 
			int minv = Math.min(v[(int) c], v[(int) (c + 1)]);
			// 전체의 길이를 구하기 위한 변수를 생성합니다.
			// 처음 시작의 값은 왼쪽 오른쪽 각각 하나이므로 2로 설정합니다.
			int histonum = 2;
			// 구간 내 넓이의 최대 넓이를 구하기 위해
			// 넓이 값인 res와 구간 내 최소 높이 * 길이를 곱합니다.
			res = Math.max(res,  minv * histonum);
			
			// 왼쪽 인덱스는 a보다 작아지고 , 오른쪽의 인덱스는 b보다 커질 때 까지  
			while (rightIndex < b && leftIndex > a) {
				// 오른쪽 높이 값이 왼쪽보다 작을시, 
				if(v[(int) rightIndex] < v[(int) leftIndex]) {
					// 이 시점 최소 높이 값과 왼쪽 인덱스를 우선 비교합니다 
					minv = Math.min(v[(int) rightIndex], minv);
					// 왼쪽 인덱스를 하나 왼쪽으로 보냅니다.
					leftIndex--;
				}
				else {
					// 왼쪽이 더 작을 시,
					// 위와 동일하게 오른쪽에 적용합니다.
					minv = Math.min(v[(int) leftIndex], minv);
					rightIndex++;
				}
				// 왼쪽 오른 쪽 중 하나의 인덱스가 늘어났으므로 길이를 하나 늘립니다.
				histonum++;
				// 최대 넓이값과 비교  확인합니다.
				res = Math.max(res,  minv*histonum);
			}
			// 오른쪽 왼쪽 중 한개가 끝났을 때, 아래 코드로 마저 계산합니다.
			while (leftIndex >= a) {
				minv = Math.min(v[(int) leftIndex], minv);
				leftIndex--;
				histonum++;
				res = Math.max(res, minv * histonum);
			}
			while (rightIndex <= b) {
				minv = Math.min(v[(int) rightIndex], minv);
				rightIndex++;
				histonum++;
				res = Math.max(res, minv * histonum);
			}
			return (int) res;
			
		}
		
	}

	// 히스토그램에서 최대의 직사형 넓이를 계산해서 출력하는 함수
	// v: 히스토그램의 샘플들의 도수들의 배열 (0이상의 자연수)
	// n: 샘플의 개수
	static int histo(int[] v, int n) {
	// v[0..n-1] 구간의 넓이를 구해서 그 값을 반환합니다.
		int a = 0;
		int b = n-1;
		int result = histo(v, a, b);
			return result;
		}

	public static void main(String[] args) {
				// 입력을 위해서 스캐너 오브젝트 생성
		System.out.println("샘플 갯수 n을 입력하세요");
		Scanner scan = new Scanner(System.in);
				// 샘플 갯수 N을 입력
		int n = scan.nextInt();
				// n개의 공간을 갖는 배열을 생성
		int[] v = new int[n];
				// n개의 배열 공간에 입력된 값을 넣는다.
		System.out.println(n + "개의 배열 값을 입력하세요.");
		for(int i = 0; i< n; i++) {
			v[i] = scan.nextInt();
				}
		// histo() 함수를 호출해서 그 결과 저장
		int r = histo(v, n);
		// 결과 출력
		System.out.println(r);

		
	}

}
