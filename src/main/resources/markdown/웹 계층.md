# Spring web 계층
## Web Layer
흔히 사용하는 컨트롤러(@Controller), JSP등의 뷰 템플릿 영역
이외에 @Filter, Interceptor, @ControllerAdvice등의 외부 요청과 응답에 대한 전반적인 영역

## Service Layer
@Service에 사용되는 영역, 일반적으로 Controller와 Dao 중간 영역에서 사용됨
@Transactional이 사용되어야 하는 영역이기도 하다.

## Repository Layer
Database와 같이 데이터 저장소에 접근하는 영역, 기존에 Dao영억으로 이해하면 됨

## Dtos
DTO(data transfer Object)는 계층 간에 데이터 교환을 위한 객체를 이야기한다.
뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체등이 이들을 얘기한다.

## Domain Model
도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화 시킨것
택시 앱을 만든다고하면 배차, 탑승, 요금 등이 모두 도메인이 된다.
@Entity가 사용된 영역 역시 도메인 모델이다. 다만 무조건 데이터베이스의 테이블과 관계가 있어야하는 것은 아니다
VO 처럼 값객체들도 이 영역에 해당한다.

이중에서 비즈니스 처리를 담당해야할 곳은 Domain이다.

## Dto
Entity 클래스와 거의 유사한 형태임에도 Dto클래스를 따로 생성해야한다. 절대로 Entity클래스를
request/response 클래스로 사용해서는 안된다. Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이며
Entity 클래스 기준으로 테이블이 생성되고, 스키마가 변경된다.

화면 변경은 아주 사소한 기능 변경인데 이를 위해 테이블과 연결된 Entity클래스를 변경하는 것은
너무 큰 리스크다.

수많은 서비스 클래스나 비즈니스 로직들이 Entity 클래스를 기준으로 동작한다. Request와 Response 용
Dto는 View를 위한 클래스라 정말 자주 변경이된다.

View Layer와 Db Layer의 역할분리를 철저히 하는게 좋다. 실제로 Controller에서 결괏값으로 여러 테이블을
조인해서 해줘야 할 경우가 빈번하므로 Entity 클래스 만으로는 표현하기 어려운 경우가 많다.

## 꼭 Entity 클래스와 Controller에서 쓸 Dto는 분리해서 사용한다.


