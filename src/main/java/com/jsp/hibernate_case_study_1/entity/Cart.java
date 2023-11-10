package com.jsp.hibernate_case_study_1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	private int cartId;
	@OneToMany
	private List<Product> pList=new ArrayList<Product>();
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Product> getpList() {
		return pList;
	}
	public void setpList(List<Product> pList) {
		this.pList = pList;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", pList=" + pList + "]";
	}
	
	

}
