package edu.gxwangdi.design.patterns;

/*
 * A Builder pattern is somewhat like an Abstract Factory pattern in that both
 * return classes made up of a number of methods and objects. The main
 * difference is that while the Abstract Factory returns a family of related
 * classes, the Builder constructs a complex object step by step depending on the
 * data presented to it.
 * 
 * Suppose we don`t want just a computing algorithm, but a whole
 * different user interface depending on the data we need to display.
 * 
 * The Builder Pattern assembles a number of objects, such as display widgets, 
 * in various ways depending on the data. Furthermore, since Java is one of the few
 * languages where you can cleanly separate the data from the display methods
 * into simple objects, Java is the ideal language to implement Builder patterns.
 * 
 * */

/* Product and Part are struct like class.
 * They could be interface, it depends.*/
class Product{
	Part partA=null;
	Part partB=null;
	Part partC=null;
}


class Part{
	String partName= null;
	
	public Part(String s) {
		partName = s;               
	}
	
	public Part() {
		partName = new String();
	}
}

interface iBuilder{
	/* build partA, partB, partC*/
	void buildPartA();
	void buildPartB();
	void buildPartC();
	
	/* return the result of the construction.*/
	Product getResult();
}

class Director{
	private iBuilder builder;
	
	public Director(iBuilder builder){
		this.builder = builder;
	}
	
	/* The real process building Parts of the product
	 * and build the product */
	public void construct(){
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
	}
	
	public Product deliverProduct() {
		return builder.getResult();
	}
}

class ConcreteBuilder implements iBuilder{
	private Product product = null;
	
	public void buildPartA(){
		System.out.println("Detailed process to build part A");
		if (product == null)
			product = new Product();
		product.partA = new Part("PartA");
	};
	
	public void buildPartB(){
		System.out.println("Detailed process to build part B");
		if (product == null)
			product = new Product();
		product.partB = new Part("PartB");
	};
	
	public void buildPartC(){
		System.out.println("Detailed process to build part C");
		if (product == null)
			product = new Product();
		product.partC = new Part("PartC");
	};
	
	public Product getResult(){
		///return what is built in construct process.
		System.out.println("Product is not built here," +
				" just return an existing product constitute of Part ABC.");
		return product;
	};
}//end of ConcreteBuilder class

public class Builder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Director director = new Director(new ConcreteBuilder());
		director.construct();
		Product product = director.deliverProduct();
		
		System.out.println("part a:" + product.partA + " part b:" + product.partB + "part c:" + product.partC);
	}
}//end of Builder class






