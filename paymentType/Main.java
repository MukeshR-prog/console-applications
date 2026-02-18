import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to payroll management system!");
        
        System.out.println("Create user");  
        System.out.print("Enter user name: ");
        String name = scan.nextLine();
        User user = new User(1, name);
        System.out.println("User created with name: " + user.getName());
        System.out.println("-----------------------------------");
        System.out.println("Create account for user");
        Account account = new Account(1, user, 0.0);
        System.out.println("Account created for user: " + account.getUserName() + " with account id: " + account.getAccountId());
        System.out.println("-----------------------------------");
        int choices = 1;
        while(choices != 0){
            System.out.println("1. Add money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choices = scan.nextInt();
            if(choices == 1){
                double amount;
                System.out.print("Enter amount to add: ");
                amount = scan.nextDouble();
                account.addMoney(amount);
                System.out.println("Money added successfully. Current balance: " + account.getBalance());
            }
            else if(choices == 2){
                double amount;
                System.out.println("Available balance: " + account.getBalance());
                System.out.print("Enter amount to withdraw: ");
                amount = scan.nextDouble();
                if(account.withDraw(amount) == 1){
                    System.out.println("Money withdrawn successfully. Current balance: " + account.getBalance());
                } else {
                    System.out.println("Insufficient balance!");
                }
            }else if(choices == 3){
                System.out.println("Current balance: " + account.getBalance());
            }
            System.out.println("-----------------------------------");
        }
        scan.close();
    }
}