package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the PokerHand class and the enums
 * 
 * Rick includes all 52 cards to save you time (see end of file, after the @Test
 * methods)
 * 
 * There are also some additional test cases here. But this is in no way
 * complete. Many more are needed
 */
public class PokerHandTest {

	@Test
	public void testSuitEnum() {
		String result = "";
		for (Suit suit : Suit.values())
			result += suit + " ";
		assertEquals("CLUBS DIAMONDS HEARTS SPADES", result.trim());
	}

	@Test
	public void testRankEnum() {
		String result = "";
		for (Rank rank : Rank.values())
			result += rank + " ";
		assertEquals("DEUCE THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE", result.trim());
	}

	/*
	 * @Test(expected = DuplicateCardException.class) public void testPair2() {
	 * PokerHand a = new PokerHand(H3, CA, D4, H6, DA); a.toString(); PokerHand
	 * b = new PokerHand(H3, C5, HA, SA, C6); assertTrue(a.compareTo(b) < 0); }
	 */

	@Test
	public void testTwoPairWhenOnePairIsEqual() {
		PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
		PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testAceLowStraight() {
		PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
		PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
		boolean answer = a.compareTo(b) < 0;
		assertTrue(answer);
	}

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce,
	// Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	// TEST CARD HGH HANDS

	private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
	private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
	private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
	private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
	private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
	private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);
	private static PokerHand flush = new PokerHand(S9, SJ, SQ, SK, S2);
	private static PokerHand onePair = new PokerHand(S9, C9, SQ, SK, CA);
	private static PokerHand onePair2 = new PokerHand(H9, D9, S3, HK, C4);
	private static PokerHand onePair3 = new PokerHand(H5, D5, H3, SK, S4);
	private static PokerHand twoPair = new PokerHand(S9, C9, SQ, CK, SK);
	private static PokerHand twoPair2 = new PokerHand(H9, D9, DK, HK, C4);
	private static PokerHand twoPair3 = new PokerHand(H5, D5, S9, C9, S4);
	private static PokerHand twoPair4 = new PokerHand(H4, D4, S9, C9, S2);
	private static PokerHand threeKind = new PokerHand(S9, C9, D9, SK, CA);
	private static PokerHand fourKind = new PokerHand(S9, C9, D9, H9, CA);
	private static PokerHand straight = new PokerHand(S9, C10, SQ, SK, CA);
	private static PokerHand flushStraight = new PokerHand(S9, S10, SQ, SK, SJ);
	private static PokerHand flushStraight2 = new PokerHand(D9, D10, DQ, DK, D8);
	private static PokerHand fullHouse = new PokerHand(C10, S10, H10, DJ, SJ);

	private static PokerHand highCard1 = new PokerHand(C10, SJ, H2, D7, S9);
	private static PokerHand highCard2 = new PokerHand(C4, D9, S7, H10, DJ);
	private static PokerHand highCard3 = new PokerHand(C3, D9, S7, H10, DJ);
	private static PokerHand highCard4 = new PokerHand(C4, D8, S7, H10, DJ);
	private static PokerHand highCard5 = new PokerHand(C4, D9, S8, H10, DJ);

	private static PokerHand sameHand1 = new PokerHand(C2, S4, H5, D8, S9);
	private static PokerHand sameHand2 = new PokerHand(D2, D4, S5, H8, D9);

	@Test
	public void testNothing0() {
		assertTrue(nothing73.compareTo(nothing72) > 0);
	}

	@Test
	public void testNothing1() {
		assertTrue(nothingJ.compareTo(nothing73) > 0);
	}

	@Test
	public void testNothing2() {
		assertTrue(nothingK8.compareTo(nothingJ) > 0);
	}

	@Test
	public void testNothing3() {
		assertTrue(nothingK9.compareTo(nothingK8) > 0);
	}

	@Test
	public void testNothing4() {
		assertTrue(nothingA.compareTo(nothingK8) > 0);
	}

	// Many more tests needed

	@Test
	public void test1() {
		assertTrue(flushStraight.compareTo(nothingK8) > 0);
		assertTrue(straight.compareTo(nothingK8) > 0);
		assertTrue(flush.compareTo(nothingK8) > 0);
		assertTrue(threeKind.compareTo(nothingK8) > 0);
		assertTrue(fourKind.compareTo(nothingK8) > 0);
		assertTrue(fullHouse.compareTo(nothingK8) > 0);
		assertTrue(flushStraight.compareTo(flushStraight2) > 0);
		assertTrue(sameHand1.compareTo(sameHand2) == 0);
		assertTrue(fullHouse.compareTo(onePair) > 0);
		assertTrue(onePair.compareTo(highCard2) > 0);
		assertTrue(onePair.compareTo(onePair2) > 0);
		assertTrue(onePair2.compareTo(onePair3) > 0);
		assertTrue(twoPair.compareTo(twoPair2) > 0);
		assertTrue(twoPair2.compareTo(twoPair3) > 0);
		assertEquals("3♠ 4♣ 9♥ 9♦ K♥", onePair2.toString());
		assertTrue(highCard2.compareTo(highCard3) > 0);
		assertTrue(highCard2.compareTo(highCard4) > 0);
		assertTrue(highCard2.compareTo(highCard5) < 0);
		assertTrue(twoPair4.compareTo(twoPair3) < 0);
	}
	
	// These tests were added after removing DuplicateCardException
	  // because things change when cards can be shared. This assumes
	  // there are no more DuplicateCardException checks. Notice these 
	  // output incorrectly list ties for full house. Only 2 should tie
	  /*
	  Winning hands (tie) 
	  3♣ 3♦ A♦ A♣ A♥    FULL_HOUSE Player 8 $55.0
	  6♠ 6♦ A♦ A♣ A♥    FULL_HOUSE Player 7 $109.0
	  6♠ 6♥ A♦ A♣ A♥    FULL_HOUSE Player 4 $100.0
	  3♣ 3♥ A♦ A♣ A♥    FULL_HOUSE Player 2 $154.0
	  Play another game? <y OR n> 
	  */
	
	  @Test
	  public void testFullHouseHands() {
	    PokerHand a = new PokerHand(S6, D6, DA, CA, HA);  // Both hands can have the same 3 Aces
	    PokerHand b = new PokerHand(S3, D3, DA, CA, HA);
	    assertTrue(a.compareTo(b) > 0);
	    assertTrue(b.compareTo(a) < 0);
	  }
	 
	  @Test
	  public void testFullHouseHands2() {
	    PokerHand a = new PokerHand(S6, D6, DA, CA, HA);
	    PokerHand b = new PokerHand(C6, H6, DA, CA, HA);
	    assertTrue(a.compareTo(b) == 0);
	    assertTrue(b.compareTo(a) == 0);
	  }
	  
	  @Test
	  public void testFullHouseHands3() {
	    PokerHand a = new PokerHand(S6, D6, DA, CA, HA);
	    PokerHand b = new PokerHand(C7, H7, DA, CA, HA);
	    assertTrue(a.compareTo(b) < 0);
	    assertTrue(b.compareTo(a)> 0);
	  }
	 
	  @Test
	  public void testThreeOfAKind() {
	    PokerHand a = new PokerHand(S6, D7, DA, CA, HA);
	    PokerHand b = new PokerHand(C5, H6, DA, CA, HA);
	    assertTrue(a.compareTo(b) > 0);
	    assertTrue(b.compareTo(a) <  0);
	  }
	  
	  @Test
	  public void testThreeOfAKind3() {
	    PokerHand a = new PokerHand(S7, D6, DA, CA, HA);
	    PokerHand b = new PokerHand(C7, H6, DA, CA, HA);
	    assertTrue(a.compareTo(b) == 0);
	    assertTrue(b.compareTo(a) ==  0);
	  }
	  
	  @Test
	  public void testFourOfAKind() {
	    PokerHand a = new PokerHand(S7, CA, DA, HA, SA);
	    PokerHand b = new PokerHand(D7, CA, DA, HA, SA);
	    assertTrue(a.compareTo(b) == 0);
	    assertTrue(b.compareTo(a) ==  0);
	  }
	  
	  @Test
	  public void testFourOfAKind4() {
	    PokerHand a = new PokerHand(S8, CA, DA, HA, SA);
	    PokerHand b = new PokerHand(D7, CA, DA, HA, SA);
	    assertTrue(a.compareTo(b) > 0);
	    assertTrue(b.compareTo(a)<   0);
	  }

}