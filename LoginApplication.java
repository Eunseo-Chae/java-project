import java.util.Scanner;

public class LoginApplication {

    private static User[] accountArray = new User[10];
    private static Scanner scanner = new Scanner(System.in);


    public static void createAccount() {    //1번 회원가입
        System.out.println("아이디, 패스워드, 닉네임을 입력하세요.");
        System.out.print("id: ");
        String id = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        System.out.print("nickname: ");
        String nickname = scanner.next();

        if (accountCheck(id)) {
            System.out.println("회원가입이 안됩니다.");
            return;
        }

        User newUser = new User(id, password, nickname);
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) {
                accountArray[i] = newUser;
                System.out.println("회원가입이 완료되었습니다.");
                System.out.println("   ");
                return;
            }
        }
    }

    public static boolean accountCheck(String id) {
        for (User value : accountArray) {
            if (value != null && value.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    public static void doLogin() {    //2번 로그인하기
        System.out.println("id와 password를 입력하세요.");

        System.out.print("id:");
        String id = scanner.next();

        System.out.print("password:");
        String password = scanner.next();

        User login_box = findLogin(id, password);
        if (login_box == null) {
            System.out.println("로그인 아이디와 패스워드가 일치하지 않습니다.");
            return;
        }
        login_box.setid(login_box.getId());
        login_box.setPassword(login_box.getPassword());
        login_box.setNickname(login_box.getNickname());

        System.out.println("  ");
        System.out.println(login_box.getNickname() + "님, 로그인 되었습니다.");
        System.out.println("----------------------------");
        System.out.println("id :" + login_box.getId());
        System.out.println("nickname :" + login_box.getNickname());
        System.out.println("----------------------------");
        System.out.println("  ");
    }



    public static void withdraw() {   //회원탈퇴
        System.out.println("회원탈퇴창 입니다.");
        System.out.print("id:");
        String id = scanner.next();
        System.out.print("password:");
        String password = scanner.next();

        User login_box = findLogin(id, password);

        if (login_box == null) {
            System.out.println("회원탈퇴를 할 수 없습니다.");
            return;
        } else {
            for (int i = 0; i < 9; i++) {
                if (login_box == accountArray[i]) {  //login_box.equals(accountArray[i])?
                    accountArray[i] = null;
                    System.out.println("회원탈퇴 되었습니다.");
                    while (accountArray[i] == null) {
                        for (int j = i; j < 9; j++) {
                            accountArray[j] = accountArray[j + 1];
                            accountArray[j + 1] = null;
                        }
                        break;
                    }
                    break;
                }
            }
            if (login_box.equals(accountArray[9])) {
                accountArray[9] = null;
                System.out.println("회원탈퇴 되었습니다.");
            }
        }
    }

    public static User findLogin(String id, String password) {
        User login_box = null;
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] != null) {
                String idBox = accountArray[i].getId();
                String passwordBox = accountArray[i].getPassword();

                if (idBox.equals(id) && passwordBox.equals(password)) {
                    login_box = accountArray[i];
                    break;
                }
            }
        }
        return login_box;
    }
}

