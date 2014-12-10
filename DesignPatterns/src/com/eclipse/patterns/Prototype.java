package com.eclipse.patterns;

/*
 * The Prototype pattern is used when creating an instance of a class is very
time-consuming or complex in some way. Then, rather than creating more
instances, you make copies of the original instance, modifying them as
appropriate. The changes on the copies would not reflect on the original piece.
 * 
 * Using the Prototype pattern, you can add and remove classes at run time by
cloning them as needed. You can revise the internal data representation of a
class at run time based on program conditions. You can also specify new
objects at run time without creating a proliferation of classes and inheritance
structures.
 *
 * Note that every class that you might use as a prototype must itself be
instantiated (perhaps at some expense) in order for you to use a Prototype
Registry. This can be a performance drawback.
 *
 * Finally, the idea of having prototype classes to copy implies that you have
sufficient access to the data or methods in these classes to change them after
cloning. This may require adding data access methods to these prototype
classes so that you can modify the data once you have cloned the class.
 *
 **/

abstract class AbstractSpoon implements Cloneable{
	String spoonName;
	
	public void setSpoonName(String sName){
		this.spoonName=sName;
	}
	
	public String getSpoonName(){
		return this.spoonName;
	}
	
	public Object clone()
	{
		Object object=null;
		try{
			/* Object.clone() is independent of Object, 
			 * that is, they have the same content, but different objects in memory
			 * usually on some classes particularly for fetching and storing large data source
			 * like local/remote file,  database, or streams on the Web
			 * 
			 * Shallow copy*/
			
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("AbstractSpoon is not Cloneable.");
		}
		return object;
	}
}

class SoupSpoon extends AbstractSpoon{
	public SoupSpoon(){
		setSpoonName("Soup Spoon");
	}
}

class SaladSpoon extends AbstractSpoon{
	public SaladSpoon(){
		setSpoonName("Salad Spoon");
	}
}

public class Prototype {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractSpoon spoon1= new SoupSpoon();
		System.out.println(spoon1.getSpoonName());
		
		AbstractSpoon spoon2= (AbstractSpoon)spoon1.clone();
		System.out.println(spoon2.getSpoonName());
		
		spoon2.setSpoonName("Salad Spoon");
		System.out.println(spoon1.getSpoonName());
		System.out.println(spoon2.getSpoonName());
	}

}//end of factory class



