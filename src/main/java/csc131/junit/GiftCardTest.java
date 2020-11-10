package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest
{
	@Test
	public void getIssuingStore()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()",
		issuingStore, card.getIssuingStore());
		
	}
	
	
	@Test
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String result;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		result = "Remaining Balance: " + String.format("%6.2f",
                Math.abs(balance-50));
		
		assertEquals("deduct()", result, card.deduct(50));
	}
	
	@Test
	public void deductWithNegativeAndBalanceNegative()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String result;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		result = "Invalid Transaction";
		
		assertEquals("deductNegative()", result, card.deduct(-50));
		card.deduct(200);
		assertEquals("deductBalanceNegative()", 0.0, card.getBalance(), 0.01 );
		
	}
	
	@Test
	public void constructor_IncorrectBalance_Low()
	{
		assertThrows(IllegalArgumentException.class, ()->{new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class, ()->{new GiftCard(-1,100);});
	}
	
	@Test
	public void constructor_IncorrectID_High()
	{
		assertThrows(IllegalArgumentException.class, ()->{new GiftCard(10000,100);});
	}
}
