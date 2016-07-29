package thread;

public class EndlessThread extends Thread {
	public static void main(String[] args) {
		EndlessThread thread = new EndlessThread();
		thread.endless();
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println(System.currentTimeMillis());
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void endless() {
		EndlessThread thread = new EndlessThread();
		thread.start();
	}
}