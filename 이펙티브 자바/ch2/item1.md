# 객체의 생성과 파괴
---
## 정적 팩터리 메소드 
```
클래스 내부에서 static 메소드를 제공하여 객체를 생성하는 방식, NEW 키워드 사용 X
이는 디자인 패턴의 팩터리 메소드와는 다른 정적 팩터리 메소드(static factory method)이다.
```
```
public class Product {
    private String name;

    private Product(String name) { // private 생성자
        this.name = name;
    }

    public static Product create(String name) { // 정적 팩터리 메소드
        return new Product(name);
    }
}

```

## 생성자 public 메소드
```
클래스 외부에서 NEW 키워드를 사용하여 직접 인스턴스를 생성하는 방식
```
```
public class Product {
    private String name;

    public Product(String name) { // public 생성자
        this.name = name;
    }
}

```

### 정적 팩터리 메소드의 장점 ( VS 생성자 메소드)
---
1. 이름을 가질수 있다. 가독성과 정확한 의미 전달이 가능하다.
```
- 생성자 버전
BigInteger(int,int,Random)
- 정적 팩터리 메소드
BigInteger.probablePrime()
-> 정적 팩터리 메서드가 '값인 소수인 BigInteger을 반환활 객체'의 특성을 더 쉽게 묘사 가능하다.
```  
2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다. 객체 생서을 제한한다
```
이는 플라이웨이트 패턴과 유사한 방식으로, 예시를 들자면 Boolean.valueOf(boolean) 메서드 처럼 객체를 아예 생성하지 않는다.
또한, 반복되는 요청에 같은 객체를 반환하는 식으로 정적 팩터리 방식의 클래스는 언제 어느 인스턴스를 살아 있게 할지를 철저히 통제한다.
이러한 instance-Controlled 방식은 클래스를 싱글턴(Singleton) 또는 인스턴스화 불가(noninstantialbe)로 만들거나, 불변 값 클래스의 동치(equals)를 하나뿐임을 보장할 수 있다.
```
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
```
Java 8 부터는 인터페이스가 정적 메소드를 가질 수 없다는 제한이 풀렸다. 따라서 인스턴스화 불가 동반 클래스를 둘 이유가 없다.
동반 클래스에 두었던 public 정적 멤버들을 인터페이스 자체에 두면 되는 것이다.
```
4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
```
반환 타입의 하위 타입이기만 하면 어떤 클래스의 객체를 반환하든 상관이 없다.
예를 들어, EnumSet 클래스는 원소의 수에 따라(원소가 64 이하면 원소를 long 변수 - RegularEnumSet, 65개 이상이면 long 배열 - JumboEnumSet) 인스턴스를 반환한다.
클라이언트는 팩터리가 건ㄴ주는 객체가 어느 클래스의 인스턴스인지 알 수도 없고, 알 필요도 없다.
```
5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
```
이러한 유연함이 서비스 제공자 프레임워크의 근간이 되었다. 대표적인 JDBC(Java Database Connectivity)가 있다.
이러한 서비스 제공자 프레임워크는 구현체의 동작을 정의하는 서비스 인터페이스, 제공자가 구현체를 등록할 때 사용하는 제공자 등록 API,
클라이언트가 서비스의 인스턴스를 얻을 때 사용하는 서비스 접근 API가 존재한다.
이 중 서비스 접근 API가 유연한 '정적 팩터리 메소드'의 실체이다. 
```

### 정적 팩터리 메소드의 단점 ( VS 생성자 메소드)
---
1. 상속을 하기 위해선 public 이나 protected 생성자가 필요하다.
```
정적 팩터리 메소드만 제공하면 하위 클래스를 만들 수 없다.
따라서 상속이 꼭 필요한 경우(진짜 하위 클래스가 부모의 클래싕 한 종류)가 아니라면
컴포지션을 사용하여 불변 타입으로 만들자.
이로 인해 연관성은 유지하되, 강한 결합을 피하여 유지보수성과 캡슐화를 가질 수 있다.
```
```
public class Parent {
    private Parent() {} // 외부에서 직접 생성 불가

    public static Parent createInstance() {
        return new Parent();
    }

    public void doSomething() {
        System.out.println("Parent method");
    }
}
```
2. 정적 팩터리 메소드는 프로그래머가 찾기 어렵다.
```
생성자처럼 API 문서에 명확히 드러나지 않으니 사용자는 정적 팩터리 메서드 방식 클래스를 인스턴스화할 방법을 알아내야 한다.
이를 위해 API 문서를 잘 작성하고 메서드 이름 또한 널리 알려진 규약을 따라 짓자.
```
```
- from -> Date d= Date.frome(instant);
- of -> Set<Rank> faceCards = EnumSet.of(JACK,QUEEN,KING);
- valueOf -> BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
- instance 혹은 getInstance -> StackWalker luke = StackWalker.getInstace(options);
- create 혹은 newInstance -> Object newArray = Array.newInstance(classObject, arrayLen);
- getType -> FileStore rs = Files.getFileStore(path)
- newType -> BufferedReader br = Files.newBufferedReader(path);
- type -> List<Complaint> litany = Collections.list(legacyLitany);
```

- 정리
```
정적 팩터리 메소드와 public 생성자는 각자의 장점이 있으므로 상대적인 장단점을 비교하여 사용하자.
무작정 public 메소드를 사용하기 보단 정적 팩터리 메소드의 사용이 더 유리한 경우가 많으므로 습관을 고치자.
1. 불필요한 인스턴스 생성을 막거나, 객체 생성을 제어해야 한다. -> 정적 팩터리 메소드 방식
2. 단순한 객체 생성을 원하거나 , 상속이 필요한 경우 -> public 생성자 방식
```
