package generic;

import java.io.Serializable;

//���׸� ����
// <>���� ���� T�� �ǵ��� Ŭ���� �̸��� ����Ģ�� �����ϰ� �����ϴ°��� ����.
// ������� �̸��� '������ Ÿ���̸�' �̶� �����ϸ� �ȴ�.
public class CastingGenericDTO<T> implements Serializable {
	private T object;
	public void setObject(T obj) {
		this.object = obj;
	}
	public T getObject() {
		return object;
	}
}