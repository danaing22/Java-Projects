
public class Main {
	
	public static void main(String[] args) {	
		double principal = Console.readNumber("Principal: ", 1000, 1_000_000);
		double annualInterestRate = Console.readNumber("Annual Interest Rate(Percent): ", 0, 30);
		byte loanPeriodInYears = (byte) Console.readNumber("Loan Period(Years): ", 1, 30);
		
		var mortgage = new MortgageCalculations(principal, annualInterestRate, loanPeriodInYears);
		
		var report = new MortgageReport(mortgage);
		report.printMortgage();
		report.printPaymentSchedule();
	}
}