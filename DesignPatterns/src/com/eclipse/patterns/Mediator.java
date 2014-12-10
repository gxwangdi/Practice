package com.eclipse.patterns;

/**
 * 1. The Mediator makes loose coupling possible between objects in a
program. It also localizes the behavior that otherwise would be
distributed among several objects.
2. You can change the behavior of the program by simply changing or
subclassing the Mediator.
3. The Mediator approach makes it possible to add new Colleagues to a
system without having to change any other part of the program.
4. The Mediator solves the problem of each Command object needing to
know too much about the objects and methods in the rest of a user
interface.
5. The Mediator can become monolithic in complexity, making it hard to
change and maintain. Sometimes you can improve this situation by
revising the responsibilities you have given the Mediator. Each object
should carry out it¡¯s own tasks and the Mediator should only manage the
interaction between objects.
6. Each Mediator is a custom-written class that has methods for each
Colleague to call and knows what methods each Colleague has available.
This makes it difficult to reuse Mediator code in different projects. On the
other hand, most Mediators are quite simple and writing this code is far
easier than managing the complex object interactions any other way.
 * */

interface IMediator{}

class ConcreteMediator implements IMediator{
	//assume there are two members
	private ConcreteColleague1 colleague1 = new ConcreteColleague1();
	private ConcreteColleague2 colleague2 = new ConcreteColleague2();
}

class Colleague{
	private Mediator mediator;
	public Mediator getMediator(){
		return mediator;
	}
	
	public void setMediator(Mediator mediator){
		this.mediator = mediator;
	}
}//end of Colleague class

class ConcreteColleague1{}

class ConcreteColleague2{}

public class Mediator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
