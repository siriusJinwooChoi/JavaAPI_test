package generic;

import java.io.Serializable;

//제네릭 선언
// <>꺽쇠 안의 T는 되도록 클래스 이름의 명명규칙과 동일하게 지정하는것이 좋다.
// 꺾쇠안의 이름은 '가상의 타입이름' 이라 생각하면 된다.
public class CastingGenericDTO<T> implements Serializable {
	private T object;
	public void setObject(T obj) {
		this.object = obj;
	}
	public T getObject() {
		return object;
	}
}