package com.jsp.hibernate_case_study_1.services;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.ProductDao;
import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();
	Scanner scan=new Scanner(System.in);
	
	public void addProduct() {
		System.out.println("Enter the Product name");
		String productName=scan.next();
		System.out.println("Enter the Product price");
		int productPrice=scan.nextInt();
		System.out.println("Enter the Product quantity");
		int productQuantity=scan.nextInt();
		
		Product product=new Product();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setProductQuantity(productQuantity);
		
		String message=productDao.addProduct(product);
		System.out.println(message);
	}
	public void getAllProducts() {
		List<Product> list = productDao.getAllProducts();
		for(Product product:list) {
			System.out.println("Product [productId=" + product.getProductId()+ "]");
		}
	}
	public void updateProduct() {
		System.out.println("Enter the Product Id to update");
		int productId=scan.nextInt();
		
		Product product=productDao.getProductById(productId);
		if(product!=null) {
		    System.out.println(product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
		    System.out.println("Enter the Product name");
			String productName=scan.next();
			System.out.println("Enter the Product price");
			int productPrice=scan.nextInt();
			System.out.println("Enter the Product quantity");
			int productQuantity=scan.nextInt();
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			product.setProductQuantity(productQuantity);
			productDao.updateProduct(product);
		}
		else {
			System.out.println("Product is not found with given Id");
		}
		
	}
	
	public void getProductById() {
		System.out.println("Enter the Product Id");
		int productId=scan.nextInt();
		Product product =productDao.getProductById(productId);
		System.out.println(product);
	}
	
	public void deleteProduct() {
		System.out.println("Enter the Product Id to update");
		int productId=scan.nextInt();
		
		Product product=productDao.getProductById(productId);
		if(product!=null) {
//		    System.out.println(product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
//		    System.out.println("Enter the Product name");
//			String productName=scan.next();
//			System.out.println("Enter the Product price");
//			int productPrice=scan.nextInt();
//			System.out.println("Enter the Product quantity");
//			int productQuantity=scan.nextInt();
//			product.setProductName(productName);
//			product.setProductPrice(productPrice);
//			product.setProductQuantity(productQuantity);
			String deleteProduct = productDao.deleteProduct(product);
			System.out.println(deleteProduct);
		}
		else {
			System.out.println("Product is not found with given Id");
		}
		
	}

}
