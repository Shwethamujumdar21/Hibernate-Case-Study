package com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import com.jsp.hibernate_case_study_1.dao.CartDao;
import com.jsp.hibernate_case_study_1.dao.ProductDao;
//import com.jsp.hibernate_case_study_1.entity.Product;
import com.jsp.hibernate_case_study_1.services.CartService;
import com.jsp.hibernate_case_study_1.services.ProductService;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ProductDao pDao=new ProductDao();
//    	ProductService productService=new ProductService();
//        CartDao cDao=new CartDao();
//        CartService cartService = new CartService();
    	
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	ProductService productService = context.getBean(ProductService.class);
    	CartService cartService = context.getBean(CartService.class);
    	
    	
    	
    	Scanner s=new Scanner(System.in);
    	System.out.println("Enter :\n"
        		+ " 1 to addProduct\n"
        		+ " 2 to get ProductById\n"
        		+" 3 to get all Products\n"
        		+" 4 to update Product\n"
        		+" 5 to delete Product\n"
        		+" 6 to add cart\n"
        		+" 7 to get cart\n"
        		+" 8 to delete cart\n"
        		+" 9 to getAllCart\n"
        		+" 10 to addProductToCart\n"
        		+ " 0 to Terminate the program");
    	
        int ch=s.nextInt();
        switch(ch) {
        case 1:
        	 productService.addProduct();
        	break;
        case 2:
        	 productService.getProductById();
        	break;
        case 3:
        	productService.getAllProducts();
        	break;
        case 4:
        	 productService.updateProduct();
        	break;
        case 5:
        	productService.deleteProduct();
        	break;
        case 6:
        	cartService.createCart();;
        	break;
        case 7:
        	cartService.addProductToCart();
        	break;
        case 8:
        	cartService.getAllCart();
        	break;
        case 9:
        	cartService.getCart();;
        	break;
        case 10:
        	cartService.deleteCart();
        	break;
        case 0:	
        	System.out.println("Terminate the program ");
        	break;
        	
        }
    }
}
