package io.object;

import java.io.Serializable;

public class SerialDTO implements Serializable{
	static final long serialVersionUID = 1L;
	
	private String bookName;
	
	transient private int bookOrder;	
	/* transient ���� ����Ͽ� �����Ѻ����� Serializable�� ��󿡼� ���ܵ�.
	 * ��, �ش簴ü�� �ƿ� ���õǾ� ����. -> 
	 * ���Ȼ� �߿��� ������, �� �������ʿ䰡 ���� �����϶� transient ���
	 */
	private boolean bestSeller;
	private long soldPerDay;
	private String bookTypes = "IT"; //�߰��ϸ�, ������ �� serialVersionUID�� �ٽ� �����ǹǷ� �����߻�
	
	public SerialDTO(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
		super();
		this.bookName = bookName;
		this.bookOrder = bookOrder;
		this.bestSeller = bestSeller;
		this.soldPerDay = soldPerDay;
	}
	
	@Override
	public String toString() {
		return "SerialDTO [bookName=" + bookName + ", bookOrder=" + bookOrder + ", bestSeller=" + bestSeller + ",soldPerDay=" + soldPerDay + ", bookTypes=" + bookTypes +"]";
	}
}