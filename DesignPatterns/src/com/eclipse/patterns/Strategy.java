package com.eclipse.patterns;

/**
 * Strategy allows you to select one of several algorithms dynamically.
These algorithms can be related in an inheritance hierarchy or they can be
unrelated as long as they implement a common interface. Since the Context
switches between strategies at your request, you have more flexibility than if
you simply called the desired derived class. This approach also avoids the
sort of condition statements than can make code hard to read ad maintain.
On the other hand, strategies don¡¯t hide everything. The client code
must be aware that there are a number of alternative strategies and have some
criteria for choosing among them. This shifts an algorithmic decision to the
client programmer or the user.
Since there are a number of different parameters that you might pass
to different algorithms, you have to develop a Context interface and strategy
methods that are broad enough to allow for passing in parameters that are not
used by that particular algorithm. For example the setPenColor method in our
PlotStrategy is actually only used by the LineGraph strategy. It is ignored by
the BarGraph strategy, since it sets up its own list of colors for the successive
bars it draws.
 * */

abstract class RepTempRule{
	protected String oldString="";
	public void setOldString(String oldString){
		this.oldString = oldString;
	}
	
	protected String newString="";
	public String getNewString(){
		return newString;
	}
	
	public abstract void replace() throws Exception;
}//end of RepTempRule class

class RepTempRuleOne extends RepTempRule{

	@Override
	public void replace() throws Exception {
		// TODO Auto-generated method stub
		newString = oldString.replaceFirst("aaa", "bbbb");
		System.out.println("This is replace one");
	}
}//end of RepTempRuleOne class

class RepTempRuleTwo extends RepTempRule{

	@Override
	public void replace() throws Exception {
		// TODO Auto-generated method stub
		newString = oldString.replaceFirst("aaa", "ccc");
		System.out.println("This is replace Two");
	}
}//end of RepTempRuleTwo class

public class Strategy {
	//RepTempRuleSolve class
	private RepTempRule strategy;
	
	public Strategy(RepTempRule rule){
		this.strategy=rule;
	}
	
	/*
	public String getNewContext(Site site, String oldString){
		return strategy.replace(site, oldString);
	}*/
	
	public void changeAlgorithm(RepTempRule newAlgorithm)
	{
		strategy = newAlgorithm;
	}
	
	/**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strategy solver = new Strategy(new RepTempRuleSimple());
		solver.getNewContext(site, context);
		
		solver=new Strategy(new RepTempRuleTwo());
		solver.getNewContext(site,context);
	}*/

}
