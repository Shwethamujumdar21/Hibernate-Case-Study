package com.jsp.hibernate_case_study_1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_1.entity.Cart;
import com.jsp.hibernate_case_study_1.entity.Product;



public class CartDao {
	
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sf=cfg.buildSessionFactory();


	
	public String addCart(Cart cart) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		
		session.save(cart);
		

		
		trans.commit();
		session.close();
		
		return "Cart added successfully";
		
	}
	
	public Cart getCartById(int cid) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Cart cart = session.get(Cart.class, cid);
		System.out.println(cart);
		
		trans.commit();
		session.close();
		return cart;
	}
	
	
	public List<Cart> getAllCart(){
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Query query = session.createQuery("from Cart");
		List<Cart> list = query.list();
		trans.commit();
		session.close();
		return list;
	}
	
	
	public String CartDelete(Cart cart) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		session.delete(cart);
		trans.commit();
		session.close();
		return "Cart Successfully deleted";
	}
	
	public String addProductToCart(Product product,Cart cart) {
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		cart.getpList().add(product);
		session.update(cart);
		
		trans.commit();
		session.close();
		return "Product added to Cart Successfully ";
	}
	
	
}
