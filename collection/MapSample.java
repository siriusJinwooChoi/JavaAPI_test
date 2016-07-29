/*
 * Map�� Ű(key)�� ��(value)�� �̷���� �ִ�. 
 * Map��
 * 1. ��� �����ʹ� Ű�� ���� �����Ѵ�.
 * 2. Ű�� ���� ���� ����� ���� ����.
 * 3. ���� ���� Ű�� ������ ���� ����.
 * 4. Ű�� �ش� Map���� �����ؾ߸� �Ѵ�.
 * 5. ���� Map���� �ߺ��Ǿ ���� ��� ����. 
 * �ֳ��ϸ�, ���� ������ �Ѵ� �̻��� �ڵ����� �����Ͽ� ����ϴ� ����� 
 * ������ ���ɼ��� �ſ� ���� �����̴�.
 * 
 * Map�������̽��� ������ Ŭ������ : HashMap, TreeMap, LinkedHashMap
 * 
 * (Map�� Hashtable ����)
 * 1. Map�� �÷��� �並���������, HashTable�� Enumeration ��ü�� ���ؼ� �����͸� ó��
 * 2. Map�� Ű,��, Ű-�� ������ �����͸� ��ȯ�Ͽ� ó���� �� ������,
 * Hashtable�� ���߿��� Ű-�� ������ �����͸� ��ȯ�Ͽ� ó���� �� ����.
 * 3. Map�� ���ͷ��̼��� ó���ϴ� ���߿� �����͸� �����ϴ� ������ ����� �����ϳ�,
 * Hashtable�� �׷��� ����� �������� �ʴ´�.
 * 
 * 
 * Ű�� ���� null ���尡�ɿ��� -> HashMap : ����, HashTable : �Ұ���
 * ���� �����忡�� ���� ���� ���� ���� -> HashMap : �Ұ���, HashTable : ����
 */


/*
 * (�ڹ��� �ڷᱸ��)
 * Collection�� ������ ���� List, Set ,QUeue�̸�, Map�� ������ �������̽��� �Ǿ�����
 * List�� ��ǥ���� Ŭ�����δ� ArrayList�� LinkedList�� ������, ������ ArrayList�� ���.
 * 
 * Listó�� ����� ó���ϱ�� ������, �������� �ߺ��� ���� ������ �ʿ���� Set�� ��ǥ����
 * Ŭ������ HashSet, TreeSet, LinkedHashSet�� �ִ�.
 * 
 * �����Ͱ� ���� ������� ó���ϱ� ���� ���Ǵ� Queue�� ��ǥ���� Ŭ������
 * LinkedList�� PriorityQueue���� ������, LinkedList�� List���� ���ϰ� Queue���� ���ϴ� Ư���� Ŭ�����̴�.
 * 
 * Map�� ��ǥ���� Ŭ������ HashMap, TreeMap, LinkedHashMap�� ������, ��κ� HashMap�� ���
 * 
 * Map�� "Ű" ����� keySet()�޼ҵ带 ����ϸ� SetŸ���� �����͸� ���� �� �ְ�,
 * "��" ����� values()�޼ҵ带 ���Ͽ� collection Ÿ���� �����͸� ���� �� �ִ�.
 */



package collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class MapSample {
	public static void main(String[] args) {
		MapSample sample = new MapSample();
		//sample.checkHashMap();
		//sample.checkHashMapEntry();
		//sample.checkTreeMap();
		//sample.checkProperties();
		sample.saveAndLoadProperties();
	}
	
	public void checkHashMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("A",  "a");			//A�� Ű�̰�, a�� ���̴�.
		//map.put("A", "1");			//���� �ִ� Ű�� �߰��ϸ�, ���� �ֱٿ� �߰��Ѱ��� ����
		//System.out.println(map.get("A"));
		//System.out.println(map.get("B"));
		
		map.put("C",  "c");
		map.put("D",  "d");
		
		Collection<String> values = map.values();
		for(String tempKey:values) {
			System.out.println(tempKey);
		}
		/* Set�� Collection�� ����.
		Set<String> keySet = map.keySet();
		for(String tempKey:keySet) {
			System.out.println(tempKey+"="+map.get(tempKey));
		}*/
	}
	
	public void checkHashMapEntry() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("A", "a");
		map.put("B", "b");
		map.put("C", "c");
		map.put("D", "d");
		
		/*
		Set<Entry<String, String>> entries = map.entrySet();
		for(Entry<String, String> tempEntry:entries) {
			System.out.println(tempEntry.getKey()+"=" +tempEntry.getValue());
		}*/
		
		/*
		System.out.println(map.containsKey("A"));
		System.out.println(map.containsKey("Z"));
		
		System.out.println(map.containsValue("a"));
		System.out.println(map.containsValue("z"));
		*/
		map.remove("A");
		Set<Entry<String, String>> entries = map.entrySet();
		for(Entry<String, String> tempEntry:entries) {
			System.out.println(tempEntry.getKey()+"=" +tempEntry.getValue());
		}
	}
	
	public void checkTreeMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("A", "a");
		map.put("B", "b");
		map.put("C", "c");
		map.put("D", "d");
		map.put("��", "e");
		map.put("1", "f");
		map.put("a", "g");
		
		Set<Entry<String, String>> entries = map.entrySet();
		for(Entry<String, String> tempEntry:entries) {
			System.out.println(tempEntry.getKey()+"=" +tempEntry.getValue());
		}
		//TreeMap�� Ű�� �����Ͽ� �����ϰ�, Ű�� ����� �����ͼ� ����ϸ�,
		//���ĵ� ������� �����Ǵ°��� �� �� �ִ�.
		//�ſ� ���� �����ʹ� HashMap�� �����ϳ�, 100~1000������ TreeMap�� ����.
	}
	
	public void checkProperties() {
		Properties prop = System.getProperties();
		Set<Object> keySet = prop.keySet();
		for(Object tempObject:keySet) {
			System.out.println(tempObject+"="+prop.get(tempObject));
		}
	}
	
	public void saveAndLoadProperties() {
		try {
			//String fileName="test.properties";	
			String fileName="test.xml";
			File propertiesFile = new File(fileName); //test.properties ������ �����ϰ�, ��.
			FileOutputStream fos = new FileOutputStream(propertiesFile);
			Properties prop = new Properties();
			prop.setProperty("'Writer", "Sangmin, Lee");
			prop.setProperty("WriterHome",  "http://www.GodOfJava.com");
			//prop.store(fos,  "Basic Properties file.");
			prop.storeToXML(fos,  "Basic XML file.");
			fos.close();
			
			FileInputStream fis = new FileInputStream(propertiesFile);
			Properties propLoaded = new Properties();
			//propLoaded.load(fis);
			propLoaded.loadFromXML(fis);
			fis.close();
				System.out.println(propLoaded);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}