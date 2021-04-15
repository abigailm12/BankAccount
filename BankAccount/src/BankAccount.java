
public class BankAccount {

	String accountName;
	String output;
	double balance;
	double withdrawalFee;
	double annualInterestRate;
	static long accountID = 1000000;

	public BankAccount(String accountName) {
		this(accountName, 0);		
	}

	public BankAccount(String accountName, double balance) {
		this(accountName, 0, 0, 0);
		this.balance = balance;
	}

	public BankAccount(String accountName, double balance, 
			double withdrawalFee, double annualInterestRate) {
		this.accountName = truncateString(accountName);
		this.balance = balance;
		this.withdrawalFee = withdrawalFee;
		this.annualInterestRate = annualInterestRate;
		accountID++;
	}

	public String getAccountName() {
		return accountName;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithdrawalFee() {
		return withdrawalFee;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setWithdrawalFee(double withdrawalFee) {
		this.withdrawalFee = withdrawalFee;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public void deposit(double deposit) {
		balance += deposit;
	}

	public void withdraw(double withdraw) {
		balance -= withdraw + withdrawalFee;
	}

	public String toString() {
		if (isOverDrawn() == true) {
			double negativeBalance = -balance;
			output = String.format("BankAccount: name = '%s'; balance = ($%.2f)", 
					accountName, negativeBalance);
		} else {
			output = String.format("BankAccount: name = '%s'; balance = $%.2f", 
					accountName, balance);
		}
		return output;
	}

	public void addAnnualInterest() {
		if (isOverDrawn() == false) {
			balance *= (annualInterestRate / 100) + 1;
		}
	}

	public boolean isOverDrawn() {
		if (balance < 0) {
			return true;
		} else {
			return false;
		}
	}

	public static long getNextAccountID() {
		return accountID;
	}

	public long getAccountID() { 
		return accountID; 
	} 

	public String truncateString(String accountName) {
		if (accountName.length() > 20) {
			accountName = accountName.substring(0, 20);
		}
		return accountName;
	}

}

