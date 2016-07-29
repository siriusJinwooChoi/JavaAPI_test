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
	// <?> 부분의 ? 는 wildcard타입이라 한다.
	//객체에 제네릭타입으로 값을 지정하는 것은 불가능 하다.
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

/*<? extends Car> 뜻은 제네릭타입으로 Car를 상속받은 모든 클래스를 사용할 수 있다는 의미
 * 즉, boundedWildcardMethod()의 매개변수에는 다른 타입을 제네릭타입으로 선언한 객체가
 * 넘어올 수 없다.
 * 반드시 Car클래스를 확장한 클래스가 넘어와야만 한다.!
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
