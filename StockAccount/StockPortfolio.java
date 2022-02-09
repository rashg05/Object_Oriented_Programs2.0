package com.bridgelab.oop.StockAccount;

public class StockPortfolio {
	String stockName;
	int numberOfShare;
	double sharePrice;
	double totalStockValue = 0;
	static double balance;
	double value ;
	static double investedAmount;

	Account account = new Account();
	Calculate calculate = new Calculate();

	public StockPortfolio(String stockName, int numberOfShare, double sharePrice) {
		this.stockName = stockName;
		this.numberOfShare = numberOfShare;
		this.sharePrice = sharePrice;	
	}

	public void storedata() {
		totalStockValue = calculate.eachStockValue(numberOfShare, sharePrice);
		balance = account.bal(totalStockValue);
		account.store(stockName, numberOfShare, sharePrice);
	}

}
