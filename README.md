# 나 혼자 잘 산다 😀😁😂🤣😃😄😅😋

![image](https://user-images.githubusercontent.com/29085414/148169668-f06861f6-b613-4aaa-b51b-95fa81578f13.png)


## 목차
* [개요](#개요)
* [주제 선정 배경](#주제-선정-배경)
* [빅데이터 분석](#빅데이터-분석)
  + [이상치 제거](#이상치-제거)
  + [상관관계 함수](#상관관계-함수)
  + [경감 지표 선정](#경감-지표-선정)
    - [CCTV](#cctv)
    - [치안센터](#치안센터)
  + [회귀 분석 및 안전지수 도출](#회귀-분석-및-안전지수-도출)
      * [위해지표](#위해지표)
      * [취약지표](#취약지표)
  + [예측안전지수 부여](#예측안전지수-부여)
* [시각화 구현](#시각화-구현)
  - [맵 시각화](#맵-시각화)
  - [차트](#차트)
* [조원](#조원)

## 개요

 범죄율과 상관관계가 높았던 변수 (CCTV, 가로등, 여성안전지킴이집, 안전비상벨)과 시간별, 장소별을 빅데이터 분석 후 시각화

## 주제 선정 배경

<!-- ![image-20220103105448924](https://user-images.githubusercontent.com/51068026/147896021-89848c95-3548-4503-969c-cdb80ce50b77.png) -->
![image](https://user-images.githubusercontent.com/29085414/148725011-52f2d071-5d13-4e50-ae6e-2e573e385f4c.png)


- 1인 가구 나홀로족이 계속 증가

- 1인 가구인 사람들은 범죄에 관한 두려움이 전체 가구에 비해 상대적으로 높음

- 1인 가구는 범죄에 노출될 가능성이 상대적으로 높다라는 뉴스 기사도 있음.

- 범죄율과 상관관계가 높았던 변수 추출하여 시각화한다.

  (범죄율,단란주점,유흥주점,1인가구(여성,남성,노인),CCTV,치안시설비)

- 관련 논문
  [1인 가구와 범죄발생에 관한 연구: 서울시 25개 자치구 패널자료를 중심으로]:"https://www.si.re.kr/node/60865"
  
  

## 빅데이터 분석


### ■  이상치 제거
![image-20220103110025355](https://user-images.githubusercontent.com/51068026/147896035-399c40f7-31e0-45a6-a648-ddb64f9d83b4.png)

- 결측치를 제거 후 이상치를 정리하고 상관분석을 실행한다.



### ■ 상관관계 함수
Corr 이용 -> heatmap 시각화

####  1인가구(남성,여성,노인)

![image](https://user-images.githubusercontent.com/29085414/148727454-43415174-1b87-4310-8245-e16589bea117.png)


#### 유흥주점,단란주점

![image](https://user-images.githubusercontent.com/29085414/148727777-317245db-018d-40f9-9e70-bc801c682c5a.png)



### ■ 경감 지표 선정

#### CCTV

![image](https://user-images.githubusercontent.com/29085414/148727830-6ba3f56a-fc26-4e13-abab-a3ffd9bfc77e.png)


#### 치안센터

![image](https://user-images.githubusercontent.com/29085414/148727856-6b5cfbc8-2a49-45d8-9042-34635865c319.png)


### ■ 회귀 분석 및 안전지수 도출

2017 ~ 2020년 자료로 분석

#### ■ 회귀식, 안전지수 도출 

행정안전부 안전 지수 도출 공식을 활용한다.

![image-20220103111302548](https://user-images.githubusercontent.com/51068026/147896066-92895347-43f0-4632-a201-0cb81324fede.png)

>  위해지표(사망, 건수) + 취약지표 (위해지표 발생원인) - 경감지표 (위해지표 경감요인)


##### 위해지표 
5대 범죄율 (0.5)

##### 취약지표 

- 1인가구(여성) (0.044)

- 치안센터 (0.25)

- 단란주점 (0.156)

- CCTV (0.05)

### 예측안전지수 부여

| 1등급 | 2등급 | 3등급 | 4등급 | 5등급 |
| ----- | ----- | ----- | ----- | ----- |
| 10%   | 25%   | 30%   | 25%   | 10%   |



## 시각화 구현

### 메인

![그림2](https://user-images.githubusercontent.com/29085414/148730157-acb36ba0-4b21-4b21-973a-4ec1f0d4a83d.png)

태블로로 시각화한 데이터를 보여준다.

- 범죄율, CCTV, 치안시설, 보안등, 유흥업소

- 해당 구에 안전시설이 많은 TOP 3와 WORST 3를 표시한다

![image](https://user-images.githubusercontent.com/29085414/148730635-4a1a2fff-4ff2-4222-a1bb-9cb1cf65ef21.png)

태블로로 시각화한 데이터를 보여준다.

![image](https://user-images.githubusercontent.com/29085414/148730672-baf34dfb-e133-443d-9209-6cdcd472e03a.png)

태블로로 시각화한 데이터를 보여준다.



### 데이터 대시보드

![image-20220103111941433](https://user-images.githubusercontent.com/51068026/147896073-413f31d6-ca0d-4476-9109-4e259e5b42b7.png)

안전시설 CCTV, 보안등, 여성 안전지킴이 집, 비상 안전 벨의 데이터를 보여준다.

- 지도에 해당 안전시설 마커로 보여줌

- 해당 구에 안전시설이 많은 TOP5

- CCTV 현황 자세히 보기


![image](https://user-images.githubusercontent.com/29085414/148731162-40bf8d04-c3e2-4b1a-956a-9137f7f7adad.png)

시간별 각 범죄 항목 데이터를 시각화


![image](https://user-images.githubusercontent.com/29085414/148731188-4c1acbba-be2f-4874-8a2f-553c8544e574.png)

장소별 각 범죄 항목 데이터를 시각화



### 맵 시각화

- ANACONDA : Python 데이터 라이브러리

- Folium : Leaflet.js 기반으로 만들어진 Python 지도 시각화 라이브러리   

- tableau : 데이터 시각화 소프트웨어

### 차트 

 - chart.js : HTML5 Canvas 방식의 **강력한 오픈소스** **라이브러리**

- Simple-DataTables : JS 기반의 데이터 테이블 라이브러리

  
### 시연 영상


## 조원

이지윤, 정혜빈, 류수민, 정상협 



감사합니다.
