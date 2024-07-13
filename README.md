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
+ 요청 path : curl -X 'GET' \
  'http://localhost:8080/musinsa/api/search/item-categories/lowest-price' \
  -H 'accept: application/json'
{
  "상품": [
    {
      "카테고리": "상의",
      "브랜드": "C",
      "가격": "10,000"
    },
    {
      "카테고리": "아우터",
      "브랜드": "E",
      "가격": "5,000"
    },
    {
      "카테고리": "바지",
      "브랜드": "D",
      "가격": "3,000"
    },
    {
      "카테고리": "스니커즈",
      "브랜드": "A",
      "가격": "9,000"
    },
    {
      "카테고리": "가방",
      "브랜드": "A",
      "가격": "2,000"
    },
    {
      "카테고리": "모자",
      "브랜드": "D",
      "가격": "1,500"
    },
    {
      "카테고리": "양말",
      "브랜드": "I",
      "가격": "1,700"
    },
    {
      "카테고리": "액세서리",
      "브랜드": "F",
      "가격": "1,900"
    }
  ],
  "총액": "34,100"
}  
