import java.util.*;

class Accounts{
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    Accounts(int accNo, String name, double bal){
        this.accountNumber=accNo;
        this.accountHolderName=name;
        this.balance= bal;
    }

    void deposit(double amt){
        if(amt>0){
            balance+=amt;
            System.out.println("Ammount deposited!!! Now your balance is "+balance);
        }else{
            System.out.println("Invalid Amount...");
        }
    }

    void withdraw(double amt){
        if(amt<=balance && amt>0){
            balance-=amt;
            System.out.println("Ammount withdraw !!! Now your balance is "+balance);
        }else{
            System.out.println("Invalid Amount...");
        }
    }

    double getBalance(){
        return balance;
    }

    String getDetails(){
        return "Account Number : "+accountNumber+"\nAcount Holder Name : "+accountHolderName+"\nBalance : "+balance;
    }
}

class Bank{
    private Map<Integer,Accounts> accounts;

    Bank(){
        accounts = new HashMap<>();
    }

    void createAccounts(int accNumber, String name, double bal){
        if(!accounts.containsKey(accNumber)){
            Accounts acc = new Accounts(accNumber,name,bal);
            accounts.put(accNumber, acc);
            System.out.println("Account created sucessfully");
        }else{
            System.out.println("Invalid account number...");
        }
    }

    void deposit(int accNo,double amt){
        Accounts acc = accounts.get(accNo);
        if(acc!=null){
            acc.deposit(amt);
        }else{
            System.out.println("Account not Found...");
        }
    }

    void withdraw(int accNo,double amt){
        Accounts acc = accounts.get(accNo);
        if(acc!=null){
            acc.withdraw(amt);
        }else{
            System.out.println("Account not Found...");
        }
    }

    void tranfer(int fromAccNo, int toAccNo, double amt){
        Accounts fromAcc = accounts.get(fromAccNo);
        Accounts toAcc = accounts.get(toAccNo);
        if(fromAcc!=null && toAcc!=null){
            fromAcc.withdraw(amt);
            toAcc.deposit(amt);
            if(amt>0)
                System.out.println("Amount "+ amt +" transefered from account number "+fromAccNo+" to account number "+toAccNo);
        }else{
            System.out.println("Accounts not Found...");
        }
    }

    void getAccountsDetail(int accNo){
        Accounts acc = accounts.get(accNo);
        if(acc!=null){
            System.out.println(acc.getDetails());
        }else{
            System.out.println("Account not Found...");
        }
    }
}

class BankY{
    public static void main(String args[]){
        char choice='a';
        Scanner sc = new Scanner(System.in);
        Bank obj = new Bank();

        do{
            System.out.println("Bank System Menu");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Transfer Amount");
            System.out.println("5. View Account Detail");

            System.out.println("Enter your Choice : ");
            int ch = sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter Account Number : ");
                        int accNo = sc.nextInt();
                        System.out.println("Enter Account Holder Name : ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter Balance : ");
                        double bal = sc.nextDouble();
                        obj.createAccounts(accNo,name,bal);
                        break;
                case 2: System.out.println("Enter Account Number : ");
                        accNo = sc.nextInt();
                        System.out.println("Enter Ammount to be withdraw : ");
                        bal = sc.nextDouble();
                        obj.withdraw(accNo,bal);
                        break;
                case 3: System.out.println("Enter Account Number : ");
                        accNo = sc.nextInt();
                        System.out.println("Enter Ammount to be deposited : ");
                        bal = sc.nextDouble();
                        obj.deposit(accNo,bal);
                        break;
                case 4: System.out.println("Enter Account Number from which amount should be transfered : ");
                        int fromAccNo = sc.nextInt();
                        System.out.println("Enter Account Number to which amount should be transfered : ");
                        int toAccNo = sc.nextInt();
                        System.out.println("Enter Ammount to be trnsfered : ");
                        bal = sc.nextDouble();
                        obj.tranfer(fromAccNo,toAccNo,bal);
                        break;
                case 5: System.out.println("Enter Account Number : ");
                        accNo = sc.nextInt();
                        obj.getAccountsDetail(accNo);
                        break;
                default: System.out.println("You Entered Wrong Choice!!!");
                         break;
            }            

            System.out.println("Do you want to continue?(Enter Y or N)");
            choice = sc.next().charAt(0);

        }while(choice=='y' || choice=='Y' );
    }
}