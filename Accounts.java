import java.util.*;
class Account{
    Scanner sc=new Scanner(System.in);
    ATM atm=new ATM();
    Coustomer cos;
    Account(Coustomer c){
        this.cos=c;
    }
    
    public void display(){
        System.out.println("The Balance is:"+" "+cos.balance);
    }
    public void withdraw(double am,HashMap<Integer,Double> w){
        if(cos.balance>=am && atm.atm_bal>=am){
            cos.balance=cos.balance-am;
            atm.atm_bal=atm.atm_bal-am;
            w.put(cos.acc_no,am);
            System.out.println("Ammount Withdrawed");
            updateCustomerBalance(cos);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public void deposit(double am){
        cos.balance+=am;
        System.out.println("Ammount Deposited");
        updateCustomerBalance(cos);
    }
    public void pingen(int p){
        if(p==cos.phoneNo){
            System.out.println("Enter new pin");
            cos.pin=sc.nextInt();
            updateCustomerBalance(cos);
            System.out.println("New pin Updated");
        }
        else{
            System.out.println("phone no wrong");
        }
    }
    private void updateCustomerBalance(Coustomer customer) {
        for (int i = 0; i < ATM.li.size(); i++) {
            if (ATM.li.get(i).acc_no == customer.acc_no) {
                ATM.li.set(i, customer);
                break;
            }
        }
    }

}
