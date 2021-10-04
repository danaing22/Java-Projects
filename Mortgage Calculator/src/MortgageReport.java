import java.text.NumberFormat;

public class MortgageReport {
	private MortgageCalculations calculations;
	private final NumberFormat currencyInstance;
	
	public MortgageReport(MortgageCalculations calculations) {
		this.calculations = calculations;
		currencyInstance = NumberFormat.getCurrencyInstance();
	}
	
	public void printMortgage() {
		double mortgage = calculations.calculateMortgage();
		String mortgageFormatted = currencyInstance.format(mortgage);
		System.out.println("\nMORTGAGE\n-------- \nMonthly Payments: " + mortgageFormatted);
}
	
	public void printPaymentSchedule() {
		System.out.println("\nPAYMENT SCHEDULE\n----------------");
		for(double balance : calculations.getRemainingBalance()) 
			System.out.println(currencyInstance.format(balance));
		
	}
}
