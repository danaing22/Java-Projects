
/*
 * Class responsible for mortgage calculations
 */
public class MortgageCalculations {
	// add class variables
	private final static byte MONTHS = 12;
	private final static byte PERCENT = 100; 
	
	//instance variables
	private double principal;
	private double annualInterestRate;
	private byte loanPeriodYears;
	
	public MortgageCalculations(Double principal, double annualInterestRate, byte loanPeriodYears) {
		this.principal = principal;
		this.annualInterestRate = annualInterestRate;
		this.loanPeriodYears = loanPeriodYears;
		
	}
	
	public double calculateMortgage(){
		double monthlyInterest = getMonthlyInterest();
		int loanPeriodMonths = getLoanPeriodMonths();
		double mortgage = principal * ((monthlyInterest * (Math.pow(1 + monthlyInterest, loanPeriodMonths))) 
				/ ((Math.pow(1 + monthlyInterest, loanPeriodMonths)) - 1));
		return mortgage;
	}
	
	public double loanBalance(int paymentsMade) {
		double monthlyInterest = getMonthlyInterest();
		int loanPeriodMonths = getLoanPeriodMonths();
		double balance = principal * ((Math.pow(1 + monthlyInterest, loanPeriodMonths)) 
				- Math.pow(1 + monthlyInterest,  paymentsMade)) 
				/ (Math.pow(1 + monthlyInterest, loanPeriodMonths) - 1);
		return balance;
	}
	
	public double[] getRemainingBalance() {
		double[] balances = new double[getLoanPeriodMonths()];
		for(int i = 1; i <= balances.length; i++) 
			balances[i - 1] = loanBalance(i);
		
		return balances;
	}
	
	private int getLoanPeriodMonths() {
		return loanPeriodYears * MONTHS;
	}
	
	private double getMonthlyInterest(){
		return annualInterestRate / MONTHS / PERCENT;
	}
}
