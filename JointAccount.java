import java.util.Scanner;
class Account
{
	synchronized void printTable(int n)
	{//synchronized method
		int wthd;
		int amount;
		System.out.println();
		System.out.println("The Balance total is :  "+n);
		
		System.out.println("How much do you want to withdraw?: ");
		Scanner sc=new Scanner(System.in);
		amount=sc.nextInt();
		if (amount <= n) {
				
			System.out.println("Amount after the withdraw is : " + (n
					-amount));
			amount = n - amount;
			System.out.println();
			try{
				
				Thread.sleep(400);
			}
			catch(Exception e)
			{
				
				System.out.println(e);
			
			}
				
		}else {
			 	  System.out.println("Don't have sufficient fund!");
			  }
	}
}

class Thread1 extends Thread
{
	Account x;
	Thread1(Account x)
	{
		this.x=x;
	}
	
	public void run()
	{
		x.printTable(1000);
	}

}

class Thread2 extends Thread{
	Account y;
	Thread2(Account y){
		this.y=y;
	}
	
	public void run(){
		y.printTable(1000);
	}
}

public class JointAccount {
	Scanner sc;
	public static void main(String args[]) {
		Account amount = new Account();//only one object
		Thread1 t1=new Thread1(amount);
		Thread2 t2=new Thread2(amount);
		t1.start();
		t2.start();
	}

}
