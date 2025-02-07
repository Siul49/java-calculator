# java-calculator-precourse

# 문자열 계산기
## 테스트 클래스 만들기

## 문자열 입력받기
- camp.nextstep.edu.missionutils의 Console API를 사용하여 구현해야한다(설마 여기에 ArrayList가 없겠어?)
- 그 API의 readLine()을 사용한다.

## ArrayList numbers : 매개변수로 ArrayList를 받아 숫자 N개를 합하는 메소드 만들기
- int sum 변수 선언

## extractNum 메소드 : 구분자를 구별해 숫자를 ArrayList에 담아주는 메소드 만들기
- 인스턴스 변수로 기존 구분자(쉼표, :)를 담은 ArrayList separator 만들기
- 입력받은 문자열을 toCharArray() 메소드를 이용해서 char 배열로 변환해준다.
- 구분자나 숫자가 아닌 다른 문자가 있다면 IllegalArgumentException를 발생시킨다.
- 입력받은 문자열에 '//'가 포함되어있다면 '//'이후의 문자를 separator에 add한다.
- 그리고 다시 문자열을 입력받는다.
- 구분자 이전까지 문자들을 StringBuilder sb에 append한다
- 구분자가 나오면 numbers에 String을 저장한 후 sb.setLength(0)을 해서 비운 후에 다시 진행한다

### 입력받고 -> extractNum 메소드로 이동 -> numbers 메소드로 이동 -> 출력tor-precourse