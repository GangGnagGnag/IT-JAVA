package Health;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ResChoice {
    static boolean run = false;
    ArrayList<Res> res = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void resChoice() {
        boolean yes = true;
        int choice;

        while (!run) {
            System.out.println("==========================================================");
            System.out.println("1. 회원 등록 | 2. 회원 조회 | 3. 연장 | 4. 회원 삭제 | 5. 종료 ");
            System.out.println("==========================================================");

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
                    createMember();
                    break;
                case 2:
                    memberList();
                    break;
                case 3:
//                    extension();
                    break;
                case 4:
//                    deleteMember();
                    break;
                case 5:
                    System.out.println("종료합니다");
                    yes = false;

                default:
                    System.out.println("잘못된 입력 입니다.");
            }
        }
    }

    public void createMember() {
        Res newMember = new Res();
        int PT;

        while (!run) {
            System.out.println();
            System.out.println("등록하실 ID를 생성하세요.");
            System.out.print(">> ");
            String memberId = sc.nextLine();
            newMember.setMemberId(memberId);
            System.out.println();
            boolean PWC = false;

            while (!PWC) {
                System.out.print("등록하실 비밀번호 4자리를 입력하세요(ex: 1234) ");
                System.out.print(">> ");
                if (sc.hasNextInt()) {
                    int memberPw = sc.nextInt();
                    sc.nextLine();
                    newMember.setMemberPw(memberPw);
                    PWC = true;
                } else {
                    System.out.println();
                    System.out.println("잘못된 입력입니다");
                    System.out.println();
                    sc.next();
                    continue;
                }

                System.out.println();
                System.out.println("회원님 이름을 적어주세요");
                System.out.print(">> ");
                String name = sc.nextLine();
                newMember.setMemberName(name);
                boolean PTC = false;

                while (!PTC) {
                    System.out.println();
                    System.out.println("등록하실 PT횟수를 입력하세요");
                    System.out.print(">> ");

                    if (sc.hasNextInt()) {
                        PT = sc.nextInt();
                        sc.nextLine();
                        if (PT <= 0) {
                            System.out.println("0은 입력이 불가능 합니다");
                            continue;
                        } else {
                            // run 변수 값을 수정하지 않고, PTC만 true로 변경
                            newMember.setCount(PT);
                            PTC = true; // PTC를 true로 변경하여 루프를 빠져나감
                        }
                    } else {
                        System.out.println("숫자가 아닌 값이 입력되었습니다.");
                        sc.next();
                        continue;
                    }

                    res.add(newMember);

                    System.out.println();
                    System.out.println("================================================");
                    System.out.println("회원 등록이 완료.");
                    System.out.println(newMember.getMemberName() + " 님의 회원번호는" + newMember.getMemberId());
                    System.out.println("(*비밀번호는 다른 사람에게 노출되지않게 주의하여주세요*)");
                    System.out.println("비밀번호는 " + newMember.getMemberPw() + "입니다 ");
                    System.out.println("남은 PT 횟수는 " + newMember.getCount() + "회 입니다");
                    System.out.println("================================================");
                    break;
                }
            }
        }
    }

    public void memberList() {
        System.out.println("회원 ID를 입력하세요");
        System.out.print(">> ");
        String memberId = sc.nextLine();

        System.out.println("비밀번호를 입력하세요");
        System.out.print(">> ");
        int memberPw = sc.nextInt();
        sc.nextLine();

        for (Res member : res) {
            if (member.getMemberId().equals(memberId) && member.getMemberPw() == memberPw) {
                System.out.println("회원 정보를 찾았습니다:");
                System.out.println("이름: " + member.getMemberName());
                System.out.println("회원번호: " + member.getMemberId());
                System.out.println("남은 PT 횟수: " + member.getCount());
                run = true;
                break;
            }
        }
        if(!run){
            System.out.println("일치하는 회원이 없습니다");
        }
    }
}