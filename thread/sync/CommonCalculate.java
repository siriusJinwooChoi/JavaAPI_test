package thread.sync;

public class CommonCalculate {
	private int amount;
	public CommonCalculate() {
		amount=0;
	}
	
	//synchronized는 쓰레드가 1개만 들어오게 함.
	public synchronized void plus(int value) {
		amount+=value;
	}
	//혹은, amount만 critical section으로 하고싶을때에는 아래와 같이!
	/*
	Object lock = new Object();
	public void plus(int value) {
		synchronized(lock) {
			amount+=value;
		}
	}
	*/
	
	
	public synchronized void minus(int value) {
		amount-=value;
	}
	
	public int getAmount() {
		return amount;
	}
}
