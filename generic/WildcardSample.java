package generic;

public class WildcardSample {
	public static void main(String[] args) {
		WildcardSample sample = new WildcardSample();
		//sample.callWildcardMethod();
		//sample.callBoundedWildcardMethod();
		sample.callGenericMethod();
	}
	
	public void callWildcardMethod() {
		WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
		wildcard.setWildcard("A");
		wildcardMethod(wildcard);
	}
	
	/*
	public void wildcardMethod(WildcardGeneric<String> c) {
		String value = c.getWildcard();
		System.out.println(value);
	}
	*/	
	// <?> �κ��� ? �� wildcardŸ���̶� �Ѵ�.
	//��ü�� ���׸�Ÿ������ ���� �����ϴ� ���� �Ұ��� �ϴ�.
	public void wildcardMethod(WildcardGeneric<?> c) {
		Object value = c.getWildcard();
		System.out.println(value);
	}
	
	
	
	
////////////////////////////////////////////////////////	
	
	public void callBoundedWildcardMethod() {
		//WildcardGeneric<Car> wildcard = new WildcardGeneric<Car>();
		//wildcard.setWildcard(new Car("BMW"));
		WildcardGeneric<Bus> wildcard = new WildcardGeneric<Bus>();
		wildcard.setWildcard(new Bus("Bongo"));
		
		wildcardMethod(wildcard);
	}

/*<? extends Car> ���� ���׸�Ÿ������ Car�� ��ӹ��� ��� Ŭ������ ����� �� �ִٴ� �ǹ�
 * ��, boundedWildcardMethod()�� �Ű��������� �ٸ� Ÿ���� ���׸�Ÿ������ ������ ��ü��
 * �Ѿ�� �� ����.
 * �ݵ�� CarŬ������ Ȯ���� Ŭ������ �Ѿ�;߸� �Ѵ�.!
 */
	public void boundedWildcardMethod(WildcardGeneric <? extends Car> c) {
		Car value = c.getWildcard();
		System.out.println(value);
	}
	
	
	
	
////////////////////////////////////////////////////////

	public void callGenericMethod() {
		WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
		genericMethod(wildcard, "Data");
	}
	
	public <T> void genericMethod(WildcardGeneric<T> c, T addValue) {
		c.setWildcard(addValue);
		T value = c.getWildcard();
		System.out.println(value);
	}
}
