# MUSINSA - JAVA BACK-END PROJECT

## 기술스택
1. Language : JAVA
2. FrameWork : Spring Boot 3.3.1
3. DB : H2 DataBase
4. ORM : Spring Data JPA
5. BuildTool : gradle

## 서버 실행
1. cd musinsa (프로젝트 폴더로 이동)
2. gradlew clean build
3. java -jar musinsa-0.0.1-SNAPSHOT.jar


## Swagger
> http://localhost:8080/musinsa/swagger-ui/index.html

## 구현과제
### 구현 1 - 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
+ 리턴타입 : LowestPriceCategoryResponseDto.class
+ requestBody : x
+ pathVariable : x
+ curl : curl -X 'GET' \
  'http://localhost:8080/musinsa/api/search/item-categories/lowest-price' \
  -H 'accept: application/json'
