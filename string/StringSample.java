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
			String str = "�ѱ�"; 
//"�ѱ�" �� str���� ���� �Ʒ� ����� �ٲ�.EUC-KR�� ���ڿ� 2Byte��, UTF-16�� ���ڿ� 3Byte��.
			
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
		
		/* compareTo �޼ҵ�� �����Ҷ� ����ϰԵǴµ�, true, false�� ����� �ƴ϶�,
		���Ϸ��� �Ű������� �Ѱ��� String ��ü�� ���ĺ������� �տ������� �����,
		�ڿ������� ������ �����Ѵ�. ���ĺ� ������ŭ �� ���ڰ��� Ŀ����. */
	}
	
////////////////////////////////////////////////////////
	
	public void addressCheck() {
		String addresses[] = new String[] {
				"����� ���α� �ŵ�����",
				"��⵵ ������ �д籸 ���ڵ� ���� ����",
				"����� ���α� ������",
		};
		int startCount=0, endCount=0;
		int containCount=0;
		String startText="�����";
		String endText="��";
		String containText="����";
		
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
		//�Ű������� 4���� �޼ҵ�
		System.out.println(text.regionMatches(5, compare1, 0, 2));
		//�Ű������� 4���� �޼ҵ�
		System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
		//�Ű������� 5���� �޼ҵ�
		
		/*  (regionMatches �޼ҵ� �Ű����� ����)
		 * 
		 * ignoreCase : true�� ��� ��ҹ��� ������ ���� �ʰ�, ���� ��
		 * toffset : �� ��� ���ڿ��� Ȯ�� ���� ��ġ�� ����
		 * other : �����ϴ����� Ȯ���� ���ڿ��� �ǹ�
		 * ooffset : other ��ü�� Ȯ�� ���� ��ġ�� ����
		 * len : ���� char�� ������ ����
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
	/* ���ڿ��� �Ϻ� ���� �߶󳻴� �޼ҵ� : substring */
	public void substringCheck1() {
		String text="Java technology";
		String technology=text.substring(5);
		System.out.println(technology);
		String tech=text.substring(5,  9);
		System.out.println(tech);
	}
	
////////////////////////////////////////////////////////
	/* ���ڿ��� �������� String�迭�� ������ split �޼ҵ� */
	public void splitCheck() {
		String text = "Java technology is both a programming language and a platform.";
		String[] splitArray=text.split(" ");
		for(String temp:splitArray) {
			System.out.println(temp);
		}
	}
////////////////////////////////////////////////////////
	/* ���ڿ��� ��ġ�� �޼ҵ�� ������ ���ִ� �޼ҵ� : trim */
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
	/* ������ ��ü�ϴ� �޼ҵ� : replace */
	
	public void replaceCheck() {
		String text="The String class represents character strings.";
		System.out.println(text.replace('s',  'z'));
		System.out.println(text);
		System.out.println(text.replace("tring",  "trike"));
		System.out.println(text.replaceAll(" ",  "|"));
		System.out.println(text.replaceFirst(" ",  "|"));
	}
	
////////////////////////////////////////////////////////
	/* Ư�� ���Ŀ� ���� ���� ġȯ�ϴ� �޼ҵ� : format */
	public void formatCheck() {
		String text="'�� �̸��� %s�Դϴ�. ���ݱ��� %d ���� å�� ���, "
				+"�Ϸ翡 %f %%�� �ð��� å�� ���µ� �Ҿ��ϰ� �ֽ��ϴ�.";
		String realText=String.format(text,  "�̻��", 4, 10.5);
		//String realText=String.format(text, "�̻��", 4);
		System.out.println(realText);
	}
	
	
	
	/* immutable�� String�� ������ �����ϴ� Ŭ�������� StringBuffer�� StringBuilder �� �ִ�.
	 * StringBuffer : Thread safe��. 
	 * StringBuilder : Thread safe���� ����.
	 * �ӵ��� StringBuilder�� �� ����.
	 * 
	 * (String, StringBbuilder, StringBuffer Ŭ������ ������)
	 * ��� ���ڿ��� �ٷ��., CharSequence�������̽��� �����ߴ�.
	 * 
	 *  �Ϲ������� �ϳ��� �޼ҵ� ������ ���ڿ��� �����Ͽ� ���� ��쿡�� 
	 *  StringBuilder�� ����ص� ���� ��� ����.
	 *  
	 *  �׷���, � Ŭ������ ���ڿ��� �����Ͽ� ���ϱ����� ���ڿ��� ó���ϱ� ����
	 *  �ν��Ͻ� ������ ����Ǿ���, ���� �����忡�� �� ������ ���ÿ� �����ϴ� ����
	 *  �ִ� ��쿡�� �ݵ�� StringBuffer�� ����ؾ߸� �Ѵ�.
	 */
}