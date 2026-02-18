public class Account {
    private int accountId;
    private double balance;
    private User user;
    Account(int accountId, User user, double balance){
        this.accountId = accountId;
        this.user = user;
        this.balance = balance;
    }
    
   public int getAccountId(){
        return accountId;
    }
    public String getUserName(){
        return user.getName();
    }

    public double getBalance(){
        return balance;
    }

    public int addMoney(double amount){
        balance += amount;
        return 1;
    }
    public int withDraw(double amount){
        if(balance >= amount){
            balance -=amount;
            return 1;
        }
        return 0;
    }

}
