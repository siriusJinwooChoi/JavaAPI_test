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
		Arrays.fill(emptyArray, 1);			//�迭 ���θ� 1�� ä��.
		Arrays.fill(emptyArray, 0, 5, 9);	//�迭�� index 0~4���� 9�� ä��.
		String stringValues = Arrays.toString(emptyArray);
		System.out.println(stringValues);
	}
}