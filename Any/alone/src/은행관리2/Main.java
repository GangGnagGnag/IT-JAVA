package 은행관리2;

public class Main {
    public static void main(String[] args) {
        BankManagement BM = new BankManagement(); // 계좌관리 객체 생성

//       계좌생성 과 초기잔액
        System.out.println("====================================");
        Account ac1 = new Account("123123",10000);
        Account ac2 = new Account("456456",10000);
        BM.addAccount(ac1);
        BM.addAccount(ac2);
        System.out.println("====================================");

//        입급 출금
        BM.deposit("123123",8000); // 입금
        BM.withdraw("123123",8000); // 출금
        BM.deposit("456456",3000); // 입금
        BM.withdraw("456456",3000); // 출금

    }
}
