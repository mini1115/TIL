# 생성자에 매개변수가 많다면 빌더를 고려하자.
---

- Q. 만약 선택적 매개변수(1~20개)가 존재한다면 어떤 방식을 채택해야 하는가?
1. 점층적 생성자 패턴의 사용
<br/>` 매개변수가 많아짐에 따라 클라이언트가 코드를 작성하거나 읽기 어려워 진다.`
2. 자바 빈스(Java Beans) 패턴의 사용
```
매개변수가 없는 생성자로 객체를 만든 후, 세터(Setter) 메서드들을 호출해 원하는 매개변수의 값을 설정
이러한 패턴은 객체를 생성시 메서드를 여러 개 호출해야 하고, 객체가 완전히 생성되기 전까지 일관성(Cosistency)를 무너트린다. 
```
3. 빌더 패턴(Builder) <br/>
`클라이언트는 필요한 객체를 직접 만드는 대신, 필수 매개변수만으로 정적 팩토리 메소드를 호출해 빌더 객체를 얻는다.`
```
package calculator;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;


    public static class Builder {
        //        필수 매개변수
        private final int servingSize;
        private final int servings;
        //    선택 매개변수 - 기본값으로 초기화
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }


    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
    }
}

```
