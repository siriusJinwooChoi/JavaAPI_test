/*
 * (Volatile 예약어)
 * 변수 선언시에만 사용된다.
 */

package thread;

public class VolatileSample extends Thread {
	private double instanceVariable = 0;
	//private volatile double instanceVariable = 0;
	
	void setDouble(double value) {
		this.instanceVariable = value;
	}
	
	/*
	public void run() {
		while(instanceVariable == 0);
		System.out.println(instanceVariable);
	}*/
	
	public void run() {
		try {
			while(instanceVariable == 0) {
				Thread.sleep(1);
			}
		} catch(Exception e) {
			
		}
		System.out.println(instanceVariable);
	}
}
