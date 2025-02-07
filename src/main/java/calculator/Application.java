package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

// gradlew.bat 오류가 뜬다 아무것도 모르겠다 그냥
public class Application {

    // 사용자의 input을 받는다.
    private String userInput;

    // 모든 숫자의 합을 저장한다.
    private int sum = 0;

    // 숫자, 구분자들을 저장한다.
    private ArrayList<String> numbers;
    private ArrayList<String> separator;

    public Application(){
        numbers = new ArrayList<String>();
        separator = new ArrayList<String>();
        setSeparator();
    }
    // userInput의 입력값을 받는다
    public void Input(){
        userInput = Console.readLine();
    }

    // 구분자 세터
    public void setSeparator() {

        // 구분자 설정
        separator.add(",");
        separator.add(":");
    }

    // nums에 있는 모든 숫자를 더한다.
    public void sumNumbers(ArrayList<String> nums){
        for (String number : nums) {
            sum += Integer.parseInt(number);
        }

        System.out.println(sum);
    }

    // numbers 개터
    public ArrayList<String> getNumbers(){
        return numbers;
    }

    // 구분자를 구별하고 숫자를 ArrayList에 담는다
    public void extractNum(){
        //구분자 초기화
        setSeparator();
        // 숫자 받아야지
        StringBuilder sb = new StringBuilder();

        // 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Input();
        for (int i = 0; i < userInput.length(); i++){
            if ((userInput.charAt(i) == '/' && userInput.charAt(i+1) == '/')) {
                // "//"를 인식하면 그 다음 문자를 구분자로 넣는다.
                // 개행문자를 만나면 문자열이 끝나기 때문에
                // 개행문자를 문자열로 넣는 과정을 추가하기보단
                // 그냥 다시 문자열을 받아도 상관 없겠다는 생각을 했어요
                // 근데 구분자를 추가하고 끝나는 경우도 있다는 생각에
                // if 문을 하나 더 넣었네요
                if (i+2 < userInput.length()) {
                    separator.add(String.valueOf(userInput.charAt(i + 2)));
                    if(userInput.length() > i + 4) {
                        Input();
                    }
                }
                else {
                    throw new IllegalArgumentException("잘못된 문자가 있는 것 같은데요?");
                }
            }
            else if (separator.contains(String.valueOf(userInput.charAt(i)))) {
                // sb에 모여있는 숫자들이 구분자를 만나면
                // numbers로 들어가고 sb는 초기화됨
                String result = sb.toString();
                numbers.add(result);
                sb.setLength(0);
            }
            else if (Character.isDigit(userInput.charAt(i)) ) {
                if (Integer.parseInt(String.valueOf(userInput.charAt(i))) < 0) {
                    // 문자열에 숫자는 sb에 넣어준다.
                    sb.append(userInput.charAt(i));
                }
                else {
                    throw new IllegalArgumentException("잘못된 문자가 있는 것 같은데요?");
                }
            }
            else {
                throw new IllegalArgumentException("잘못된 문자가 있는 것 같은데요?");
            }
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //생성자 호출
        Application a = new Application();

        a.extractNum();
        a.sumNumbers(a.getNumbers());
    }
}
