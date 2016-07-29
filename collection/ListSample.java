/* (자바에서의 자료구조)
 * 1. 순서가 있는 목록인 List형
 * 2. 순서가 중요하지 않은 목록인 Set형
 * 3. 먼저 들어온 것이 먼저 나가는 Queue형
 * 4. 키-값(key-value)으로 저장되는 Map형
 */

//List인터페이스를 주로 구현한 java.util패키지 : ArrayList, Vector, Stack, LinkedList

/*
 * List의 특징 : 배열처럼 순서가 있다.
 * ArrayList와 Vector클래스의 사용법은 거의 동일하고 기능도 비슷.
 * 이 두 클래스는 "크기 확장이 가능한 배열" 이라 보면 된다.
 * ArrayList : 이 객체는 여러명이 달려들어 값을 변경하려하면 문제가 발생할 수 있다.(Thread Safe하지 않다.)
 * Vector : 위 문제가 발생하지 않는다.(Thread Safe하다.)
 * 
 * Stack클래스는 Vector클래스를 확장하여 만들었는데, LIFO를 지원하기 위해 만들어짐
 */

package collection;

import java.util.ArrayList;
import java.util.Stack;

public class ListSample {
	public static void main(String[] args) {
		ListSample sample = new ListSample();
		//sample.checkArrayList1();
		//sample.checkArrayList2();
		//sample.checkArrayList3();
		//sample.checkArrayList4();
		sample.checkStack();
	}
	
	public void checkArrayList1() {
		ArrayList list1 = new ArrayList();
		list1.add(new Object());
		list1.add("ArrayListSample");
		list1.add(new Double(1));
		//System.out.println(list1);
	}
	
	public void checkArrayList2() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add(1, "A1");
		/*
		for(String tempData:list)
			System.out.println(tempData);
		*/
		/*
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("0 ");
		list2.addAll(list);
		for(String tempData:list2)
			System.out.println("List2 : "+tempData);
		*/
		ArrayList<String> list2 = list; //list2는 list의 주소까지도 사용함.
		list.add("Ooops");
		for(String tempData:list2)
			System.out.println("List2 : "+tempData);
	}
	
	public void checkArrayList3() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		/*
		int listSize = list.size();
		for(int loop=0; loop<listSize; loop++)
			System.out.println("list.get("+loop+")="+list.get(loop));
		String[] strList=list.toArray(new String[0]);
		*/
		String[] tempArray=new String[7]; //String[5]로 하면 맞음.
		String[] strList = list.toArray(tempArray);
		for(String temp:strList)
			System.out.println(temp);
	}
	
	public void checkArrayList4() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("A");
		
		//System.out.println("Removed "+list.remove(0));
		//System.out.println(list.remove("A"));
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("A");
		list.removeAll(temp);
		
		for(int loop=0; loop<list.size(); loop++)
			System.out.println("list.get("+loop+")="+list.get(loop));
	}
	
	
////////////////////////////////////////////////////////////
	
	public void checkStack() {
		Stack<Integer> intStack = new Stack<Integer>();
		for(int loop=0; loop<5; loop++) {
			intStack.push(loop);
			System.out.println(intStack.peek());
		}
		
		while(!intStack.empty()) {
			System.out.println(intStack.pop());
		}
	}
}
