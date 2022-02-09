package com.bridgelab.oop.StockAccount;

import java.util.*;

public class Demat {
	Scanner scanner = new Scanner(System.in);
	Scanner scanstr = new Scanner(System.in);

	String company;
	int shareCount;
	double sharePrice;
	public void buy() {

		company = compname();
		shareCount = count();
		sharePrice = shareprice();
		StockPortfolio obj = new StockPortfolio(company, shareCount, sharePrice);
		obj.storedata();
	}

	public String compname() {
		System.out.println("enter the company name");
		String company = scanstr.nextLine();
		return company;
	}


	public int count() {
		System.out.println("enter the number of share");
		int coun = scanner.nextInt();
		return coun;
	}

	public double shareprice() {
		System.out.println("enter the price of share");
		double  price = scanner.nextInt();
		return price;
	}
	public void print(ArrayList<String> companies, ArrayList<Integer> sharecounts, ArrayList<Double> priceofshares, double bal) {
		for (int i=0; i < companies.size();i++) {
			System.out.println("name of company : " + companies.get(i));
			System.out.println("number of shares : "+ sharecounts.get(i));
			System.out.println("price of share : " + priceofshares.get(i));
		}
		System.out.println("==========================");
		System.out.println("account balance is " + bal);
		System.out.println("==========================");

	}
}
