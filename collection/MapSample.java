/*
 * Map은 키(key)와 값(value)로 이루어져 있다. 
 * Map은
 * 1. 모든 데이터는 키와 값이 존재한다.
 * 2. 키가 없이 값만 저장될 수는 없다.
 * 3. 값이 없이 키만 저장할 수도 없다.
 * 4. 키는 해당 Map에서 고유해야만 한다.
 * 5. 값은 Map에서 중복되어도 전혀 상관 없다. 
 * 왜냐하면, 여러 이유로 한대 이상의 핸드폰을 개통하여 사용하는 사람은 
 * 존재할 가능성이 매우 많기 때문이다.
 * 
 * Map인터페이스를 구현한 클래스들 : HashMap, TreeMap, LinkedHashMap
 * 
 * (Map과 Hashtable 차이)
 * 1. Map은 컬렉션 뷰를사용하지만, HashTable은 Enumeration 객체를 통해서 데이터를 처리
 * 2. Map은 키,값, 키-값 쌍으로 데이터를 순환하여 처리할 수 있지만,
 * Hashtable은 이중에서 키-값 쌍으로 데이터를 순환하여 처리할 수 없다.
 * 3. Map은 이터레이션을 처리하는 도중에 데이터를 삭제하는 안전한 방법을 제공하나,
 * Hashtable은 그러한 기능을 제공하지 않는다.
 * 
 * 
 * 키나 값에 null 저장가능여부 -> HashMap : 가능, HashTable : 불가능
 * 여러 쓰레드에서 동시 접근 가능 여부 -> HashMap : 불가능, HashTable : 가능
 */


/*
 * (자바의 자료구조)
 * Collection을 구현한 것은 List, Set ,QUeue이며, Map은 별도의 인터페이스로 되어있음
 * List의 대표적인 클래스로는 ArrayList와 LinkedList가 있으며, 보통은 ArrayList를 사용.
 * 
 * List처럼 목록을 처리하기는 하지만, 데이터의 중복이 없고 순서가 필요없는 Set의 대표적인
 * 클래스는 HashSet, TreeSet, LinkedHashSet이 있다.
 * 
 * 데이터가 들어온 순서대로 처리하기 위해 사용되는 Queue의 대표적인 클래스는
 * LinkedList와 PriorityQueue등이 있으며, LinkedList는 List에도 속하고 Queue에도 속하는 특이한 클래스이다.
 * 
 * Map의 대표적인 클래스는 HashMap, TreeMap, LinkedHashMap이 있으며, 대부분 HashMap을 사용
 * 
 * Map의 "키" 목록은 keySet()메소드를 사용하면 Set타입의 데이터를 얻을 수 있고,
 * "값" 목록은 values()메소드를 통하여 collection 타입의 데이터를 얻을 수 있다.
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
		map.put("A",  "a");			//A는 키이고, a는 값이다.
		//map.put("A", "1");			//값이 있는 키에 추가하면, 가장 최근에 추가한것이 뽑힘
		//System.out.println(map.get("A"));
		//System.out.println(map.get("B"));
		
		map.put("C",  "c");
		map.put("D",  "d");
		
		Collection<String> values = map.values();
		for(String tempKey:values) {
			System.out.println(tempKey);
		}
		/* Set과 Collection의 차이.
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
		map.put("가", "e");
		map.put("1", "f");
		map.put("a", "g");
		
		Set<Entry<String, String>> entries = map.entrySet();
		for(Entry<String, String> tempEntry:entries) {
			System.out.println(tempEntry.getKey()+"=" +tempEntry.getValue());
		}
		//TreeMap은 키를 정렬하여 저장하고, 키의 목록을 가져와서 출력하면,
		//정렬된 순서대로 제공되는것을 볼 수 있다.
		//매우 많은 데이터는 HashMap이 유리하나, 100~1000정도는 TreeMap이 좋음.
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
			File propertiesFile = new File(fileName); //test.properties 파일을 생성하고, 씀.
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