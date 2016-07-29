/* (�ڹٿ����� �ڷᱸ��)
 * 1. ������ �ִ� ����� List��
 * 2. ������ �߿����� ���� ����� Set��
 * 3. ���� ���� ���� ���� ������ Queue��
 * 4. Ű-��(key-value)���� ����Ǵ� Map��
 */

//List�������̽��� �ַ� ������ java.util��Ű�� : ArrayList, Vector, Stack, LinkedList

/*
 * List�� Ư¡ : �迭ó�� ������ �ִ�.
 * ArrayList�� VectorŬ������ ������ ���� �����ϰ� ��ɵ� ���.
 * �� �� Ŭ������ "ũ�� Ȯ���� ������ �迭" �̶� ���� �ȴ�.
 * ArrayList : �� ��ü�� �������� �޷���� ���� �����Ϸ��ϸ� ������ �߻��� �� �ִ�.(Thread Safe���� �ʴ�.)
 * Vector : �� ������ �߻����� �ʴ´�.(Thread Safe�ϴ�.)
 * 
 * StackŬ������ VectorŬ������ Ȯ���Ͽ� ������µ�, LIFO�� �����ϱ� ���� �������
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
		ArrayList<String> list2 = list; //list2�� list�� �ּұ����� �����.
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
		String[] tempArray=new String[7]; //String[5]�� �ϸ� ����.
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
