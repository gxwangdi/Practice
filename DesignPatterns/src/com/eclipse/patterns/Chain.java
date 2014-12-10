package com.eclipse.patterns;

/**
 * 1. The main purpose for this pattern, like a number of others, is to reduce
coupling between objects. An object only needs to know how to forward
the request to other objects.
2. This approach also gives you added flexibility in distributing
responsibilities between objects. Any object can satisfy some or all of the
requests, and you can change both the chain and the responsibilities at run
time.
3. An advantage is that there may not be any object that can handle the
request, however, the last object in the chain may simply discard any
requests it can¡¯t handle.
4. Finally, since Java can not provide multiple inheritance, the basic Chain
class needs to be an interface rather than an abstract class, so that the
individual objects can inherit from another useful hierarchy, as we did
here by deriving them all from JPanel. This disadvantage of this approach
is that you often have to implement the linking, sending and forwarding
code in each module separately.
 * */

interface Handler{
	public void handleRequest(Request request);
}//end of Handler

class Request{
	private String type;
	
	public Request(String type){
		this.type=type;
	}
	
	public String getType(){
		return type;
	}
	
	public void execute(){
		//request execution
	}
}//end of Request class

public class Chain  implements Handler{
	private Handler successor;
	
	public Chain(Handler successor){
		this.successor=successor;
	}
	
	public void handleRequest(Request request){
		/*
		if(request instanceof HelpRequest){
			//help handler
		}else if(request instanceof PrintRequest){
			request.execute();
		}else{
			//deliver to the next
			successor.handleRequest(request);
		}*/
	}//end of handleRequest()
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}//end of Chain class






