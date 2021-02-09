package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{ //herda os atributos e métodos de Product

	private Date manufactureDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//Construtores
	public UsedProduct() {
		
	}
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	//Getters e Setters
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override //sobrepõe a função priceTag da super classe Product
	public String priceTag() {
		return name + " $ " + price + "(Manufacture Date: " + sdf.format(manufactureDate) + ")";
	}
	
}
