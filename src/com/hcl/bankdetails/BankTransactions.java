package com.hcl.bankdetails;
import java.text.SimpleDateFormat;
import java.util.*;
public class BankTransactions {
	private String cardnumber;
	private Date transactiondate;
	private Integer amount;
	BankTransactions(){}
	public BankTransactions(String cardnumber, Date transactiondate, Integer amount) {
		super();
		this.cardnumber = cardnumber;
		this.transactiondate = transactiondate;
		this.amount = amount;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "BankTransactions [cardnumber=" + cardnumber + ", transactiondate=" + sdf.format(transactiondate) + ", amount="
				+ amount + "]";
	}
	
}
