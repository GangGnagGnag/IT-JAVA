package DTO;

import java.util.ArrayList;
import java.util.Scanner;

public class ResChoice {
    final public static String DB_URL           = "jdbc:oracle:thin:@localhost:1521:xe";
    final public static String DB_DRIVER_NAME   = "oracle.jdbc.driver.OracleDriver";
    final public static String DB_USER          = "ADER";
    final public static String DB_PW            = "1234";
    static Scanner sc = new Scanner(System.in);

    public void resChoice() {
        boolean yes = true;
        int choice;

        while (yes) {
            System.out.println("\n=========================================================================");
            System.out.println("1. 회원 등록 | 2. 전체 회원 조회 | 3. PT연장 | 4. 회원 삭제 | 5.수업 | 6. 종료 ");
            System.out.println("=========================================================================");

            System.out.print("번호를 입력하여 주세요 >> ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println(" 잘못된 입력입니다.");
                System.out.print("번호를 입력하여 주세요 >> ");
                sc.nextLine(); // 잘못된 입력값 버리기
                continue;
            }

            switch (choice) {
                case 1:
                    insert.insertClass();
                    break;

                case 2:
                    look.lookClass();
                    break;

                case 3:
                    Extention.extention();
                    break;

                case 4:
                    DeleteMember.deleteMember();
                    break;

                case 5:
                    System.out.println("1. 수업 등록 | 2. 수업 조회");
                    int subChoice2 = sc.nextInt();
                    sc.nextLine(); // 개행 문자 처리

                    switch (subChoice2) {
                        case 1:
                            break;
                        case 2:
//                            PTStudy.ptstudy();
                            break;
                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                    break; // 전의 코드에서 break; << 이 줄 없었기에 몇 번을 클릭하든 case 6이 실행되는 문제가 있었습니다.
                case 6:
                    System.out.println("종료합니다");
                    yes = false;
                    break; // 선택 5일 때 종료// 선택 5일 때 종료

                default:
                    System.out.println("잘못된 입력 입니다.");

            }
        }
    }
}
