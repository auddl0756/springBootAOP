# SpringBoot AOP

## overview
AOP : Aspect Oriented Programming<br>
핵심 로직 vs concern(관심사,자잘한 걱정 거리,주변 로직)<br>
핵심 로직과 concern을 분리하고 실행할 때(런타임) 결합.<br>
기존 코드의 수정 없이 주변 로직을 작성할 수 있다.<br>
spring은 AOP를 지원함.<br>

## 용어
1. Target<br>
   핵심 로직을 가지는 객체
   
2. JoinPoint<br>
target이 가진 여러 메서드?

3. Pointcut<br>
target의 여러 메서드 중 정확히 어떤 메서드에 concern을 결합할 지를 결정하는 것?<br>
= 핵심 로직과 주변 로직이 결합되는 지점을 결정하는 것.<br>
(어떻게 결정하는데..?)<br>

4. Proxy<br>
내부적으로 concern들을 거쳐서 target을 호출?<br>
외부적으로 target 객체의 joinPoint를 호출?<br>
spring aop가 자동으로 만드는 auto-proxy(?)방식을 이용<br>

5. Advice<br>
주변 로직을 분리해 놓은 코드<br>
   
## 실습 내용
AOP로 주변 로직들 구현하기<br>
: 로깅, 간단한 실행 시간 측정 

## 느낀점
@Before,@AfterThrowing 같은 것 보다<br>
@Around, ProceedingJoinPoint가 제일 기능이 많아서 좋다.<br>
Target,Parameters,method signature 등 구할 수 있다.

## 부족한 점
트랜잭션에서 쓰일 때? (@Transactional)<br>
proxy 구조,호출 구조


## 참고
- 코드로 배우는 스프링 부트
- [jdk dynamic proxy vs cglib](https://stackoverflow.com/questions/10664182/what-is-the-difference-between-jdk-dynamic-proxy-and-cglib)
