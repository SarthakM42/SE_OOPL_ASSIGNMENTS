public class BankAccount {
    String accountNumber;
    double balance;
    String name;

    BankAccount(){
      accountNumber = "1";
      balance = 0;
      name = null;
    }

    BankAccount(String name, String accNo, double bal){
      accountNumber = accNo;
      balance = bal;
      this.name = name;
    }

    public void deposite(double amount){
      balance = balance + amount;
      System.out.println(amount+" amount added to account");
    }

    public void displayBalance(){
      System.out.println("balance: $" + balance);
    }

      public void withdraw(double ammount){
        if (balance < ammount){
          System.out.println("insufficient balance");
        } else{
          balance = balance - ammount;
          System.out.println(ammount + "ammount withdraw");

        }
      }
}

class SavingAccount extends BankAccount{
  double interestRate;

  SavingAccount(){
    super();
    interestRate = 0;
  }

  SavingAccount(String name, String accNo, double bal, double interestRate){
    super(name, accNo, bal);
    this.interestRate = interestRate;
  }

  public void displayAccountDetails(){
    System.out.println("Account Number: " + accountNumber);
    displayBalance();
    System.out.println("interest Rate: " + interestRate + "%");
  }

  public static void main(String[] arg){
    SavingAccount sa = new SavingAccount();
    sa.accountNumber = "98765";
    sa.balance = 2000;
    sa.interestRate = 3.5;
    sa.withdraw(3000);
    sa.deposite(2000);
    sa.displayAccountDetails();
  }
}