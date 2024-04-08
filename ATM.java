
import java.util.*;

public class ATM {
    static double atm_bal;
    

    static List<Coustomer> li=new ArrayList<>();
    static  HashMap<Integer,Double> w=new HashMap();
    static Scanner sc=new Scanner(System.in);
    static int ca;
    public static void main(String[] args) {
        
        
        li.add(new Coustomer(1234,121,123456789,1000));
        li.add(new Coustomer(1235,120,12345689,1100));
        li.add(new Coustomer(1231,125,1235689,110011));
       int cas=0;
        while(cas!=3){
            System.out.println("\nATM:");
            System.out.println("1. Admin");
            System.out.println("2. Coustomer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            cas=sc.nextInt();
            switch(cas){
                case 1:
                    a_menu(li);
                    break;
                case 2:
                    cos_menu();
                    break;
                case 3:        
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Enter Valid Option");
            }

        }
    }

    private static void cos_menu(){
        System.out.println("Enter the acc no");
        int a=sc.nextInt();
        for(int i=0;i<li.size();i++){
            if(li.get(i).acc_no==a){
                System.out.println("Enter the Pin");
                int pi=sc.nextInt();
                Coustomer c=li.get(i);
                
                if(pi==c.pin){
                    
        Account account=new Account(c);
        double amount;
        int v=1;
        do{
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Pin Generate12");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            ca = sc.nextInt();
            
            v++;
            switch (ca) {
                case 1:
                    System.out.print("Enter the withdrawal amount: ");
                    amount = sc.nextDouble();
                    account.withdraw(amount,w);
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    amount = sc.nextDouble();
                    account.deposit(amount);
                    break;
                case 3:
                    account.display();
                    break;
                case 4:
                System.out.println("Enter the phone no");
                int pno=sc.nextInt();
                    account.pingen(pno);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }  
        }while(v!=2);
                }
                else{
                    System.out.println("Pin or ID worng");
                }
            }
            
        }
        
    }




    private static void a_menu(List<Coustomer> li){
        Admin ad=new Admin();
        System.out.println("Enter Admin id");
        int aid=sc.nextInt();
        System.out.println("Enter admin password");
        int pass=sc.nextInt();
        if(aid==ad.id && pass==ad.pass ){
            System.out.println("\nAdmin Menu:");
            System.out.println("1. ATM Deposit");
            System.out.println("2. Check Balance");
            System.out.println("3. Transaction History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            ca=sc.nextInt();
            AdminWork adw=new AdminWork();
            switch (ca) {
                case 1:
                    adw.a_deposit();
                    break;
                case 2:
                    adw.a_balance();
                    break;
                case 3:
                    adw.w_history(w);
                default:
                    break;
            }
        }
        else{
            System.out.println("Account or Pin is Wrong1");
        }
        
    }
}
