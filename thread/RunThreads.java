package thread;

public class RunThreads {
	public static void main(String[] args) {
		RunThreads threads = new RunThreads();
		//threads.runBasic();
		//threads.runBasic2();
		//threads.checkThreadProperty();
		//threads.runDaemonThread();
		//threads.checkThreadState1();
		//threads.infinite();
		//threads.checkThreadState2();
		//threads.checkThreadState3();
		//threads.groupThread();
		//threads.runLocalUserThread();
		//threads.runVolatileSample();
	}
	
	public void runBasic() {
		RunnableSample runnable = new RunnableSample();
		ThreadSample thread = new ThreadSample();
		//new Thread(runnable).start();
		thread.start();
		System.out.println("RunThreads.runBasic() method is ended.");
	}
	
	public void runBasic2() {
		RunnableSample []runnable = new RunnableSample[5];
		ThreadSample []thread = new ThreadSample[5];
		for(int loop=0; loop<5; loop++) {
			runnable[loop] = new RunnableSample();
			thread[loop] = new ThreadSample();
			
			new Thread(runnable[loop]).start();
			thread[loop].start();
		}
		System.out.println("RunThreads.runBasic2() method is ended.");
	}
////////////////////////////////////////////////////////////////////
	
	public void checkThreadProperty() {
		ThreadSample thread1 = new ThreadSample();
		ThreadSample thread2 = new ThreadSample();
		ThreadSample daemonThread = new ThreadSample();
		
		System.out.println("thread1 id = "+thread1.getId());
		System.out.println("thread2 id = "+thread2.getId());
		
		//System.out.println("daemonThread id = "+daemonThread.getId());
		
		System.out.println("thread1 name = "+thread1.getName());
		System.out.println("thread2 name = "+thread2.getName());
		
		System.out.println("thread1 priority = "+thread1.getPriority());
		
		daemonThread.setDaemon(true);
		System.out.println("thread1 isDaemon="+thread1.isDaemon());
		System.out.println("daemonThread isDaemon="+daemonThread.isDaemon());
	}
	
////////////////////////////////////////////////////////////////////
	
	public void runDaemonThread() {
		DaemonThread thread = new DaemonThread();
		thread.setDaemon(true);
		thread.start();
	}
	
////////////////////////////////////////////////////////////////////
	/* SleepThread클래스에 대한 함수 */
	public void checkThreadState1() {
		SleepThread thread = new SleepThread(2000);
		try {
			System.out.println("thread state = "+thread.getState());
			thread.start();
			System.out.println("thread state(after start)="+thread.getState());
			
			Thread.sleep(1000);
			System.out.println("thread state(after 1sec)="+thread.getState());
			
			thread.join();
			thread.interrupt();
			System.out.println("thread state(after join)="+thread.getState());
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
////////////////////////////////////////////////////////////////////
	/* InfiniteThread 에 관한 함수 */
	public void infinite() {
		InfiniteThread thread = new InfiniteThread();
		thread.start();
		try {
			Thread.sleep(500);
			thread.interrupt();
			System.out.println("interrupt() called ");
			thread.join(500);
		} catch(InterruptedException ie) {
			ie.toString();
		}
		System.out.println("isAlive = "+thread.isAlive());
		System.out.println("isInterrupted = "+thread.isInterrupted());
	}
	
////////////////////////////////////////////////////////////////////
	/* StateThread 에 관한 함수 */
	public void checkThreadState2() {
		Object monitor = new Object();
		StateThread thread = new StateThread(monitor);
		try {
			System.out.println("thread state="+thread.getState());
			thread.start();
			System.out.println("thread state(after start)="+thread.getState());
			
			Thread.sleep(1000);
			System.out.println("thread state(after 0.1 sec)="+thread.getState());
			
			synchronized(monitor) {
				monitor.notify();
			} // waiting 상태의 쓰레드를, 풀어줌. 이때 interrupt()호출과는 다르게
			//InterruptedException 도 발생하지 않고, wait()이후의 문장도 정상적으로 수행
			Thread.sleep(100);
			System.out.println("thread state(after notify)="+thread.getState());
			
			thread.join();
			System.out.println("thread state(after join)="+thread.getState());
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
////////////////////////////////////////////////////////////////////
	
	public void checkThreadState3() {
		Object monitor = new Object();
		StateThread thread = new StateThread(monitor);
		StateThread thread2 = new StateThread(monitor);
		try {
			System.out.println("thread state="+thread.getState());
			thread.start();
			thread2.start();
			System.out.println("thread state(after start)="+thread.getState());
			
			Thread.sleep(1000);
			System.out.println("thread state(after 0.1 sec)="+thread.getState());
			
			synchronized(monitor) {
				//monitor.notify();		//thread1만 종료되고, thread2는 종료 되지않음.
				monitor.notifyAll();
			} 
			/* waiting 상태의 쓰레드를, 풀어줌. 이때 interrupt()호출과는 다르게
			InterruptedException 도 발생하지 않고, wait()이후의 문장도 정상적으로 수행*/
			
			Thread.sleep(100);
			System.out.println("thread state(after notify);="+thread.getState());
			
			thread.join();
			System.out.println("thread state(after join);="+thread.getState());
			thread2.join();
			System.out.println("thread2 state(after join);="+thread2.getState());
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
////////////////////////////////////////////////////////////////////
	
	public void groupThread() {
		try {
			SleepThread sleep1 = new SleepThread(5000);
			SleepThread sleep2 = new SleepThread(5000);
			
			ThreadGroup group = new ThreadGroup("Group1");
			Thread thread1 = new Thread(group, sleep1);
			Thread thread2 = new Thread(group, sleep2);
			
			thread1.start();
			thread2.start();
			Thread.sleep(1000);
			System.out.println("Group name="+group.getName());
			int activeCount = group.activeCount();
			System.out.println("Active count="+activeCount);
			group.list();
			
			Thread[] tempThreadList = new Thread[activeCount];
			int result = group.enumerate(tempThreadList);
			System.out.println("Enumerate result="+result);
			for(Thread thread:tempThreadList) {
				System.out.println(thread);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
////////////////////////////////////////////////////////////////////
	/* OtherLogic, LocalUserThread, ThreadLocalSample 과 연관 함수 */
	public void runLocalUserThread() {
		LocalUserThread threads[] = new LocalUserThread[3];
		for(LocalUserThread thread:threads) {
			thread = new LocalUserThread();
			thread.start();
		}
	}
	//결과적으로, LocalUserThread의 결과값과, OtherLogic 의 결과값은 같게나온다.!!
	
////////////////////////////////////////////////////////////////////
	/* VolatileSample 에서 사용되는 함수 */
	public void runVolatileSample() {
		VolatileSample sample = new VolatileSample();
		sample.start();
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Sleep ended !!!");
		sample.setDouble(-1);
		System.out.println("Set value is completed !!!");
	}
}