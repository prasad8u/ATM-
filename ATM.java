import java.util.Scanner;

public class ATM{
		
		public static int takeIntegerInput(int limit){
			int input=0;
			boolean flag=false;
			
			while(!flag){
				try{
					Scanner sc=new Scanner(System.in);
					input=sc.nextInt();
					flag=true;
					
					if(flag && input >limit || input < 1){
						System.out.println(limit);
						flag=false;
					}
				}
				catch(Exception e){
					System.out.println("enter integer value");
					flag=false;
				}
			}
			return input;
		}
		
		public static void main(String args[]){
			System.out.println("welcome to ATM");
			System.out.println("1.register \n 2.exit");
			System.out.println("enetr your choice");
			int choice=takeIntegerInput(2);
			
			if(choice==1){
				BankAccount b=new BankAccount();
				b.register();
				while(true){
					System.out.println("1.login 2.exit");
					System.out.println("enter your choioce");
					int ch=takeIntegerInput(1);
					if(ch==1){
						if(b.login()){
							System.out.println("welcome back"+b.name);
							boolean isFinished=false;
							while(!isFinished){
								System.out.println("1.withdraw 2.deposit 3.transfer 4.check balance 5.Exit");
								System.out.println("enter your choice");
								int c=takeIntegerInput(5);
								switch(c){
									case 1:
										b.withdraw();
										break;
									case 2:
										b.deposit();
										break;
									
									case 4:
										b.checkBalance();
										break;
									case 5:
										isFinished=true;
										break;
								}
							}
						}
					}
					else{
						System.exit(0);
					}
				}
			}else{
				System.exit(0);
			}
		}
	}