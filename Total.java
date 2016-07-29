/* (자바 총 정리) */

/*
 * 1. 자바의 예약어들(51개)
 * 
 * 1) 타입과 관련된 예약어들(8개)
 * byte, short, int, long, float, double, char, boolean
 * 
 * 2) 클래스, 메소드, 변수선언, 객체생성과 관련된 예약어들 (26개)
 * packgage : 클래스의 패키지를 선언할 때 사용하며 코드 내에서 단 한번만 지정 가능
 * import : 다른 패키지에 있는 클래스 및 그 안에 선언된 요소들을 사용하려할 때 사용
 * interface : 인터페이스 선언
 * abstract : abstract클래스 선언
 * class : 클래스 선언
 * enum : enum 선언
 * implements : interface를 구현한다고 선언할 때 사용하며, 여러개의 인터페이스를 구현할 경우에는
 * 				콤마로 구분하여 나열하면 됨.
 * extends : 클래스나 abstract 클래스를 확장할 때 사용하며, 하나의 클래스만 확장가능함
 * private : 다른 클래스에서의 접근이 불가능하게 할 경우 사용
 * protected : 같은 패키지 내에 있거나 상속받은 경우에만 접근하게 할 경우 사용
 * public : 누구나 접근할 수 있도록 할때 사용
 * final : 변수에 사용할 경우 값을 변경하지 못하도록 선언하며, 클래스에 사용할 경우 확장을 못하도록 선언
 * synchronized : 동시 접근 제어자
 * void : 메소드에서 반환하는 값이 없음을 선언
 * static : 하나의 인스턴스만 허용하는 제어자
 * return : 메소드를 종료하고 값을 반환할 때 사용
 * assert : 검증을 위한 로직선언
 * native : 다른언어로 구현된 것을 선언
 * new : 새로운 객체생성을 선언
 * null : 참조되고 있는 객체가 없다는 것을 선언
 * strictfp : strict 소수 값 제어자
 * super : 상위 클래스 참조
 * this : 현재 객체에 대한 참조를 명시적으로 나타낼 때 사용
 * transient : Serializable 할 때 저장되거나 전송되지 않는 객체를 선언
 * volatile : 하나의 변수를 여러 쓰레드가 참조할 때 모두 동일한 값을 바라보도록 할 때 사용
 * instanceof : 객체의 타입을 확인할 때 사용
 * 
 * 3) 조건 및 반복문과 관련있는 예약어들(10개)
 * if, else, switch, case, default, for, do, while, continue, break
 * 
 * 4) 예외 처리와 관련된 예약어들(5개)
 * try : 예외가 발생가능한 코드의 범위 선언
 * catch : try로 묶은 범위에서 예외가 발생할 때 처리방법 선언
 * finally : try-catch 수행 후 반드시 실행해야 하는 작업 선언
 * throw : 예외를 발생시키거나 호출한 클래스로 넘길 때 사용
 * throws : 예외를 던질 수도 있다는 것을 선언할 때 사용
 * 
 * 
 * 
 * 
 * 2. 제네릭
 * : 자바의 제네릭은 형 변환 시에 발생할 수 있는 문제들을 사전에 없애기 위해 만듬
 * 
 * (제네릭 타입 이름 명명 기본 규칙)
 * E - 요소(Element)
 * K - 키
 * V - 값
 * N - 숫자
 * T - 타입
 * S,U,V - 두번째, 세번째, 네번째에 선언되는 타입
 * 
 * (제네릭의 wildcard 타입)
 * :메소드 선언 시 제네릭 타입의 제한을 해소하기 위해서 특정타입대신 <?>를 사용
 * 해당 타입을 정확히 모르기 때문에 Object로 받음
 * 
 * 
 * 3. 쓰레드
 * (쓰레드를 시작할 수 있는 인터페이스와 클래스)
 * 1) java.lang.Runnable 			2) java.lang.Thread
 * 
 * (간단 정리)
 * 1. Runnable 인터페이스나 Thread 클래스를 직/간접적으로 구현한 클래스만 쓰레드로 처리될 수 있다.
 * 2. 쓰레드 선언시에는 public void run() 메소드를 꼭 선언해야 한다.
 * 3. 쓰레드를 시작하려면 쓰레드 객체의 start() 메소드를 호출하면 선언되어있는 run()메소드가 실행됨
 * 4. 쓰레드는 run()메소드가 종료되면 끝난다
 * 5. 단, 쓰레드를 Daemon으로 선언한 경우에는 프로세스 내의 다른 쓰레드들이 종료되면 run()메소드가
 * 	  종료되지 않더라도 해당 쓰레드는 종료된다.
 * 6. 쓰레드를 실행한 메소드에서 쓰레드가 종료될때까지 대기하려면, join()메소드를 사용하면 된다.
 * 7. Object 클래스에 선언된 wait()메소드를 호출하면 쓰레드는 대기상태가 되며, 
 * 		notify()나 notifyAll()메소드를 호출하면 깨어나게 된다.
 * 8. 수행중인 쓰레드를 종료시키려면 interrupt()메소드를 호출하면 된다.
 * 		interrupt()메소드를 호출한다고 모든 쓰레드가 종료되는 것은 아니고, 
 * 		join(), sleep(), wait() 메소드가 호출된 상태에서는 중지된다.
 * 
 * (쓰레드의 상태 종합)
 * NEW : 쓰레드 객체는 생성되었지만, 아직 시작되지는 않은 상태
 * RUNNABLE : 쓰레드가 실행중인 상태
 * BLOCKED : 쓰레드가 실행 중지상태이며, 모니터 락이 풀리기를 기다리는 상태
 * WAITING : 쓰레드가 대기중인 상태
 * TIMED_WAITING : 특정 시간만큼 쓰레드가 대기중인 상태
 * TERMINATED : 쓰레드가 종료된 상태
 * 
 * (synchronized에 관하여)
 * : 이 예약어를 메소드 선언시 사용하면, 하나의 객체를 공유하는 아무리 많은 쓰레드가
 * 동시에 이 메소드에 접근한다고 하더라도 하나의 쓰레드만 해당 메소드를 수행할수있다.
 * 
 * (Object 클래스)
 * : 모든 클래스의 가장 최상위 부모클래스.
 * 
 * (Object 클래스의 주요 메소드)
 * 1. clone() : 객체의 복사본을 만들어 리턴
 * 2. equals() : 현재 객체와 매개변수로 넘겨받은 객체가 같은지확인한다.
 * 3. finalize() : 현재 객체가 더 이상 쓸모가 없어졌을 때 가비지 컬레겉에 의해 이 메소드가 호출됨
 * 4. getClass() : 현재객체의 Class 클래스의 객체를 리턴
 * 5. hashCode() : 객체에 대한 해시코드 값을 리턴
 * 6. String toString() : 객체를 문자열로 표현하는 값을 리턴
 * 7. wait(), notify(), notifyAll() : 쓰레드 처리 시 사용하는 메소드들이다.
 * 
 * 
 * 
 * 
 * 4. String클래스
 * : String 클래스는 자바에서 사용되는 클래스 중 가장 특이한 클래스이며 중요하다.
 * 
 * (String 클래스의 특징)
 * 1) new를 사용하여 객체를 생성할 수 있는 유일한 클래스이다.
 * 2) 더하기 연산이 가능하다
 * 3) 더하기 연산을 할 경우 String클래스는 기존 문자열은 버리고 새로운 객체를 생성한다
 * 
 * (String클래스의 주요 메소드)
 * getBytes(), length(), isEmpty(), 
 * equals() : 두 문자열의 값이 같은지 확인한다
 * startsWith(), endsWith() : 매개변수로 넘어온 문자열로 시작하는지, 끝나는지를 확인한다
 * contains() : 매개변수로 넘어온 문자열이 포함되어있는지 확인한다
 * indexOf(), lastIndexOf() : 매개변수로 넘어온 문자열이 있는 위치를 0부터 시작하는 값으로 리턴한다
 * subString(), subsequence() : 문자열의 특정범위 값을 잘라서 리턴한다
 * split() : 문자열을 매개변수로 넘어온 정규표현식에 따라서 String배열로 리턴한다
 * concat() : 기존 문자열 뒤에 매개변수로 넘어온 문자열을 합친다
 * trim() : 문자열의 맨 앞과 뒤에있는 공백을 제거한다
 * replace() : 문자열의 특정위치의 내용을 매개변수로 넘어온 값으로 변경한다
 * format() : 문자열을 정해진 포맷으로 변환한다
 * intern() : 절대로 써서는 안되는 메소드다.!
 * 
 * 
 * (StringBuffer 와 StringBuilder클래스)
 * : String의 단점을 보완하기 위해서 제공되는 클래스들이다.
 * StringBuffer는 쓰레드에 안전하고, StringBuilder는 쓰레드에 안전하지 못하다
 * append()메소드를 사용하여 문자열을 더할 수 있다.
 * 만약 문자열을 더하면 컴파일러에서 StringBuilder클래스로 변환한다.
 * 
 * 
 * 
 * 
 * 5. 자바 API에서 제공하는 자료구조와 Collection
 * : 자바는 자료구조를 제공한다.
 * 1) 순서가 있는 목록(List)형
 * 2) 순서가 중요하지 않은 셋(Set)형
 * 3) 먼저 들어온 것이 먼저 나가는 큐(Queue)형
 * 4) 키-값(key-value)으로 저장되는 맵(Map)형
 * 
 * (java.util.Collection)
 * 1) List, Set, Queue 타입 구현의 모태가 되는 인터페이스
 * 2) Iiterable 인터페이스가 확장되어있다.
 * 3) add(), addAll() : 데이터 담기용 메소드
 * 4) contains(), containsAll(), isEmpty(), equals(), size() : 데이터 확인용 메소드
 * 5) claer(), remove(), removeAll() : 데이터 삭제용 메소드
 * 
 * 
 * 
 * 6. Collection-List 인터페이스
 * :List 인터페이스는 목록을 저장할 때 사용한다. 크기가 변하는 배열이라 보면 된다.
 * 
 * (List 인터페이스)
 * 1) 각 데이터에 대한 위치가 있다
 * 2) 위치에 있는 데이터를 꺼내거나 지우고, 원하는 위치에 데이터를 저장하는 작업을 할 수 있다
 * 3) 특정 데이터의 중복을 허용한다
 * 4) 순서대로 들어오는 데이터를 담아둘 때 용이하다
 * 5) Collection 인터페이스를 확장하였다
 * 
 * 
 * 7. Collection-Set 인터페이스
 * :위의 List와 비슷하나, 데이터의 순서가 중요하지않다.
 * 
 * (Set 인터페이스)
 * 1) 데이터를 목록형태로 담아둔다
 * 2) 데이터의 위치는 정해져 있지 않으며, 중복된 데이터가 포함될 수 없다
 * 3) 중복되는 데이터를 없애고, 유일한 값만을 뽑아내려고 할 때 용이하다
 * 4) contains()메소드를 사용해 데이터가 포함되있는지를 확인할 때 용이하다
 * 5) Collection 인터페이스를 확장하였다
 * 
 * 
 * 8. Collection-Queue 인터페이스
 * :Queue는 데이터를 순차적으로 처리하기위한 인터페이스이다.
 * 
 * (Queue 인터페이스)
 * 1) FIFO구조로 되어있어, 먼저 들어온 데이터를 처리하기위해서 꺼내면, 그 뒤에있던 두번째 데이터가
 * 		맨앞에 존재하게 된다
 * 2) 데이터가 들어온 순서대로 빨리 처리할 때 용이하다
 * 3) Collection 인터페이스를 확장하였다
 * 4) offer() : 데이터를 저장할 때 사용
 * 5) poll() : 가장 앞에있는 데이터를 꺼내고, 지운다
 * 6) peek() : 가장 앞에있는 데이터를 꺼내기만 하고, 지우지는 않는다
 * 
 * 
 * 9. Collection-Map 인터페이스
 * : Map은 중복되지 않는 키(key)와 그 키와 연결된 값(value)이 쌍으로 묶여있는 자료구조이다.
 * 
 * (Map 인터페이스)
 * 1) key-value 쌍으로 데이터를 관리한다
 * 2) key는 중복되어서는 안되며, value는 key만 다르다면 중복되어도 상관없다
 * 3) Map은 키로 식별할 수 있는 데이터를 담아두고, 데이터의 위치와 상관없이
 * 		키만으로 쉽게 꺼낼 필요가 있을 때 용이하다
 * 4) put() : 키와 값으로 데이터를 저장할 때 사용한다
 * 5) get() : 키로 데이터를 꺼낼 때 사용한다
 * 6) Map 인터페이스는 부모 인터페이스가 존재하지 않는다
 * 
 * 
 * 
 * 10. java.util 패키지의 주요 클래스들
 * 
 * (주요 클래스)
 * Date,Calendar, Collections, Arrays, StringTokenizer, Properties, Random, Formatter
 * 
 * 1) Date, Calendar
 * : 날짜와 시간을 관리하기 위한 클래스
 * Date클래스는 현재 및 특정 날짜 및 시간을 관리하기 위한 클래스
 * Calendar 클래스는 날짜를 더하고 빼는등의 계산작업을 할 때 유용한 클래스
 * 
 * 2) Collections
 * : 컬렉션을 보다 쉽게 처리하기 위한 메소드들을 제공한다
 * 
 * 3) Arrays
 * : 배열을 쉽게 처리하기 위한 클래스
 * 
 * 4) StringTokenizer
 * : 문자열을 특정 패턴에 따라서 잘라 사용할 일이 있을 때 사용한다
 * 
 * 5) Properties
 * : System 클래스에서 제공하는 속성을 관리하기 위한 클래스
 * 
 * 6) Random
 * : 임의의 수를 만들기 위한 클래스
 * 
 * 
 * 
 * 11. IO관련 클래스들
 * :파일이나 네트워크로 데이터를 읽고 쓰는 것을 통틀어 IO 라고한다.
 * 
 * (IO의 기본은 Stream)
 * 1) 자바 프로그램에서 데이터를 읽을 때에는 InputStream을 사용한다.
 * 2) 자바 프로그램에서 밖으로 데이터를 쓸 때에는 OutputStream 을 사용한다.
 * 3) char 기반의 데이터를 읽을 때에는 Reader, 쓸때에는 Writer를 사용한다.
 * 
 * 
 * (InputStream과 Reader)
 * -주요 메소드-						-InputStream의 주요 자식 클래스-
 * read(), close()					FileInputStream, ObjectInputStream, FilterInputStream
 * 
 * (OutputStream과 Writer)
 * -주요 메소드-						-OutputStream의 주요 자식 클래스-
 * write(), flush(), close()		InputStream의 주요자식클래스 이름에 OutputStream만 붙여주면됨
 * 
 * 
 * (File 클래스)
 * 
 * (Serializable)
 * 1) 객체를 다른 서버로 전송하거나, 파일에 쓰고, 읽기위해서 사용하는 인터페이스
 * 2) implements만 하면 되며, 별도로 구현해야 하는 클래스는 없다
 * 3) static final long serialVersionUID : 객체에 대한 serial 버전 값을 지정
 * 
 * (transient)
 * 1) Serializable 로 선언한 객체내에 전송하거나 저장하지 않는 변수를 선언할 때 사용
 * 2) 변수 선언 시 transient 라고 지정만 해주면 된다
 * 
 * (NIO)
 * 1) 보다 빠른 IO를 위해서 추가된 패키지
 * 2) Channel 기반으로 데이터와 연결하며 Stream대신 Buffer를 사용하여 데이터를 읽고 쓴다
 * 
 * (Buffer 클래스)
 * : 데이터 읽기와 쓰기, get():데이터읽기, put():데이터쓰기, 상태 및 속성 확인을 위한 주요메소드
 */