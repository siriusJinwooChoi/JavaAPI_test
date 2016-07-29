/*
 * java.util��Ű���� Collection�̶�� �������̽��� �ִµ�, List, Set, Queue�� �� �������̽���
 * ������ ���̴�.
 * ������ List, Set, Queue, Map�̶�� �װ��� �ڷᱸ���� ����Ѵ�.
 * Set�� �ߺ��Ǵ� �����͸� ������� �ʴ´�. ��, �ߺ��Ǵ� �����ʹ� �ϳ��� �̴´�.
 */


package collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetSample {
	public static void main(String[] args) {
		SetSample sample = new SetSample();
		String[] cars = new String[] {
				"Tico", "Sonata", "BMW", "Benz",
				"Lexus", "Zeep", "Grandeure",
				"Morning", "Mini Cooper", "i30",
				"BMW", "Lexus", "Carnibal", "SMS",
				"SM7", "SM3", "Tico"
		};
		System.out.println(sample.getCarKinds(cars));
	}
	
	public int getCarKinds(String[] cars) {
		if(cars == null) return 0;
		if(cars.length == 1) return 1;
		HashSet<String> carSet = new HashSet<String>();
		for(String car:cars) {
			carSet.add(car);
		}
		//printCarSet(carSet);
		printCarSet2(carSet);
		return carSet.size();
	}
	
	public void printCarSet(HashSet<String> carSet) {
		for(String temp : carSet) {
			System.out.print(temp + " ");
		}
		System.out.println();
	}
	
	public void printCarSet2(HashSet<String> carSet) {
		Iterator<String> iter = carSet.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println();
	}
}
