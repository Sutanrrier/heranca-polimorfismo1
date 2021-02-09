package entities;

public class ImportedProduct extends Product { //herda os atributos e m�todos de Product

	private Double customsFee;
	//Construtores
	public ImportedProduct() {
		
	}
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
		
	}
	//Getters e Setters
	public Double getCustomsFee() {
		return customsFee;
	}
	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	public Double totalPrice() {
		return price + customsFee;
	}
	
	@Override //sobrep�e a fun��o priceTag da super classe Product
	public String priceTag() {
		return name + " $ " + totalPrice() + "(Customs fee: $ " + customsFee + ")";
	}
	
}
