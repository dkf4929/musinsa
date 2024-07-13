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
+ requestBody : x
+ pathVariable : x
+ 요청 path : curl -X 'GET' \
  'http://localhost:8080/musinsa/api/search/item-categories/lowest-price' \
  -H 'accept: application/json'
```
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
```
### 구현 2 - 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
+ requestBody : x
+ pathVariable : x
+ 요청 path : curl -X 'GET' \
  'http://localhost:8080/musinsa/api/search/brand/lowest-price' \
  -H 'accept: application/json'
  ```
  "최저가": {
    "브랜드": "D",
    "카테고리": [
      {
        "카테고리": "상의",
        "가격": "10,100"
      },
      {
        "카테고리": "아우터",
        "가격": "5,100"
      },
      {
        "카테고리": "바지",
        "가격": "3,000"
      },
      {
        "카테고리": "스니커즈",
        "가격": "9,500"
      },
      {
        "카테고리": "가방",
        "가격": "2,500"
      },
      {
        "카테고리": "모자",
        "가격": "1,500"
      },
      {
        "카테고리": "양말",
        "가격": "2,400"
      },
      {
        "카테고리": "액세서리",
        "가격": "2,000"
      }
    ],
    "총액": "36,100"
  }
  ```
### 구현 3 - 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
+ requestBody : x
+ pathVariable : 카테고리(ex - 아우터, 상의...)
+ 요청 path : curl -X 'GET' \
  'http://localhost:8080/musinsa/api/search/lowest-price/TOP' \
  -H 'accept: application/json'
```

{
  "카테고리": "상의",
  "최저가": {
    "브랜드": "C",
    "가격": "10,000"
  },
  "최고가": {
    "브랜드": "I",
    "가격": "11,400"
  }
}
```

### 구현 4 - 브랜드 및 상품을 추가/업데이트 /삭제하는 API
+ ITEM
  + 상품조회 ALL
  ++ /musinsa/api/item (GET)
  + 특정 상품조회
  ++ /musinsa/api/item/{itemId} (GET)
  + 상품추가
  ++ /musinsa/api/item (POST)
  ++ RequestBody (swagger 참조) 
