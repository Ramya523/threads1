import java.util.Scanner;

public class WaitNotify implements Runnable{
	static float balance;
	
	public float getBalance() {
		return balance;
	}

	public  void setBalance(float balance) {
		this.balance = balance;
	}

	  void deposit()
	{
	System.out.println("enter amount to deposit");
	Scanner sc= new Scanner(System.in);
	float amount=sc.nextFloat();
	
	balance=balance+amount;
	System.out.println("balance after deposit : "+balance);
	//setBalance(balance)	;
	notify();
	
	}
	
	
	public void run() {
		 
		
	
		
	}
	
	void  withdraw() 
	{
		System.out.println("enter amount to withdraw");
		Scanner sc= new Scanner(System.in);
		float amount=sc.nextFloat();
		if(amount<=balance)
		{
		balance=balance-amount;
		System.out.println("your balance is: "+balance);
		}
		else
		{
			System.out.println("insufficient balance");
		}
	//	setBalance(balance);
		try {
			wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
	public static void main(String[] args) {
	
		WaitNotify customer1=new WaitNotify(); 
		Thread thread=new Thread(customer1);
		thread.start();
		customer1.setBalance(1000);
		customer1.withdraw();
		customer1.deposit();
	//	System.out.println(System.currentTimeMillis());
		
		
		WaitNotify customer2=new WaitNotify(); 
		Thread thread1=new Thread(customer2);
		thread1.start();
		customer1.setBalance(1000);
		customer1.withdraw();
		customer2.deposit();
		
		System.out.println(System.currentTimeMillis());
		
		


	}

	

}
