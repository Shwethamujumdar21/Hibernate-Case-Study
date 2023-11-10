package com.jsp.hibernate_case_study_1.services;

import java.util.List;
import java.util.Scanner;


import com.jsp.hibernate_case_study_1.dao.CartDao;
import com.jsp.hibernate_case_study_1.dao.ProductDao;
import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;

public class CartService {
	
	CartDao cartdao = new CartDao();
	Scanner sc = new Scanner(System.in);
	
	public void createCart() {
		Cart cart = new Cart();
		String message = cartdao.addCart( cart);
		System.out.println(message);
	}
	
	public void getCart() {
		System.out.println("Enter the Cart Id");
		int cid = sc.nextInt();
		Cart cart = cartdao.getCartById(cid);
//		Product product = new Product();
		System.out.println("Cart [cartId=" +cart.getCartId() + "]");
	}
	
	public void deleteCart() {
		System.out.println("Enter the Cart Id to delete");
		int cid = sc.nextInt();
		
		Cart cart = cartdao.getCartById(cid);
		if(cart!=null) {
			String message = cartdao.CartDelete(cart);
			System.out.println(message);
		}
		else {
			System.out.println("Invalid Cart id");
		}
	}
	
	public void getAllCart() {
		List<Cart> list = cartdao.getAllCart();
		for(Cart cart:list) {
			System.out.println("Cart [cartId=" + cart.getCartId() + "]");
		}
	}
	public void addProductToCart() {
		System.out.println("Enter the Cart Id");
		int cid = sc.nextInt();
		System.out.println("Enter the product Id");
		int pid = sc.nextInt();
		
		Product product = new ProductDao().getProductById(cid);
		Cart cart = cartdao.getCartById(cid);
		if(product!=null&&cart!=null) {
			String message = cartdao.addProductToCart(product, cart);
			System.out.println(message);
		}
		else {
			System.out.println("Invalid id");
		}
		
	}

}
