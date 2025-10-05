package edu.gxwangdi.design.patterns;

/**
 * 1. The Bridge pattern is intended to keep the interface to your client
program constant while allowing you to change the actual kind of class
you display or use. This can prevent you from recompiling a complicated
set of user interface modules, and only require that you recompile the
bridge itself and the actual end display class.
2. You can extend the implementation class and the bridge class separately,
and usually without much interaction with each other.
3. You can hide implementation details from the client program much more
easily.
 * */


abstract class CoffeeImp
{
	public abstract void pourCoffeeImp();
}//end of CoffeeImp class

class CoffeeImpSingleton
{
	private static CoffeeImp coffeeImp;
	
	public CoffeeImpSingleton(CoffeeImp coffeeImpIn)
	{
		this.coffeeImp = coffeeImpIn;
	}
	
	public static CoffeeImp getTheCoffeeImp()
	{
		return coffeeImp;
	}//end of gettheCoffeeImp()
}//end of CoffeeImpSingleton class

abstract class Coffee
{
	CoffeeImp coffeeImp;
	
	public void setCoffeeImp()
	{
		this.coffeeImp = CoffeeImpSingleton.getTheCoffeeImp();
	}
	
	public CoffeeImp getCoffeeImp()
	{
		return this.coffeeImp;
	}//end of getCoffeeImp
	
	public abstract void pourCoffee();
}

class MediumCoffee extends Coffee
{
	public MediumCoffee()
	{
		setCoffeeImp();
	}//end of constructor
	
	public void pourCoffee()
	{
		CoffeeImp coffeeImp = this.getCoffeeImp();
		//2 cups for medium
		for(int i=0;i<2; i++)
		{
			coffeeImp.pourCoffeeImp();
		}
	}//end of pourCoffee()
}//end of MediumCoffee class

class SuperSizeCoffee extends Coffee
{
	public SuperSizeCoffee()
	{
		setCoffeeImp();
	}//end of constructor
	
	public void pourCoffee()
	{
		CoffeeImp coffeeimp = this.getCoffeeImp();
		//5 cups for super size
		for(int i=0; i<5;i++)
		{
			coffeeImp.pourCoffeeImp();
		}
	}//end of pourCoffee()
}//end of superSizeCoffee class

class MilkCoffeeImp extends CoffeeImp
{
	MilkCoffeeImp(){}
	
	public void pourCoffeeImp()
	{
		System.out.println("add sth to milk");
	}
}//end of milkCoffeeimp class

class FragrantCoffeeImp extends CoffeeImp
{

	FragrantCoffeeImp(){}
	
	@Override
	public void pourCoffeeImp() {
		// TODO Auto-generated method stub
		System.out.println("add nothing to milk");
	}//end of pourCoffeeImp()
}//end of FragrantCoffeeImp class

public class Bridge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//take out milk
		CoffeeImpSingleton coffeeImpSingleton = 
			new CoffeeImpSingleton(new MilkCoffeeImp());
		//medium with milk
		MediumCoffee mediumCoffee = new MediumCoffee();
		mediumCoffee.pourCoffee();
		//super size with milk
		SuperSizeCoffee superSizeCoffee = new SuperSizeCoffee();
		superSizeCoffee.pourCoffee();
		
	}

}//end of Bridge class




