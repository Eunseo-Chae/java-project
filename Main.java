
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("1. 회원가입 2. 로그인 3. 탈퇴 4. 성적 입력 5. 종료");
            System.out.print("번호를 선택하세요 : ");
            Scanner sc = new Scanner(System.in);
            int selectNo = sc.nextInt();
            System.out.println("  ");


            if (selectNo == 1) {
                LoginApplication.createAccount();
            } else if (selectNo == 2) {
                LoginApplication.doLogin();
            } else if (selectNo == 3) {
                LoginApplication.withdraw();
            } else if (selectNo == 4) {
                Score.inputScore();
            } else if (selectNo == 5) {
                run = false;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }
}