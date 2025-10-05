package edu.gxwangdi.design.patterns;

/**
 * Strategy allows you to select one of several algorithms dynamically. These
 * algorithms can be related in an inheritance hierarchy or they can be
 * unrelated as long as they implement a common interface. Since the Context
 * switches between strategies at your request, you have more flexibility than
 * if you simply called the desired derived class. This approach also avoids the
 * sort of condition statements than can make code hard to read and maintain. On
 * the other hand, strategies don't hide everything. The client code must be
 * aware that there are a number of alternative strategies and have some
 * criteria for choosing among them. This shifts an algorithmic decision to the
 * client programmer or the user. Since there are a number of different
 * parameters that you might pass to different algorithms, you have to develop a
 * Context interface and strategy methods that are broad enough to allow for
 * passing in parameters that are not used by that particular algorithm. 
 * 
 */

abstract class RepTempRule {
	protected String oldString = "aaa prefix";

	public void setOldString(String oldString) {
		this.oldString = oldString;
	}

	protected String newString = "";

	public String getNewString() {
		return newString;
	}

	public abstract void replace() throws Exception;
}// end of RepTempRule class

class RepTempRuleOne extends RepTempRule {

	@Override
	public void replace() throws Exception {
		newString = oldString.replaceFirst("aaa", "bbbb");
		System.out.println("This is replace one");
	}
}// end of RepTempRuleOne class

class RepTempRuleTwo extends RepTempRule {

	@Override
	public void replace() throws Exception {
		newString = oldString.replaceFirst("aaa", "ccc");
		System.out.println("This is replace Two");
	}
}// end of RepTempRuleTwo class

public class Strategy {
	// RepTempRuleSolve class
	private RepTempRule strategy;

	public Strategy(RepTempRule rule) {
		this.strategy = rule;
	}

	public void changeAlgorithm(RepTempRule newAlgorithm) {
		strategy = newAlgorithm;
	}
	
	public void runAlgorithm(String oldString) {
		if (strategy == null) {
			return;
		}
		strategy.setOldString(oldString);
		System.out.println("old string:" + oldString);
		try {
			strategy.replace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("new string:" + strategy.getNewString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Strategy solver = new Strategy(new RepTempRuleOne());
		solver.runAlgorithm("aaa as prefix.");

		solver.changeAlgorithm(new RepTempRuleTwo());
		solver.runAlgorithm("aaa as prefix.");
	}

}
