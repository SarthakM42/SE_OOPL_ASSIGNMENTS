public class simpleATM1 {
    private int accNo;
    private int pin;
    private double balance;

public static int acc_cnt=0;
simpleATM1(int pin, double bal){
    acc_cnt++;
    accNo=acc_cnt;
    this.pin=pin;
    this.balance=bal;
}
public static void main(String[] args) {
    simpleATM1 obj1 = new simpleATM1(1122,12000);
    
    System.out.println("Account Number: " +obj1.getAccountNumber());
    obj1.checkBalance();
    try{ 
    obj1.withdraw(1122, 1122);
    }
    catch(SecurityException se)
    {
        System.out.println(se.getMessage());
    }
    catch(ArithmeticException ae)
    {
        System.out.println("ae.getMessage");
    }

}
public int getAccountNumber(){
    return accNo;
}
public void checkBalance() {
        System.out.println("Balance: $" + balance);
    }
public void withdraw(int enteredPin, double amount) {
 {
    if (this.pin==enteredPin) {
        
        if (balance < amount || amount < 0) {
            throw new ArithmeticException("insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println(amount + " ammount withdraw");
        }
        }
    else{
           throw new SecurityException("wrong pin");
        }

    }
}
}
