package string;

public class StringSample {
	public static void main(String[] args) {
		StringSample sample = new StringSample();
		//sample.constructors();
		//System.out.println(sample.nullCheck(null));
		//sample.compareCheck();
		//sample.equalCheck();
		//sample.compareToCheck();
		//sample.addressCheck();
		//sample.matchCheck();
		//sample.indexOfCheck();
		//sample.lastIndexOfCheck();
		//sample.substringCheck1();
		//sample.splitCheck();
		//sample.trimCheck();
		//sample.replaceCheck();
		sample.formatCheck();
	}
	
	public void constructors() {
		try {
			String str = "한글"; 
//"한글" 의 str값에 따라서 아래 출력이 바뀜.EUC-KR은 한자에 2Byte씩, UTF-16은 한자에 3Byte씩.
			
			byte[] array1 = str.getBytes();
			printByteArray(array1);
			String str1 = new String(array1);
			System.out.println(str1);
			
			byte[] array2 = str.getBytes();
			printByteArray(array2);
			String str2 = new String(array2, "EUC-KR"); //UTF-8 <-> EUC-KR
			System.out.println(str2);
			
			byte[] array3 = str.getBytes("UTF-16");
			printByteArray(array3);
			String str3 = new String(array3, "UTF-16"); //UTF-8 <-> EUC-KR
			System.out.println(str3);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printByteArray(byte[] array) {
		for(byte data:array) {
			System.out.print(data + " ");
		}
		System.out.println();
	}
	
////////////////////////////////////////////////////////
	
	public boolean nullCheck(String text) {
		//int textLength = text.length();
		//System.out.println(textLength);
		if(text == null) return true;
		else return false;
	}
	
////////////////////////////////////////////////////////
	
	public void compareCheck() {
		String text = "You must know String class.";
		System.out.println("text.length()="+text.length());
		System.out.println("text.isEmpty()="+text.isEmpty());
	}
////////////////////////////////////////////////////////
	
	public void equalCheck() {
		String text = "Check value";
		//String text2 = "Check value";
		String text2 = new String("Check value");
		if(text==text2)
			System.out.println("text==text2 result is same.");
		else
			System.out.println("text==text2 result is different.");
		
		if(text.equals("Check value"))
			System.out.println("text.equals(text2) result is same.");
		
		String text3 = "check value";
		if(text.equalsIgnoreCase(text3))
			System.out.println("text.equalsIgnoreCase(text3) result is same.");
	}
	
////////////////////////////////////////////////////////
	
	public void compareToCheck() {
		String text="a";
		String text2="b";
		String text3="c";
		
		System.out.println(text2.compareTo(text));
		System.out.println(text2.compareTo(text3));
		System.out.println(text.compareTo(text3));
		
		/* compareTo 메소드는 정렬할때 사용하게되는데, true, false의 결과가 아니라,
		비교하려는 매개변수로 넘겨준 String 객체가 알파벳순으로 앞에있으면 양수를,
		뒤에있으면 음수를 리턴한다. 알파벳 순서만큼 그 숫자값은 커진다. */
	}
	
////////////////////////////////////////////////////////
	
	public void addressCheck() {
		String addresses[] = new String[] {
				"서울시 구로구 신도림동",
				"경기도 성남시 분당구 정자동 개발 공장",
				"서울시 구로구 개봉동",
		};
		int startCount=0, endCount=0;
		int containCount=0;
		String startText="서울시";
		String endText="동";
		String containText="구로";
		
		for(String address:addresses) {
			if(address.startsWith(startText)) {
				startCount++;
			}
			if(address.endsWith(endText)) {
				endCount++;
			}
			if(address.contains(containText)) {
				containCount++;
			}
		}
		System.out.println("Starts with "+startText+ " count is "+startCount);
		System.out.println("Ends with "+endText+ " count is "+endCount);
		System.out.println("Contains with "+containText+ " count is "+containCount);
	}
	
////////////////////////////////////////////////////////
	
	public void matchCheck() {
		String text = "This is a text";
		String compare1 = "is";
		String compare2 = "this";
		System.out.println(text.regionMatches(2, compare1, 0, 1));
		//매개변수가 4개인 메소드
		System.out.println(text.regionMatches(5, compare1, 0, 2));
		//매개변수가 4개인 메소드
		System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
		//매개변수가 5개인 메소드
		
		/*  (regionMatches 메소드 매개변수 설명)
		 * 
		 * ignoreCase : true일 경우 대소문자 구분을 하지 않고, 값을 비교
		 * toffset : 비교 대상 문자열의 확인 시작 위치를 지정
		 * other : 존재하는지를 확인할 문자열을 의미
		 * ooffset : other 객체의 확인 시작 위치를 지정
		 * len : 비교할 char의 개수를 지정
		 */
	}
	
////////////////////////////////////////////////////////
	
	public void indexOfCheck() {
		String text="Java technology is both a programming language and a platform.";
		System.out.println(text.indexOf('a'));
		System.out.println(text.indexOf("a "));
		System.out.println(text.indexOf('a', 20));
		System.out.println(text.indexOf("a ", 20));
		System.out.println(text.indexOf('z'));
	}
	
////////////////////////////////////////////////////////
	public void lastIndexOfCheck() {
		String text="Java technology is both a programming language and a platform.";
		System.out.println(text.lastIndexOf('a'));
		System.out.println(text.lastIndexOf("a "));
		System.out.println(text.lastIndexOf('a', 20));
		System.out.println(text.lastIndexOf("a ", 20));
		System.out.println(text.lastIndexOf('z'));
	}
	
////////////////////////////////////////////////////////
	/* 문자열의 일부 값을 잘라내는 메소드 : substring */
	public void substringCheck1() {
		String text="Java technology";
		String technology=text.substring(5);
		System.out.println(technology);
		String tech=text.substring(5,  9);
		System.out.println(tech);
	}
	
////////////////////////////////////////////////////////
	/* 문자열을 여러개의 String배열로 나누는 split 메소드 */
	public void splitCheck() {
		String text = "Java technology is both a programming language and a platform.";
		String[] splitArray=text.split(" ");
		for(String temp:splitArray) {
			System.out.println(temp);
		}
	}
////////////////////////////////////////////////////////
	/* 문자열을 합치는 메소드와 공백을 없애는 메소드 : trim */
	public void trimCheck() {
		String strings[] = new String[] {
				" a", " b ", "    c", "d    ", "e   f", "     "
		};
		for(String string:strings) {
			System.out.println("["+string+"] ");
			System.out.println("Trim["+string.trim()+"] ");
		}
	}
	
////////////////////////////////////////////////////////
	/* 내용을 교체하는 메소드 : replace */
	
	public void replaceCheck() {
		String text="The String class represents character strings.";
		System.out.println(text.replace('s',  'z'));
		System.out.println(text);
		System.out.println(text.replace("tring",  "trike"));
		System.out.println(text.replaceAll(" ",  "|"));
		System.out.println(text.replaceFirst(" ",  "|"));
	}
	
////////////////////////////////////////////////////////
	/* 특정 형식에 맞춰 값을 치환하는 메소드 : format */
	public void formatCheck() {
		String text="'제 이름은 %s입니다. 지금까지 %d 권의 책을 썼고, "
				+"하루에 %f %%의 시간을 책을 쓰는데 할애하고 있습니다.";
		String realText=String.format(text,  "이상민", 4, 10.5);
		//String realText=String.format(text, "이상민", 4);
		System.out.println(realText);
	}
	
	
	
	/* immutable한 String의 단점을 보완하는 클래스에는 StringBuffer와 StringBuilder 가 있다.
	 * StringBuffer : Thread safe함. 
	 * StringBuilder : Thread safe하지 않음.
	 * 속도는 StringBuilder가 더 빠름.
	 * 
	 * (String, StringBbuilder, StringBuffer 클래스의 공통점)
	 * 모두 문자열을 다룬다., CharSequence인터페이스를 구현했다.
	 * 
	 *  일반적으로 하나의 메소드 내에서 문자열을 생성하여 더할 경우에는 
	 *  StringBuilder를 사용해도 전혀 상관 없다.
	 *  
	 *  그러나, 어떤 클래스에 문자열을 생성하여 더하기위한 문자열을 처리하기 위한
	 *  인스턴스 변수가 선언되었고, 여러 쓰레드에서 이 변수를 동시에 접근하는 일이
	 *  있는 경우에는 반드시 StringBuffer를 사용해야만 한다.
	 */
}