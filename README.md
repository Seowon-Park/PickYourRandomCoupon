### Mini project[Java] 
2025.04.08 -
# 랜덤 쿠폰 선택 및 저장 프로그램
> 대박 쿠폰을 받을 수 있는 세 번의 기회! 만족하시겠습니까? 도전하시겠습니까?

### 프로젝트 소개
1.쿠폰 종류는 코스메틱, 식품, 가전기기 3가지이며 각 20개의 쿠폰, 총 60개의 쿠폰을 가진다.<br/>
2. 세부 항목의 20개의 쿠폰은 높은 할인률의 쿠폰(이하 '대박 쿠폰') 1개, 지금까지 뽑은 쿠폰을 전부 잃는 쿠폰(이하 '꽝 쿠폰') 2개, 일반적인 쿠폰(이하 '일반 쿠폰') 17개로 구성된다<br/>
3. 사용자는 코스메틱/식품/가전기기 쿠폰 중 하나를 선택할 수 있으며, 총 세 번의 선택 기회가 주어진다.<br/>
4. 한 번의 기회가 끝난 후 사용자는 도전/만족을 선택할 수 있다.<br/>
5. 세 번 안에 대박 쿠폰을 뽑는다면 사용자는 지금까지 뽑은 모든 쿠폰을 받을 수 있다.<br/>
6. 대박 쿠폰을 뽑는데 실패한다면 사용자는 지금까지 뽑은 모든 쿠폰을 잃는다.<br/>
7. 꽝 쿠폰을 뽑는다면 사용자는 지금까지 뽑은 모든 쿠폰을 잃는다(흥미 유발을 위해 첫번째 선택에서는 꽝 쿠폰이 나오지 않도록 한다.) <br/>
8. 쿠폰 뽑기 이후 사용자가 만족을 선택한다면 대박 쿠폰을 뽑지는 못했지만 지금까지 뽑은 모든 쿠폰을 받을 수 있다<br/>

### 제작 목적
참여형 쿠폰 발급 프로그램으로 해당 사이트에 대한 사용자의 관심도를 높인다


### 데이터 구조 및 흐름
카드<br/>
(카드종류 저장 및 초기화)<br/>
카드덱<br/>
(뽑기, 셔플 기능)<br/>
게임플레이(게임시작->도전/만족 선택->쿠폰종류(전자기기,식품,화장품)선택)3번 반복<br/>
-> <도전>대박쿠폰을 뽑은 경우, 게임 끝/꽝쿠폰을 뽑은 경우,일반쿠폰만 3번 뽑은 경우, 사용자 쿠폰 초기화 & 게임 끝//<만족> 게임 끝 <br/>
결과프린트

### 일정
2025.04.08(1시간)  **아이디어 구체화**<br/>
2025.04.08(1시간)  **데이터 구조 및 흐름 파악**<br/>
2025.04.09(1시간 30분)  **카드/카드덱(뽑기, 셔플 기능)/메인(게임시작->도전/만족 선택->쿠폰종류(전자기기,식품,화장품)선택=>결과프린트**<br/>
*5-8번 기능 추가해야함. 너무 순차적으로 작성한 듯..<br/>
객체지향적으로 작성이 뭘까..?<br/>
▼Java개발 카페에 질문해봤습니다<br/>
2025.04.14(1시간)  **5-8번 기능 추가**<br/>
* 1) 94열에 NullPointerException 예외 발생. 2) 범위 이상의 숫자를 입력할 경우 3) 2.만족을 입력할 경우 4) 모든 쿠폰의 종류가 전자기기로 나옴...

### 기술스택
* java jdk11<br/>
why? 자바의 정석 예제 문제를 응용&적용해보고 싶었습니다.

