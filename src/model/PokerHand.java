/*
 * Name: Braxton Lazar
 * Class: CSC 335 Summer 2017
 * Description: Takes two ArrayLists of cards and compares the two using standard rules of poker representing a Hand in the game
 */

package model;

import java.util.ArrayList;
import java.util.Collections;

import model.DuplicateCardException;
import model.Rank;

public class PokerHand {

	private ArrayList<Card> cards;
	private boolean hasOnePair = false;
	private boolean hasTwoPair = false;
	private boolean hasThreeOfAKind = false;
	private boolean hasFourOfAKind = false;
	private boolean hasFlush = false;
	private boolean hasStraight = false;
	private Card highCard = new Card(null, null);
	private int handRank = 0;

	// Construct one PokerHand
	// Precondition: All five cards are unique
	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		cards.add(c1);
		if (cards.contains(c2))
			throw new DuplicateCardException();
		cards.add(c2);
		if (cards.contains(c3))
			throw new DuplicateCardException();
		cards.add(c3);
		if (cards.contains(c4))
			throw new DuplicateCardException();
		cards.add(c4);
		if (cards.contains(c5))
			throw new DuplicateCardException();
		cards.add(c5);
		Collections.sort(cards);
		this.highCard = getHighCard();
	}

	// Get the rank of any of the five cards
	// Precondition: index >= 0 and index <=4
	private int getValue(int index) {
		return cards.get(index).getValue();
	}

	public Card getHighCard() {
		Card highCard = cards.get(0);
		for (int i = 0; i < cards.size(); i++)
			if (cards.get(i).compareTo(highCard) > 0 && cards.get(i).getValue() != highCard.getValue())
				highCard = cards.get(i);
		return highCard;
	}

	public boolean hasOnePair() {
		int numPairs = 0;
		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++)
				if (cards.get(i).getRank() == cards.get(j).getRank())
					numPairs++;
		}
		return (numPairs == 1);
	}

	// Return true if there are exactly two pairs in this hand
	// Precondition: cards is sorted.
	public boolean hasTwoPair() {
		int numPairs = 0;
		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++)
				if (cards.get(i).getRank() == cards.get(j).getRank())
					numPairs++;
		}
		return (numPairs == 2);
	}

	public boolean hasThreeOfAKind() {
		int numVals = 0;
		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				if (cards.get(i).getRank() == cards.get(j).getRank())
					numVals++;
			}
			if (numVals == 3)
				return true;
		}
		return false;
	}

	public boolean hasFourOfAKind() {
		int numVals = 0;
		for (int i = 0; i < cards.size(); i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				if (cards.get(i).getRank() == cards.get(j).getRank())
					numVals++;
			}
			if (numVals == 4)
				return true;
		}
		return false;
	}

	public boolean hasFlush() {
		for (int i = 1; i < cards.size(); i++) {
			if (cards.get(0).getSuit() != cards.get(i).getSuit())
				return false;
		}
		return true;
	}

	public boolean hasStraight() {
		if (getHighCard().getRank() == Rank.ACE) {
			for (int i = 1; i < cards.size() - 1; i++) {
				if (cards.get(0).getValue() + i != cards.get(i).getValue())
					return false;
			}
			if (cards.get(0).getRank() != Rank.DEUCE || cards.get(0).getRank() != Rank.TEN)
				return false;
		} else {
			for (int i = 1; i < cards.size(); i++) {
				if (cards.get(0).getValue() + i != cards.get(i).getValue())
					return false;
			}
		}
		return true;
	}

	// Return the value of the lower pair in a two pair hand (or the pair in a
	// Pair hand).
	// Precondition: ph is a valid PokerHand that is sorted
	private int getLowPair(PokerHand ph) {
		int lowVal = Integer.MAX_VALUE;
		for (int i = 0; i < cards.size(); i++) {
			if (ph.getValue(i) < lowVal) {
				lowVal = ph.getValue(i);
			}
		}
		return lowVal;
	}

	// Return the value of the larger pair in a two pair hand (or the pair in a
	// Pair hand).
	// Precondition: ph is a valid PokerHand that is sorted
	private int getHighPair(PokerHand ph) {
		int highVal = Integer.MIN_VALUE;
		for (int i = 0; i < cards.size() - 1; i++) {
			if (ph.getValue(i + 1) == ph.getValue(i) && ph.getValue(i) > highVal) {
				highVal = ph.getValue(i);
			}
		}
		return highVal;
	}

	public int getHandRank() {
		if (hasStraight && hasFlush)
			return 8;
		if (hasFourOfAKind)
			return 7;
		if (hasThreeOfAKind && hasOnePair)
			return 6;
		if (hasFlush)
			return 5;
		if (hasStraight)
			return 4;
		if (hasThreeOfAKind)
			return 3;
		if (hasTwoPair)
			return 2;
		if (hasOnePair)
			return 1;
		else
			return 0;
	}

	// Provide a textual version of this PokerHand
	public String toString() {
		String result = "";
		result += cards.get(0) + " ";
		result += cards.get(1) + " ";
		result += cards.get(2) + " ";
		result += cards.get(3) + " ";
		result += cards.get(4);
		return result;
	}

	public int compareTo(PokerHand ph) {
		this.hasOnePair = hasOnePair();
		this.hasTwoPair = hasTwoPair();
		this.hasThreeOfAKind = hasThreeOfAKind();
		this.hasFourOfAKind = hasFourOfAKind();
		this.hasFlush = hasFlush();
		this.hasStraight = hasStraight();

		ph.hasOnePair = ph.hasOnePair();
		ph.hasTwoPair = ph.hasTwoPair();
		ph.hasThreeOfAKind = ph.hasThreeOfAKind();
		ph.hasFourOfAKind = ph.hasFourOfAKind();
		ph.hasFlush = ph.hasFlush();
		ph.hasStraight = ph.hasStraight();

		this.handRank = getHandRank();
		ph.handRank = ph.getHandRank();

		return compareHands(ph);
	}

	public int compareHands(PokerHand ph) {
		if (this.handRank - ph.handRank != 0)
			return this.handRank - ph.handRank;
		else if (ph.handRank == 1) {
			if (getHighPair(this) == getHighPair(ph))
				return this.highCard.getValue() - ph.highCard.getValue();
			else
				return getHighPair(this) - getHighPair(ph);
		} else if (ph.handRank == 2) {
			if (getHighPair(this) == getHighPair(ph) && getLowPair(this) == getLowPair(ph))
				return this.highCard.getValue() - ph.highCard.getValue();
			else if (getHighPair(this) == getHighPair(ph))
				return getLowPair(this) - getLowPair(ph);
			else
				return getHighPair(this) - getHighPair(ph);
		} else if (ph.handRank == 3 || ph.handRank == 6 || ph.handRank == 7) {
			return this.cards.get(3).getValue() - ph.cards.get(3).getValue();
		} else if (ph.handRank == 4 || ph.handRank == 8) {
			return this.cards.get(4).getValue() - ph.cards.get(4).getValue();
		} else if (ph.handRank == 5 || ph.handRank == 0) {
			if (this.cards.get(4).getValue() == ph.cards.get(4).getValue())
				if (this.cards.get(3).getValue() == ph.cards.get(3).getValue())
					if (this.cards.get(2).getValue() == ph.cards.get(2).getValue())
						if (this.cards.get(1).getValue() == ph.cards.get(1).getValue())
							if (this.cards.get(0).getValue() == ph.cards.get(0).getValue())
								return 0;
							else
								return this.cards.get(0).getValue() - ph.cards.get(0).getValue();
						else
							return this.cards.get(1).getValue() - ph.cards.get(1).getValue();
					else
						return this.cards.get(2).getValue() - ph.cards.get(2).getValue();
				else
					return this.cards.get(3).getValue() - ph.cards.get(3).getValue();
			else
				return this.cards.get(4).getValue() - ph.cards.get(4).getValue();
		} else
			return 0;
	}
}
