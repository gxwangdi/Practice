package com.eclipse.patterns;

import java.io.File;

/**
 * The Memento provides a way to preserve the state of an object while
preserving encapsulation, in languages where this is possible. Thus, data that
only the Originator class should have access to effectively remains private. It
also preserves the simplicity of the Originator class by delegating the saving
and restoring of information to the Memento class.
On the other hand, the amount of information that a Memento has to
save might be quite large, thus taking up fair amounts of storage. This further
has an effect on the Caretaker class (here the Mediator) which may have to
design strategies to limit the number of objects for which it saves state. In our
simple example, we impose no such limits. In cases where objects change in a
predictable manner, each Memento may be able to get by with saving only
incremental changes of an object¡¯s state.
 * */

/* example below shows:
 * memento stores Originator states, 
 * if Originator state changes,
 * call setMemento() can restore its values*/
class Originator
{
	private int number;
	private File file = null;
	
	public Originator(){}
	
	//create Memento 
	public Memento getMemento(){
		return new Memento(this);
	}
	
	//return original value
	public void setMemento(Memento m)
	{
		//number = m.number;
		//file = m.file;
	}
}//end of Originator class

public class Memento implements java.io.Serializable{

	private int number;
	
	private File file = null;
	
	public Memento(Originator o){
		//number = o.number;
		//file = o.file;
	}//end of constructor
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}//end of Memento class
