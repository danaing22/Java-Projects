import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
	final static byte MONTHS = 12;
	final static byte PERCENT = 100;
	
	public static void main(String[] args) {	
		double principal = readNumber("Principal: ", 1000, 1_000_000);
		double annualInterestRate = readNumber("Annual Interest Rate(Percent): ", 0, 30);
		byte loanPeriodInYears = (byte) readNumber("Loan Period(Years): ", 1, 30);
		
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format
				(calculateMortgage(principal, annualInterestRate, loanPeriodInYears));
		System.out.println("\nMORTGAGE\n-------- \nMonthly Payments: " + mortgageFormatted);
		
		System.out.println("\nPAYMENT SCHEDULE\n----------------");
		paymentSchedule(principal, annualInterestRate, loanPeriodInYears);
	}
	
	//get user input
	public static double readNumber(String prompt, double min, double max) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while(true) {
			System.out.print(prompt);
			value = scanner.nextDouble();
			if(value >= min && value <= max)
				break;
			System.out.println("Please enter a value between " + min + " and " + max + ".");
		}
		return value;
	}
	
	public static double calculateMortgage(double principal, double annualInterestRate, 
			double loanPeriodInYears){
		double monthlyInterest = annualInterestRate / MONTHS / PERCENT;
		int loanPeriod = (int) (loanPeriodInYears * MONTHS);
		
		double mortgage = principal * ((monthlyInterest * (Math.pow(1 + monthlyInterest, loanPeriod))) 
				/ ((Math.pow(1 + monthlyInterest, loanPeriod)) - 1));
		return mortgage;
	}
	
	
	public static double loanBalance(double principal, double annualInterestRate, byte loanPeriodInYears,
			int paymentsMade) {
		double monthlyInterest = annualInterestRate / MONTHS / PERCENT;
		int paymentsTotal = (loanPeriodInYears * MONTHS);
		
		double balance = principal * ((Math.pow(1 + monthlyInterest, paymentsTotal)) 
				- Math.pow(1 + monthlyInterest,  paymentsMade)) 
				/ (Math.pow(1 + monthlyInterest, paymentsTotal) - 1);
		return balance;
	}
	
	public static void paymentSchedule(double principal, double annualInterestRate, byte loanPeriodInYears) {
		for(int i = 1; i <= loanPeriodInYears * MONTHS; i++) {
			String amount = NumberFormat.getCurrencyInstance().format(loanBalance(principal,
					annualInterestRate, loanPeriodInYears, i));
			System.out.println(amount);
		}
	}

}
