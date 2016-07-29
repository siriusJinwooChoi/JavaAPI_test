/*
 * (Buffer Ŭ����)
 * 1. capacity() : ���ۿ� ������ �ִ� ũ�� ����
 * 2. limit() : ���ۿ��� �аų� �� �� ���� ù ��ġ ����
 * 3. position() : ���� ������ ��ġ ����
 * 
 * (����)
 *  0 <= position <= limit <= ũ��(capacity)
 *  
 *  flip() : limit���� ���� position���� ���� ��, position�� 0(���� ��)���� �̵�
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
