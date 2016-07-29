package generic;

import java.io.Serializable;

//일반적인 선언
public class CastingDTO implements Serializable {
	private Object object;
	
	public void setObject(Object object) {
		this.object=object;
	}
	
	public Object getObject() {
		return object;
	}
}
