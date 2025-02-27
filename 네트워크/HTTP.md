## HTTP란?
---
> 웹상에서 클라이언트와 서버 간 통신을 위한 프로토콜
>> 프로토콜이란 ? 네트워크 통신에서 데이터를 교환하기 위한 규칙이나 표준.

### HTTP 표준 이전(HTTP/ 0.9)
---
```
초창기 웹(WWW)은 팀 버너스리가 제안한 인터넷 기반의 시스템이다.
일반적으로 HTTP 프로토콜을 이용해 HTML을 주고 받을 수 있는 공간을 의미한다.
초창기 웹은 아주 단순한 서버 - 클라이언트 구조를 따랐습니다.
이는 클라이언트에서 HTML을 달라고 서버에게 HTTP 규격에 맞추어 요청을 보내면, 서버는 그에 맞는 HTML을 전송하는 단순한 작업이였다.
이는 애초에 웹이 대학과 연구소를 위한 학술적 정보를 저장하고 교환하기 위한 목적으로 제안되었기 때문이다.

이러한 HTTP는 처음부터 TCP/IP 위에서 구현되도록 설계되었다. + 트래픽 최적화 기술 (1. 흐름제어 2. 혼잡 제어 기능 제공) , 초기에는 GET 방식 한가지
그러나 웹이 인기를 끌다보니 기존의 HTTP 사양으로는 모든 요구사항을 충족할 수 없게 되었기에, 여러 기능을 추가하게 되었다.
당시에는 여러 브라우저와 벤더 사에 기능을 추가했기에, 약속된 규정이 없었기 때문에 많은 혼란이 있었다. (서버와 클라이언트의 기능 일관성 부족)
그래서 HTTP의 기존 구조는 그대로 유지하면서 다양한 요구사항을 충족시키고 표준화하기 위해 HTTP WG(Working Group)이 탄생하였고,
1996년 HTTP WG은 이러한 사양을 정리하여 탄생한것이 HTTP/ 1.0 이라한다.
```

### HTTP/1.X
---
```
이러한 HTTP/ 1.0 방식은 GET, HEAD, POST 세 가지로 확장되었다.
HTTP/ 1.0 경우 한개의 요청과 응답마다 TCP Connection을 생성하여 사용한다.
하지만 이러한 방식은 매 요청마다 연결을 생성하는 오버헤드가 발생한다.
이러한 문제를 해결하기 위해 HTTP/1.1은 이러한 문제를 지속 커넥션(Persistent Connection) 이라는 지정한 타임아웃만큼 커넥션을 종료하지 않는 방식으로 해결한다.
추가로 파이프라이닝(PipeLining)을 지원하여 요청의 응답 지연을 감소한다. 파이프라이닝에서 HTTP 요청은 연속적, 순차적으로 전달된다.
예를 들어 기존의 방식은 요청한 이후에 응답을 기다리고 그 다음 요청을 보내는 방식이였다면,
파이프라이닝에서는 필요한 모든 자원에 대한 요청을 순차적으로 서버에 전송한 다음 모든 요청에 대한 응답을 한번에 기다리게 된다.
```
> 그렇다면 문제점은 없는것일까?
```
HTTP/1.1은 1.0 버전에 비해 상당히 개선되었다고 하지만, 여전히 문제가 존재한다.
대표적으로 HOL Blocking(Head-Of-Line) 문제가 존재한다.
예를 들어, 3개의 요청을 파이프라인을 통해 전송을 한다고 했을 때, 서버는 모든 요청을 순서에 맞춰서 응답해야 한다.
이때 첫번에 요청이 오랜 시간이 발생한다면, 나머지 2개의 요청 또한 처리를 기다려야 한다.
또한 HTTP /1.1 버전은 매 요청마다 동일한 헤더를 반복하여 전송한다는 문제점도 존재한다.
```

### RESTful
---
```
기존의 웹은 주로 클라이언트 요청에 따라 서버가 완성된 HTML 파일을 제공하는 것이 전부였다면,
서버와 서버간의 통신의 경우 데이터를 주고 받을 수 있는 API가 필요했는데 여기에 대한 표준이 전무했다.

당시 HTTP가 웹에서 사용되는 표준 프로토콜이기에, HTTP를 기반으로 웹의 장점을 최대한 활용할 수 있는 아키텍처로 REST(Representational State Transfer)이 제안되었다.
REST 방식은 HTTP 메소드를 활용하여 CRUD(CREATE,READ,UPDATE,DELETE)를 구현하고, URL를 통해 자원을 명시하는 등 HTTP 통신의 특성을 최대한 활용하는 아키텍처이다.

이맘때, XML이나 JSON과 같은 데이터 포맷이 등장하고, 웹 브라우저에서도 비동기로 서버에 요청을 보낼 수 있는 기술을 AJAX(Asynchronous JavaScript and XML)가 보편화 되었다.
```



### HTTP/1.1 과 HTTP/2.0이란
---
```
두 가지 모두 인터넷 통신 프로토콜로서 두 가지 주요 버전은 성능, 효율성, 확장성 측면에서 차이점이 존재한다.
```

### HTTP/2.0
---
```
HTTP/ 1.1는 메시지를 일반 텍스트 형식으로 전송했다면, HTTP/2.0 부터는 기존 HTTP 메시지를 프레임이라는 단위로 분할하고
이를 이진 바이너리(binary) 형태로 만들어서 전송한다. 따라서 기존의 HTTP/ 1.1 버전에 비해 파싱 및 전송 속도가 향상되었다.

또한 HTTP/2.0 부터는 멀티플렉싱(Multiplexing)을 지원한다. 이는 하나의 커넥션을 사용하여 요청과 응답을 병렬로 처리할 수 있는 방식이다.
클라이언트가 서버로 여러 개의 요청을 동시에 보내도 각 요청이 독립적으로 처리되기 때문에, 애플리케이션 계층에서의 BOL 문제를 해결한다.
또한 헤더 압축방식(HPACK)을 사용해 반복되는 헤더를 효율적으로 관리하여 대역폭 사용이 최적화 되었다. -> 허프만(Huffman) 코딩 기법 사용 : 달라지지 않은 부분 전송 X

이외에도 HTTP/2.0은 서버가 클라이언트가 요청하지 않은 리소스를 미리 클라이언트에게 보낼 수 있는 서버 푸시 기능,
정수와 트리 구조로 구현된 스트림별 우선순위 지정 기능, 프로토콜 자체의 흐름 제어 기능이 포함되었다.
```

### HTTP/3.0
---
```
HTTP/2 가 여전히 TCP 위에서 동작하기 때문에 TCP로 인해 발생하는 문제를 해결할 수 없기 때문이다.
즉, 신뢰성 있는 전송을 지향하는 TCP 프로토콜의 HOLB 문제 (대기로 인한 병목현상) 해결할 수 없었다.
이러한 현대사회에서 어울리지 않는 TCP 프로토콜의 많은 문제로 인해 HTTP/3.0 은 QUIC 이라는 프로토콜 위에서 동작하게 된다.
```

### QUIC
---
```
QUIC은 2013년 구글에서 공개한 프로토콜로서, TCP 방식이 아닌 UDP 기반의 프로토콜이라는 점을 주목하자.
하지만 기존의 신뢰성을 제공하지 않는 UDP와 달리, QUIC은 신뢰성 기능이 제공되는( 패킷 재전송, 혼잡 제어, 흐름 제어) UDP 기반의 프로토콜이다.

우선 0-RTT 기능을 제공한다. TCP/IP는 최초 연결 수립시 3-Way Handshaking 작업이 필요하지만,
HTTP/3.0는 최초 연결 설정에서 연결에 필요한 정보들과 데이터를 함께 전송하여 1-RTT로 시간을 절약한다.
또한 한 번 성공한 연결은 캐싱해 놓았다가 다음 연결 때에는 캐싱된 정보를 바탕으로 바로 연결을 수립할 수 있어 0-RTT가 가능하다.

추가로 HTTP/3.0 은 연결 다중화를 지원하며, 각 스트림이 독립적으로 동작한다. 데이터 손실이 발생하더라도 다른 스트림에 영향을 주지 않는다.
HTTP/3.0 방식은 IP 기반이 아닌 연결 별 고유 UUID(Connection ID)를 이용해 각 연결을 식별한다. 
```


#### 참고 사항 References
1. [HTTP 진화과정](https://yozm.wishket.com/magazine/detail/1686/)
