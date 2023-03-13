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
