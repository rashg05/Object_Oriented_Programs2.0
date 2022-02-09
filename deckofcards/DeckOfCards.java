package com.bridgelab.oop.deckofcards;

public class DeckOfCards {
	String [] cardType = { "Clubs", "Diamonds", "Hearts", "Spades" };
	String [] cardNumbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	String []cards = new String [52];
	String [][]playerCards = new String [4][9];
	public void getCards() {
		int  j , i, k = 0;
		for (i = 0; i < cardType.length; i++) {
			for (j = 0; j < cardNumbers.length; j++) {
				cards[k] = cardType[i] + " " + cardNumbers[j];
				k++;
			}
		}
	}

	public String[] shuffleArray(){
		String temp = "";
		for (String card : cards) {

			int random = (int)( Math.random() * 10);
			temp=cards[random];
			cards[random]=card;
			card=temp;
		}
		return cards;
	}

	public void distributeCard(String[] cards) {
		int i,j,k=0;
		for(i=0;i<4;i++) {
			System.out.println("Player"+(i+1)+" :-");
			for(j=0;j<9;j++) {
				playerCards[i][j]= cards[k];
				System.out.println(playerCards[i][j]);
				k++;
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		DeckOfCards dc = new DeckOfCards ();
		dc.getCards();
		String []cards = dc.shuffleArray();
		dc.distributeCard(cards);
	}
}
