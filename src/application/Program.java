package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> product = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt(); //quantidade de produtos
		
		for(int i=1; i<=n;i++) { //Adiciona os produtos a lista
			System.out.println("Product #" + i + " Data: ");
			System.out.print("Common, used or imported (c/u/i): ");
			char type = sc.next().charAt(0);
			
			if(type == 'c') {
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				Product prod = new Product(name, price);
				product.add(prod);
			}
			if(type == 'u') {
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				sc.nextLine(); //limpar buffer
				Date date = sdf.parse(sc.nextLine());
				Product prod = new UsedProduct(name, price, date);
				product.add(prod);
			}
			if(type == 'i') {
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				Double fee = sc.nextDouble();
				Product prod = new ImportedProduct(name, price, fee);
				product.add(prod);
			}
		}
		//Mostrar as Price Tags dos produtos
		System.out.println("\nPRICE TAGS");
		for(Product c : product) {
			System.out.println(c.priceTag());
		}
		sc.close();
	}
}
