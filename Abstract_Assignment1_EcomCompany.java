package dxc;

abstract class Payment
{
	private int CustomerId;
	protected String paymentId;
	protected double ServiceTaxPercentage;
	public Payment(int customerId) 
	{
		super();
		CustomerId = customerId;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public double getServiceTaxPercentage() {
		return ServiceTaxPercentage;
	}
	public void setServiceTaxPercentage(double serviceTaxPercentage) {
		ServiceTaxPercentage = serviceTaxPercentage;
	}
	abstract public double payBill(double amount); 
	
	
}
class DebitCardPayment extends Payment
{
	
	static int counter;
	private double discountPercentage;
	public DebitCardPayment(int customerId) 
	{
		super(customerId);
		
	
			counter=1000;

		this.paymentId="D"+ ++counter;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		DebitCardPayment.counter = counter;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public double payBill(double amount)
	{
		if(amount<=500)
		{
			this.ServiceTaxPercentage=2.5;
		}
		else if(amount>500 && amount<=1000)
		{
			this.ServiceTaxPercentage=4;
		}
		else if(amount>1000)
		{
			this.ServiceTaxPercentage=5;
		}
		double serviceTaxAmount=amount*(this.ServiceTaxPercentage/100);
		 
		if(amount<=500)
		{
			this.discountPercentage=1;
		}
		else if(amount>500 && amount<=1000)
		{
			this.discountPercentage=2;
		}
		else if(amount>1000)
		{
			this.discountPercentage=3;
		}
		double discount=amount*(this.discountPercentage/100);
		double finalAmount=amount+serviceTaxAmount+discount;
		return finalAmount;
		
		
		
	}
}
class CreditCardPayment extends Payment
{
	
	private static int counter;
	public CreditCardPayment(int customerId)
	{
		super(customerId);
		
			counter=1000;
		
		this.paymentId="C"+ ++counter;
		
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		CreditCardPayment.counter = counter;
	}
	public double payBill(double amount)
	{
		if(amount<=500)
		{
			this.ServiceTaxPercentage=3;
		}
		else if(amount>500 && amount<=1000)
		{
			this.ServiceTaxPercentage=5;
		}
		else if(amount>1000)
		{
			this.ServiceTaxPercentage=6;
		}
		double serviceTaxAmount=amount*(this.ServiceTaxPercentage/100);
		 
		
		double finalAmount=amount+serviceTaxAmount;
		return finalAmount;
		
		
		
	}


	
}

public class Abstract_Assignment1_EcomCompany 
{

	public static void main(String[] args) 
	{
		DebitCardPayment debitCardPayment = new DebitCardPayment(101);
		 double billAmount=Math.round(debitCardPayment.payBill(500)*100)/100.0;
		System.out.println("Customer Id: " + debitCardPayment.getCustomerId());
		System.out.println("Payment Id: " + debitCardPayment.getPaymentId());
		System.out.println("Service tax percentage: " + 
		debitCardPayment.getServiceTaxPercentage());
		System.out.println("Discount percentage: " + 
		debitCardPayment.getDiscountPercentage());
		System.out.println("Total bill amount: " + billAmount);
		CreditCardPayment creditCardPayment = new CreditCardPayment(102);
		 billAmount=Math.round(creditCardPayment.payBill(1000)*100)/100.0;
		System.out.println("Customer Id: " + creditCardPayment.getCustomerId());
		System.out.println("Payment Id: " + creditCardPayment.getPaymentId());
		System.out.println("Service tax percentage: " + 
		creditCardPayment.getServiceTaxPercentage());
		System.out.println("Total bill amount: " + billAmount);

	}

}
