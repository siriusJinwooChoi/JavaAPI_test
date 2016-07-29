package thread.sync;

public class CommonCalculate {
	private int amount;
	public CommonCalculate() {
		amount=0;
	}
	
	//synchronized�� �����尡 1���� ������ ��.
	public synchronized void plus(int value) {
		amount+=value;
	}
	//Ȥ��, amount�� critical section���� �ϰ���������� �Ʒ��� ����!
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
