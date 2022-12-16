import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.*;

public class Score {
    public static void inputScore() {
        //성적 입력
        List<Integer> list = new ArrayList<Integer>(5);
        List<String> list1 = new ArrayList<String>(5);
        List<Integer> list2 = new ArrayList<Integer>(5);


        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("학생 이름을 입력하세요 : ");
            String name = scanner.next();
            System.out.print("학생 학번을 입력하세요 : ");
            int num = scanner.nextInt();
            System.out.print("학생 성적을 입력하세요 : ");
            int score = scanner.nextInt();

            list1.add(name);
            list2.add(num);
            list.add(score);
        }
        Iterator<String> iterator = list1.iterator();
        Iterator<Integer> itr = list.iterator();
        Iterator<Integer> student = list2.iterator();


        System.out.println(" ");
        System.out.println("~~~~~~~~~~전체 성적~~~~~~~~~~");
        System.out.println(" ");
        System.out.println("-----------------------------------");

        System.out.print("학생 이름 :  ");
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + "     ");
        }
        System.out.println(" ");


        System.out.print("학생 학번 : ");
        while (student.hasNext()) {
            int value2 = student.next();
            System.out.print(value2 + "  ");
        }
        System.out.println(" ");



        System.out.print("학생 점수 :   ");
        while (itr.hasNext()) {
            int value = itr.next();
            System.out.print(value + "        ");
        }
        System.out.println(" ");




        System.out.println("-----------------------------------");
        System.out.println(" ");


        System.out.println("--개인 성적 확인창--");

        System.out.println("개인 성적을 확인하시겠습니까?(Y -> 1/N -> 2)");
        int check2 = scanner.nextInt();

        if (check2 == 1) {
            System.out.println("학생 학번을 입력하세요 : ");
            int num_ = scanner.nextInt();
            for (int i = 0; i < 3; i++) {
                if (num_ == list2.get(i)) {
                    System.out.println(list1.get(i) + " 학생의 성적 : " + list.get(i));
                    System.out.println("  ");
                    break;
                }
            }
        } else if (check2 == 2) {
            System.out.println("메뉴로 돌아갑니다.");
            System.out.println("  ");
        }

    }




}

