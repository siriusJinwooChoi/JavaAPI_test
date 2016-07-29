package util;

import java.util.Arrays;

public class ArraysSample {
	public static void main(String[] args) {
		ArraysSample sample = new ArraysSample();
		//sample.checkSort();
		sample.checkFill();
	}
	
	public void checkSort() {
		int[] values = new int[]{1,5,3,2,4,7,6,10,8,9};
		Arrays.sort(values);
		String stringValue = Arrays.toString(values);
		System.out.println(stringValue);
	}
	
////////////////////////////////////////////////////////
	
	public void checkFill() {
		int[] emptyArray = new int[10];
		Arrays.fill(emptyArray, 1);			//배열 전부를 1로 채움.
		Arrays.fill(emptyArray, 0, 5, 9);	//배열의 index 0~4까지 9로 채움.
		String stringValues = Arrays.toString(emptyArray);
		System.out.println(stringValues);
	}
}