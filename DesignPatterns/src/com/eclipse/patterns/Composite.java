package com.eclipse.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * Clients use the Component class interface to interact with objects 
 * in the composite structure. If the recipient is a Leaf, then the 
 * request is handled directly. If the recipient is a Composite, then 
 * it usually forwards requests to its child components, possibly 
 * performing additional operations before and/or after forwarding.
 * 
 * 
 * Component (Graphic)
   declares the interface for objects in the composition.
   implements default behaviour for the interface common to all classes, as appropriate.
   declares an interface for accessing and managing its child components.
   (optional) defines an interface for accessing a component's parent in the recursive structure, and implements it if that's appropriate.
 
   Leaf (Rectangle, Line, Text, etc.)
   represents leaf objects in the composition. A leaf has no children.
   defines behaviour for primitive objects in the composition. Composite (Picture)
   defines behaviour for components having children.
   stores child components.
   implements child-related operations in the Component interface.
 
   Client
   manipulates objects in the composition through the Component interface.
 * 
 * 
 * Use the Composite pattern when
 * 
 * 1. You want to represent part-whole hierarchies of objects.
 * 2. you want clients to be able to ignore the difference between 
 * compositions of objects and individual objects. Clients will 
 * treat all objects in the composite structure uniformly.
 * 
 * */

class GraphicException extends Exception {
	String name;
	
	public GraphicException() {
		name = new String();
	}
	
	public GraphicException(String n) {
		System.out.println(n);
		name = n;
	}
}

abstract class Graphic {
	protected String name;
	public Graphic (String n) {
		name = n;
	}
	
	public Graphic () {
		name = new String();
	}
	
	public abstract void Draw();
	
	public void Add(Graphic g) throws GraphicException{
		throw new GraphicException("Graphic " + name + ".Add throws GraphicException.");
	}
	
	public void Remove(Graphic g) throws GraphicException{
		throw new GraphicException("Graphic " + name + ".Remove throws GraphicException.");
	}
	
	public Graphic GetChild(int index) throws GraphicException{
		throw new GraphicException("Graphic " + name + ".GetChild throws GraphicException.");
	}
}// end of interface


class Line extends Graphic {

	public Line(String n) {
		super(n);
	}

	@Override
	public void Draw() {
		System.out.println("Line " + name +".Draw");             
	}
}// end of Line class       


class Rectangle extends Graphic {

	public Rectangle(String n) {
		super(n);
	}

	@Override
	public void Draw() {
		System.out.println("Rectangle " + name +".Draw");             
	}
}// end of Rectangle class             


class Text extends Graphic {

	private String mContent;
	public Text(String n, String c) {
		super(n);
		mContent = c;
	}
	
	public Text(String n) {
		super(n);
		mContent = new String();
	}

	@Override
	public void Draw() {
		System.out.println("Text " + name +".Draw:" + mContent);             
	}
}// end of Rectangle class 


class Picture extends Graphic {

	private List<Graphic> mPics;
	
	public Picture (String n) {
		super(n);
		mPics = new ArrayList<Graphic>();
	}
	
	@Override
	public void Draw() {
		System.out.println("Pic " + name + ".Draw().");
		for (Graphic g : mPics) {
			g.Draw();
		}
	}
	
	@Override
	public void Add(Graphic g) {
		if (mPics == null) {
			mPics = new ArrayList<Graphic>();
		}
		mPics.add(g);
	}
	
	@Override
	public void Remove(Graphic g) {
		if (mPics == null) {
			mPics = new ArrayList<Graphic>();
		}
		mPics.remove(g);
	}
	
	@Override
	public Graphic GetChild(int index) {
		if (mPics == null) {
			mPics = new ArrayList<Graphic>();
			return null;
		}
		return mPics.get(index);
	}
	
}// end of Picture class   


public class Composite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graphic root = new Picture("Root");
		Graphic branch = new Picture("Branch");
		Graphic twig = new Picture("twig");
		
		Graphic leaf;
		
		try {
			leaf  = new Line("a");
			twig.Add(leaf);
			branch.Add(leaf);
			branch.Add(twig);
			leaf = new Rectangle("b");
			branch.Add(leaf);
			leaf = new Text("c", "Hello World!");
			branch.Add(leaf);
			twig.Add(leaf);
			root.Add(branch);
			root.Draw();
		} catch (GraphicException e) {
			e.printStackTrace();
		}
	}

}//end of Composite class






