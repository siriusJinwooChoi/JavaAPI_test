/*
 * (Buffer 클래스)
 * 1. capacity() : 버퍼에 담을수 있는 크기 관련
 * 2. limit() : 버퍼에서 읽거나 쓸 수 없는 첫 위치 관련
 * 3. position() : 현재 버퍼의 위치 리턴
 * 
 * (관계)
 *  0 <= position <= limit <= 크기(capacity)
 *  
 *  flip() : limit값을 현재 position으로 지정 후, position을 0(가장 앞)으로 이동
 */

package nio;

import static java.io.File.separator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class NioSample {
	public static void main(String[] args) {
		NioSample sample = new NioSample();
		//sample.basicWriteAndRead();
		sample.checkBuffer();
	}
	
	public void basicWriteAndRead() {
		String fileName = "C:\\Users\\Jinwoo\\SIRIUS\\JAVA\\nio.txt";
		try {
			writeFile(fileName, "My first NIO sample.");
			readFile(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile(String fileName, String data) throws Exception {
		FileChannel channel = new FileOutputStream(fileName).getChannel();
		byte[] byteData = data.getBytes();
		ByteBuffer buffer = ByteBuffer.wrap(byteData);
		channel.write(buffer);
		channel.close();
	}
	
	public void readFile(String fileName) throws Exception {
		FileChannel channel = new FileInputStream(fileName).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		buffer.flip();
		while(buffer.hasRemaining()) {
			System.out.print((char)buffer.get());
		}
		channel.close();
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public void checkBuffer() {
		try {
			IntBuffer buffer = IntBuffer.allocate(1024);
			for(int loop=0; loop<100; loop++) {
				buffer.put(loop);
			}
			System.out.println("Buffer capacity="+buffer.capacity());
			System.out.println("Buffer limit   ="+buffer.limit());
			System.out.println("Buffer position   ="+buffer.position());
			buffer.flip();
			System.out.println("Buffer flipped !!!");
			System.out.println("Buffer limit   ="+buffer.limit());
			System.out.println("Buffer limit   ="+buffer.position());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
