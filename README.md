# spring boot + redis 연동

설정에 대한 부분을 좀더 공부목적
- testCase 시작시 전체 데이터를 FlusAll하므로 주의하세요.
- redis client jedis의 3이상 버전에 대한 문제점
    - Spring Data Moore 릴리스 트레인의 일부인 Spring Data Redis 2.2에서 릴리스되며 Spring Boot 2.2에 포함될 예정입니다. 라고 되어있음..(삽질 조심하세요 전2시간..)   
    - https://stackoverflow.com/questions/54986159/i-do-not-know-why-this-is-happening-jedis-error-creating-bean-with-name-jedisc

### personSetTest
![Alt text](https://monosnap.com/image/T4hecmTJpUiFKlyrw1RdA3bq7cV7qW.png)

### personHashTest
![Alt text](https://monosnap.com/image/uWtRvdtBqGLu6RrYZpIt7YOvD8Tuwv.png)