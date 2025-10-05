package edu.gxwangdi.design.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * Observers promote abstract coupling to Subjects. A subject does not 
 * know the details of any of its observers. However, this has the potential 
 * disadvantage of successive or repeated updates to the Observers when 
 * there are a series of incremental changes to the data. If the cost of 
 * these updates is high, it may be necessary to introduce some sort of 
 * change management, so that the Observers are not notified too soon or 
 * too frequently. When one client makes a change in the underlying data, 
 * you need to decide which object will initiate the notification of the 
 * change to the other observers. If the Subject notifies all the observers 
 * when it is changed, each client is not responsible for remembering to 
 * initiate the notification. On the other hand, this can result in a number 
 * of small successive updates being triggered. If the clients tell the 
 * Subject when to notify the other clients, this cascading notification can 
 * be avoided, but the clients are left with the responsibility of telling 
 * the Subject when to send the notifications. If one client forgets, the 
 * program simply will not work properly. Finally, you can specify the kind 
 * of notification you choose to send by defining a number of update methods 
 * for the Observers to receive depending on the type or scope of change. 
 * In some cases, the clients will thus be able to ignore some of these 
 * notifications.
 * */


interface ISubject {
	void register(IObserver iObserver);
	void unregister(IObserver iObserver);
	/**
	 * This is normal notify Change.
	 * */
	void notifyChange();
	/**
	 * This is collective notify change, at most how many registered observer will be notified,
	 * And if it is based on their own rankings. 
	 * @param count at most how many observer will be notified.
	 * @param basedOnRanking if the observers are sorted first.
	 * @return how many observer handle this change.
	 * */
	int notifyCollectiveChange(int count, boolean basedOnRanking);
	
	/**
	 * Abstract method to represent the data it represents. 
	 * */
	int getLatestPrice();
}

enum Ranking {
	MOST_IMPORTANT(0),
	IMPORTANT(1),
	NORMAL(2),
	TRIVIAL(3);
	private int value = 2;
	Ranking(int v) {
		value = v;
	}
	public int Value() {
		return value;
	}
}

interface IObserver {
	void onChange(ISubject sub);
	
	Ranking getRanking();
	/**
	 * @return If change is handled by the observer, return true,otherwise false.
	 * */
	boolean onSelectiveChange(ISubject sub);
}

class MarketWatch implements IObserver {

	@SuppressWarnings("unused")
	private int mPrice;
	@Override
	public void onChange(ISubject sub) {
		System.out.println("MarketWatch.onChange().");
		mPrice = sub.getLatestPrice();
	}

	@Override
	public Ranking getRanking() {
		return Ranking.IMPORTANT;
	}

	@Override
	public boolean onSelectiveChange(ISubject sub) {
		if (sub instanceof DJIIndex || sub instanceof NasdaqIndex) {
			System.out.println("MarketWatch.onSelectiveChange().");
			mPrice = sub.getLatestPrice();
			return true;
		}
		return false;
	}
}

class ScottTradeMobileClient implements IObserver {

	@SuppressWarnings("unused")
	private int mPrice;
	@Override
	public void onChange(ISubject sub) {
		System.out.println("ScottTradeMobileClient.onChange().");
		mPrice = sub.getLatestPrice();
	}

	@Override
	public Ranking getRanking() {
		return Ranking.MOST_IMPORTANT;
	}

	@Override
	public boolean onSelectiveChange(ISubject sub) {
		if (sub instanceof DJIIndex || sub instanceof NasdaqIndex) {
			System.out.println("ScottTradeMobileClient.onSelectiveChange().");
			mPrice = sub.getLatestPrice();
			return true;
		}
		return false;
	}
}

class BusinessDaily implements IObserver {

	@SuppressWarnings("unused")
	private int mPrice;
	@Override
	public void onChange(ISubject sub) {
		System.out.println("BusinessDaily.onChange().");
		mPrice = sub.getLatestPrice();
	}

	@Override
	public Ranking getRanking() {
		return Ranking.NORMAL;
	}

	@Override
	public boolean onSelectiveChange(ISubject sub) {
		System.out.println("BusinessDaily.onSelectiveChange().");
		mPrice = sub.getLatestPrice();
		return true;
	}
}

class FinancialTimes implements IObserver {

	@SuppressWarnings("unused")
	private int mPrice;
	
	@Override
	public void onChange(ISubject sub) {
		System.out.println("FinancialTimes.onChange().");
		mPrice = sub.getLatestPrice();
	}

	@Override
	public Ranking getRanking() {
		return Ranking.TRIVIAL;
	}

	@Override
	public boolean onSelectiveChange(ISubject sub) {
		System.out.println("FinancialTimes.onSelectiveChange().");
		mPrice = sub.getLatestPrice();
		return true;
	}
}

class AbstractIndex implements ISubject {
	private List<IObserver> mObserverList = new ArrayList<>();
	
	public void register(IObserver iObserver) {
		mObserverList.add(iObserver);
	}

	public void unregister(IObserver iObserver) {
		if (mObserverList.contains(iObserver)) {
			mObserverList.remove(iObserver);
		}
	}// end of unregister.

	public void notifyChange() {
		for (IObserver ob : mObserverList) {
			ob.onChange(this);
		}
	}

	public int notifyCollectiveChange(int count, boolean basedOnRanking) {
		if (basedOnRanking) {
			//TODO: sort mObserverList
		}
		int result = 0;
		for (IObserver ob : mObserverList) {
			if (ob.onSelectiveChange(this)) {
				result++;
			}
			if (result >= count) {
				break;
			}
		}
		return result;
	}

	public int getLatestPrice() {
		return -1;
	}
}

class DJIIndex extends AbstractIndex {

	@Override
	public int getLatestPrice() {
		return 22000;
	}
}// end of DJIIndex

class NasdaqIndex extends AbstractIndex {
	
	@Override
	public int getLatestPrice() {
		return 2400;
	}
}// end of NasdaqIndex

class CommodityIndex extends AbstractIndex {
	
	@Override
	public int getLatestPrice() {
		return 10000;
	}
}// end of CommodityIndex

class RealEstateIndex extends AbstractIndex {

	@Override
	public int getLatestPrice() {
		return 503938380;
	}
}// end of RealEstateIndex



public class ObserverPattern {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MarketWatch mwObserver = new MarketWatch();
		ScottTradeMobileClient stmcObserver = new ScottTradeMobileClient();
		BusinessDaily bdObserver = new BusinessDaily();
		FinancialTimes ftObserver = new FinancialTimes();
		DJIIndex dji = new DJIIndex();
		dji.register(mwObserver);
		dji.register(stmcObserver);
		dji.register(bdObserver);
		dji.register(ftObserver);
		dji.notifyChange();
		dji.notifyCollectiveChange(1, false);
		dji.unregister(ftObserver);
		dji.unregister(stmcObserver);
		dji.notifyChange();
		
		NasdaqIndex nasdaq = new NasdaqIndex();
		nasdaq.register(mwObserver);
		nasdaq.register(stmcObserver);
		nasdaq.register(bdObserver);
		nasdaq.register(ftObserver);
		nasdaq.notifyChange();
		nasdaq.notifyCollectiveChange(1, false);
		nasdaq.unregister(mwObserver);
		nasdaq.unregister(stmcObserver);
		nasdaq.notifyChange();
		
//		CommodityIndex commodity = new CommodityIndex();
		
//		RealEstateIndex realEstate = new RealEstateIndex();
	}
}//end of Observer class
