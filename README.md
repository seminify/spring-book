# [spring-book](https://github.com/seminify/spring-book)

---

# Vol.1 스프링의 이해와 원리

> ## 1장 오브젝트와 의존관계
> ### 1.1 초난감 DAO
> > ### 1.1.1 [User](https://github.com/seminify/spring-book/tree/vol.1.1.1.1)
> > [User](https://github.com/seminify/spring-book/blob/vol.1.1.1.1/src/main/java/org/seminify/springbook/user/domain/User.java):
> > 사용자 정보를 저장할 User 클래스
>
> > ### 1.1.2 [UserDao](https://github.com/seminify/spring-book/tree/vol.1.1.1.2)
> > [pom.xml](https://github.com/seminify/spring-book/blob/vol.1.1.1.2/pom.xml): MySQL 드라이버 추가
> >
> > [UserDao](https://github.com/seminify/spring-book/blob/vol.1.1.1.2/src/main/java/org/seminify/springbook/user/dao/UserDao.java):
> > 사용자 정보를 DB에 넣고 관리할 수 있는 DAO 클래스
> > 1. DB 연결을 위한 Connection을 가져온다.
> > 2. SQL을 담을 Statement(또는 PreparedStatement)를 만든다.
> > 3. 만들어진 Statement를 실행한다.
> > 4. 조회의 경우 SQL 쿼리의 실행 결과를 ResultSet으로 받아서 정보를 저장할 오브젝트에 옮겨준다.
> > 5. 작업 중에 생성된 Connection, Statement, ResultSet 같은 리소스는 작업을 마친 후 반드시 닫아준다.
> > 6. JDBC API가 만들어내는 예외를 잡아서 직접 처리하거나, 메소드에 throws를 선언해서 예외가 발생하면 메소드 밖으로 던지게 한다.
> >
>
> > ### 1.1.3 [main()을 이용한 DAO 테스트 코드](https://github.com/seminify/spring-book/tree/vol.1.1.1.3)
> > [UserDaoTest](https://github.com/seminify/spring-book/blob/vol.1.1.1.3/src/test/java/org/seminify/springbook/user/dao/UserDaoTest.java):
> > main()을 이용한 DAO 테스트 코드
>
> > ### 1.2.1 [관심사의 분리](https://github.com/seminify/spring-book/tree/vol.1.1.2.1)
> > 관심사의 분리: 관심이 같은 것끼리는 하나의 객체 안으로 또는 친한 객체로 모이게 하고, 관심이 다른 것은 가능한 따로 떨어져서 서로 영향을 주지 않도록 분리하는 것
>
> > ### 1.2.2 [커넥션 만들기의 추출](https://github.com/seminify/spring-book/tree/vol.1.1.2.2)
> > [UserDao](https://github.com/seminify/spring-book/blob/vol.1.1.2.2/src/main/java/org/seminify/springbook/user/dao/UserDao.java):
> > 중복 코드의 메소드 추출
> >
> > 리팩토링: 기능에는 영향을 주지 않으면서 코드의 구조만 변경
> >
> > 메소드 추출: 공통의 기능을 담당하는 중복된 코드를 뽑아내는 리팩토링
>
> > ### 1.2.3 [DB 커넥션 만들기의 독립](https://github.com/seminify/spring-book/tree/vol.1.1.2.3)
> > [UserDao](https://github.com/seminify/spring-book/blob/vol.1.1.2.3/src/main/java/org/seminify/springbook/user/dao/UserDao.java), [NUserDao](https://github.com/seminify/spring-book/blob/vol.1.1.2.3/src/main/java/org/seminify/springbook/user/dao/NUserDao.java), [DUserDao](https://github.com/seminify/spring-book/blob/vol.1.1.2.3/src/main/java/org/seminify/springbook/user/dao/DUserDao.java), [UserDaoTest](https://github.com/seminify/spring-book/blob/vol.1.1.2.3/src/test/java/org/seminify/springbook/user/dao/UserDaoTest.java):
> > 상속을 통한 확장
> >
> > 탬플릿 메소드 패턴: 슈퍼클래스에 기본적인 로직의 흐름을 만들고, 그 기능의 일부를 추상 메소드나 오버라이딩이 가능한 protected 메소드 등으로 만든 뒤 서브클래스에서 이런 메소드를 필요에 맞게 구현해서
> > 사용하도록 하는 방법
> >
> > 팩토리 메소드 패턴: 서브클래스에서 구체적인 오브젝트 생성 방법을 결정하게 하는 것
> >
> > 단점
> > - 자바는 클래스의 다중상속을 허용하지 않는다.
> > - 상속을 통한 상하위 클래스의 관계는 생각보다 밀접하다.(서브클래스는 슈퍼클래스의 기능을 직접 사용할 수 있다.)
