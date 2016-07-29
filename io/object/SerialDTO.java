package io.object;

import java.io.Serializable;

public class SerialDTO implements Serializable{
	static final long serialVersionUID = 1L;
	
	private String bookName;
	
	transient private int bookOrder;	
	/* transient 예약어를 사용하여 선언한변수는 Serializable의 대상에서 제외됨.
	 * 즉, 해당객체는 아예 무시되어 버림. -> 
	 * 보안상 중요한 변수나, 꼭 저장할필요가 없는 변수일때 transient 사용
	 */
	private boolean bestSeller;
	private long soldPerDay;
	private String bookTypes = "IT"; //추가하면, 컴파일 시 serialVersionUID가 다시 생성되므로 문제발생
	
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
