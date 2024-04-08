import java.util.*;
public class AdminWork {
    ATM atm1=new ATM();
    Scanner sc=new Scanner(System.in);
    public  void a_balance(){
        System.out.println(atm1.atm_bal);
    }
    public  void a_deposit(){
        int ammt=sc.nextInt();
        atm1.atm_bal+=ammt;
        System.out.println("Ammount Deposited");
        System.out.println(atm1.atm_bal);
    }
    public void w_history(HashMap<Integer,Double> w){
        for(int i:w.keySet()){
            System.out.println(" "+"Account No"+" "+"Withdraw Ammount");
            System.out.println(" "+i+"             "+w.get(i));
        }
    }
}
