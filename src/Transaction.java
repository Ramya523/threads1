import java.util.Scanner;

public class Transaction implements Runnable{
	static float balance;
	
	public float getBalance() {
		return balance;
	}

	public  void setBalance(float balance) {
		this.balance = balance;
	}

	synchronized public  void deposit()
	{
	System.out.println("enter amount to deposit");
	Scanner sc= new Scanner(System.in);
	float amount=sc.nextFloat();
	balance=balance+amount;
	System.out.println("balance after deposit : "+balance);
	//setBalance(balance)	;
	
	}
	
	
	public void run() {
		
		
	}
	
	synchronized public  void withdraw() 
	{
		System.out.println("enter amount to withdraw");
		Scanner sc= new Scanner(System.in);
		float amount=sc.nextFloat();
		balance=balance-amount;
		System.out.println("your balance is: "+balance);
	//	setBalance(balance);
		
	}
	
	

	
	public static void main(String[] args) {
	
		Transaction threadspeed=new Transaction(); 
		
		//synchronize(threadspeed);
		
		
			
		
		
		Thread thread=new Thread(threadspeed);
		thread.start();
		threadspeed.setBalance(1000);
		threadspeed.withdraw();
		System.out.println(System.currentTimeMillis());
		
		Transaction threadspeed1=new Transaction(); 
		Thread thread1=new Thread(threadspeed1);
		thread1.start();
		threadspeed1.deposit();
		
		System.out.println(System.currentTimeMillis());
		


	}

	

}
