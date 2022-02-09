package com.bridgelab.oop.StockAccount;

import java.util.*;

public class Account {
	static double accountBalance = 1000;

	static ArrayList<String> companies = new ArrayList<String>();
	static ArrayList<Integer> sharecounts = new ArrayList<Integer>();
	static ArrayList<Double> priceofshares = new ArrayList<Double>();

	Demat demat = new Demat();
	Calculate calculate = new Calculate();

	public void store(String name, int sharenum, double sharePrice) {
		companies.add(name);
		sharecounts.add(sharenum);
		priceofshares.add(sharePrice);
		demat.print(companies, sharecounts, priceofshares,accountBalance);
	}

	public double bal(double cost) {
		double remain = accountBalance - cost;
		if (remain > 0 ) {
			accountBalance = remain;
		}
		return remain;
	}

	public double buy(double value) {
		double balance = accountBalance - value;
		if (balance >= 0) {
			accountBalance = balance;	
		}
		return balance;	
	}

	public void sell(String name, int count, double value) {
		int ind=companies.indexOf(name);
		if (ind >= 0) {
			int cnt=sharecounts.get(ind);
			if ((cnt - count) > 0) {
				sharecounts.set(ind, (cnt-count));
				if (sharecounts.get(ind) == 0) {
					companies.remove(ind);
					sharecounts.remove(ind);
					priceofshares.remove(ind);				}
				double temp = calculate.eachStockValue(count, value);
				accountBalance = accountBalance + temp;
				demat.print(companies, sharecounts, priceofshares,accountBalance);
			}

			else {
				System.out.println("transaction denied enter valid info");
			}

		}
		else {
			System.out.println("enter valid data");
		}

	}
	public double debit(double amount) {
		double temp = accountBalance - amount;
		if (temp >= 0) {
			accountBalance = temp;
			return accountBalance;
		}
		else {
			System.out.println("transaction denied due to insufficient balance");
			return accountBalance;
		}

	}
}
