package exam_api_arrays;

import java.util.Arrays;

public class ArrayCopyExample {
	public static void main(String[] args) {
		char[] arr1 = {'J','A','V','A'};
		
		//방법 1
		char[] arr2 = Arrays.copyOf(arr1,  arr1.length);
							//copyOf(원본 배열, 복사할 길이수)
		System.out.println(Arrays.toString(arr2));
		
		//방법2
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 2);
							//copyOfRange(원본 배열, 원본 배열에서 복사할 시작 인덱스, 끝 인덱스(인덱스 바로 전까지의 출력))
		System.out.println(Arrays.toString(arr3));
		
		//방법3
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
			//arraycopy(원본 배열명, 시작 인덱스, 복사 배열명, 시작 인덱스, 복사할 길이수)
		for (int i = 0; i < arr4.length; i++) {
			System.out.println("arr4["+i+"]="+arr4[i]);
		}		
	}
}
