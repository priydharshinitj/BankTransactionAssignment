package com.hcl.bankdetails;

public class BankAccount {
	private String name,gender,bankName,cardNumber;
	Integer age,creditLimit;
	BankAccount(){}
	public BankAccount(String name,Integer age, String gender, String bankName, String cardNumber,Integer creditLimit) {
		super();
		this.name = name;
		this.gender = gender;
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.age = age;
		this.creditLimit = creditLimit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}
	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", gender=" + gender + ", bankName=" + bankName + ", cardNumber="
				+ cardNumber + ", age=" + age + ", creditLimit=" + creditLimit + "]";
	}
	
	
}
