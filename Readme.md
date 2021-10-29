# SpringBoot AOP

## overview
AOP : Aspect Oriented Programming<br>
핵심 로직 vs concern(관심사,자잘한 걱정 거리,주변 로직)<br>
핵심 로직과 concern을 분리하고 실행할 때(런타임) 결합.<br>
기존 코드의 수정 없이 주변 로직을 작성할 수 있다.<br>
proxy로 AOP를 많이 구현하는데 spring도 AOP를 지원하고 proxy로 구현<br>

## 용어
1. Target<br>
   핵심 로직을 가지는 객체
   
2. JoinPoint<br>
   target이 가진 여러 메서드?

3. Pointcut<br>
target의 여러 메서드(JoinPoint) 중에서 정확히 어떤 메서드에 concern을 결합할 지를 결정하는 것<br>
= 핵심 로직과 주변 로직이 결합되는 지점을 결정하는 것.<br>
(어떻게 결정하는데..?)<br>

4. Proxy<br>
내부적으로 concern들을 거쳐서 target을 호출?<br>
외부적으로 target 객체의 joinPoint를 호출?<br>
spring aop가 자동으로 만드는 auto-proxy(?)방식을 이용<br>

5. Advice<br>
주변 로직을 분리해 놓은 코드<br>
언제 주변 로직을 핵심 로직에 끼워 넣을지 정할 수 있다.<br>
before,after,afterThrowing,around 등<br>
<br>단순히 호출 시점에 초점을 맞춰서 advice는 주변 로직을 끼워 넣는지 위치라고만 정의하는 설명도 있다.<br>
즉, Aspect를 주변 로직이라 말하고 Aspect와 Advice를 분리해서 설명하는 사람도 있음.

## 실습 내용
AOP로 주변 로직들 구현하기<br>
: 로깅, 간단한 실행 시간 측정 

## 느낀점
@Before,@AfterThrowing 같은 것 보다<br>
@Around, ProceedingJoinPoint가 제일 기능이 많아서 좋다.<br>
Target,Parameters,method signature 등 구할 수 있다.

## 부족한 점
1. 트랜잭션에서 쓰일 때? (@Transactional)<br>
2. proxy 구조,호출 구조<br>
3. 여러 advice 적용 순서 (@Order?)
4. pointcut 설정 (execution 표현식)
   ``` 
   execution(am ret path(pr))
   am : 접근제한자 패턴 (생략 가능)
   ret : 리턴 타입 패턴
   path : 경로 패턴 = 패키지 패턴 + 클래스 패턴 + 메서드 패턴
   pr : 파라미터 패턴
   ```

## 참고
- 코드로 배우는 스프링 부트
- [jdk dynamic proxy vs cglib](https://stackoverflow.com/questions/10664182/what-is-the-difference-between-jdk-dynamic-proxy-and-cglib)
