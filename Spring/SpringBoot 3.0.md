# SpringBoot 3.0 버전 업데이트
---
- 스프링 부트 3.0 부터는 JAVA 17 버전 이상을 요구
> 2.0 버전은 JAVA 8 버전 이상 요구

- 텍스트 블록
> 이전에는 여러 줄 텍스트 작성시 \n을 추가해야 했지만 이제는 """로 감싼 텍스트를 사용해 여러줄의 텍스트를 표현할 수 있다.

```
// 2.0 버전
String query = "SELECT + FROM \"items\"\n" +
        "WHERE \"status\" = "ON_SALE\"\M" +
        "ORDER BY \"price\,";\n";

// 3.0 버전
String query = """
      SELECT * FROM "items"
      WHERE "status"  = "ON_SALE"
      OREDER BY "price"l
      """;
```

- formatted() 메소드
> 값을 파싱하기 위한 formatted() 메서드를 제공한다.
```
String textBlock = """
{
  "id" : %d
  "name" : %s,
}
""".formatted(2, "juice");
```

4. Record 타입 추가
> 데이터 전달을 목적으로 하는 객체를 더 빠르고 간편하게 만들기 위한 기능.<br/>
레코드 객체는 상속을 할 수 없고, 파라미터에 정의한 필드는 private final로 정의된다.
```
record item(String name, int price){
    // 이렇게 하면 private  final로 정의된다.
}
Item juice = new Item("juice", 3000);
juice.price();
```

- 패턴 매칭
> 타입 확인을 위해 사용하던 instanceof 키워드를 더 쉽게 사용할수 있게 해준다.
```
// 자바 11버전
if( o instanceof Integer){
  Integer i = (Integer) o;
... 생략 ...
// 자바 17버전
if( o instanceof Integer i){
... 생략 ...
}
```

- 자료형에 맞는 case 처리
> switch - case 문을 자료형에 맞게 case 처리를 할 수도 있습니다.
```
static double getIntegerValue(Object o){
  return swithch(o) {
    case Double d -> d.intValue();
    case Float f -> f.intValue();
    case String s -> Integer.parseInt(s);
    default -> 0d;
  };
}
```
-  Servlet,JPA 네임 스페이스가 Jakarta로 대체
> 패키지 네임스페이스가 javax.*에서 -> jarkarta.*로 변경되었다.

- GraalVM 기반의 스프링 네이티브 공식 지원
> 기존의 2.0버전에 사용하던 가상 머신 보다 휠씬 빠르게 시작되며 더 적은 메모리를 차지합니다.
> JVM 실행 파일과 비교해 네이티브 이미지를 사용하면 가동 시간이 짧아지고 메모리를 더 적게 소모합니다.

[공식문서](https://docs.spring.io/spring-boot/docs/3.0.0/reference/htmlsingle/#upgrading)
