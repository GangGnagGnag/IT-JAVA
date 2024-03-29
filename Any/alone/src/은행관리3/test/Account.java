package 은행관리3.test;

public class Account {
    private String accountNumber;
    private String password;
    private String name;
    private int balance;

    //디폴트 생성자 메소드
    public Account(){

    }

    //매개변수 생성자 메소드
    public Account(String accountNumber, String password, String name, int balance){
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    //잔고를 조회하다. :getBalance
    public int getBalance(){
        return balance; //인스턴스 변수
        //return this.balance; //this가 생략되어 있는 것
    }

    //비밀번호를 변경하다.
    public void setPassword(String password){
        this.password = password;
    }

    //비밀번호를 조회하다.
    public String getPassword(){
        return password;
    }

    //입금하다. : deposit
    //int형 못쓰는 이유 => balance에서 사용했기 때문에 한번 사용하면 또 사용하지 못함
    public void deposit(int deposit){
        //입금의 조건
        if(deposit<=0 ){
            System.out.println("금액을 정확히 입력하세요.");
            return;
        }
        balance +=deposit;
    }

    //출금하다. : withdraw
    public void withdraw(int withdraw){
        if(withdraw>balance){
            System.out.println("잔액이 부족합니다.");
            return;
        }

        if(withdraw<=0){
            System.out.println("0원 및 마이너스단위는 출금하실 수 없습니다.");
            return;
        }
        balance -= withdraw;
    }

    //고객계좌정보를 조회하다.
    public String getAccountInfo(){
        return "계좌번호 :" + accountNumber +
                ", 예금주명 :" + name +
                ", 비밀번호 :" + password +
                ", 잔고 :" + balance;
    }

    //계좌번호를 조회하다.
    public String getAccountNumber(){
        return accountNumber;
    }
}
