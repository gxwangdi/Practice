package edu.gxwangdi.design.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * The abstract factory pattern provides a way to encapsulate a group of 
 * individual factories that have a common theme without specifying their 
 * concrete classes.
 * 
 * Use of this pattern makes it possible to interchange concrete 
 * implementations without changing the code that uses them, even at runtime. 
 * However, employment of this pattern, as with similar design patterns, may 
 * result in unnecessary complexity and extra work in the initial writing 
 * of code. Additionally, higher levels of separation and abstraction can 
 * result in systems that are more difficult to debug and maintain.
 * */
class Context {
	Context() {
		System.out.println("Context constructor.");
	}
}// end of context


abstract class ViewDelegate 
{
	protected Context context;
	protected iModelDelegate model;
	
	public ViewDelegate(Context c, iModelDelegate m) {
		context = c;
		model = m;
	}
	
	public abstract void updateView();
	public abstract void initialize();
}// end of ViewDelegate class     



interface iModelDelegate
{
	public List loadData();
	public void persistData(List l);
}// end of iModelDelegate interface 


class DashboardViewDelegate extends ViewDelegate
{

	public DashboardViewDelegate(Context c, iModelDelegate m) {
		super(c, m);
	}
	
	@Override
	public void updateView() {
		System.out.println("Dashboard view update.");
	}

	@Override
	public void initialize() {
		System.out.println("Dashboard view initialize.");
	}
}// end of DashboardViewDelegate           


class EditorViewDelegate extends ViewDelegate
{
	public EditorViewDelegate (Context c, iModelDelegate m) {
		super(c, m);
	}

	@Override
	public void updateView() {
		System.out.println("Editor view update.");
	}

	@Override
	public void initialize() {
		System.out.println("Editor view initialize.");
	}
}// end of EditorViewDelegate class            


class DashboardModelDelegate implements iModelDelegate {

	@Override
	public List loadData() {
		System.out.println("DashboardModelDelegate load data.");
		return new ArrayList<String>();
	}

	@Override
	public void persistData(List l) {
		System.out.println("DashboardModelDelegate persist data.");
	}
}// end of DashboardModelDelegate class            

class EditorModelDelegate implements iModelDelegate {

	@Override
	public List loadData() {
		System.out.println("EditorModelDelegate load data.");            
		return new ArrayList<String>();
	}

	@Override
	public void persistData(List l) {
		System.out.println("EditorModelDelegate persist data.");        
	}
}


abstract class ActivityFactory {
	protected Context context;
	protected iModelDelegate mModel;
	protected ViewDelegate mView;
	
	public ActivityFactory(Context c) {
		context = c;
		mModel = null;
		mView = null;
	}
	
	public abstract iModelDelegate getModelDelegate();
	public abstract ViewDelegate getViewDelegate();
}// end of ActivityFactory class       


class DashboardFactory extends ActivityFactory
{

	public DashboardFactory(Context c) {
		super(c);
	}

	@Override
	public synchronized iModelDelegate getModelDelegate() {
		System.out.println("DashboardFactory getModelDelegate().");
		if (mModel == null)
			mModel = new DashboardModelDelegate();
		return mModel;
	}

	@Override
	public synchronized ViewDelegate getViewDelegate() {
		System.out.println("DashboardFactory getViewDelegate().");
		if (mModel == null)
			mModel = new DashboardModelDelegate();
		if (mView == null) 
			mView = new DashboardViewDelegate(context, mModel);
		return mView;
	}
}// end of DashboardFactory class        


class EditorFactory extends ActivityFactory
{

	public EditorFactory(Context c) {
		super(c);
	}

	@Override
	public synchronized iModelDelegate getModelDelegate() {
		System.out.println("EditorFactory getModelDelegate().");
		if (mModel == null)
			mModel = new EditorModelDelegate();
		return mModel;
	}

	@Override
	public synchronized ViewDelegate getViewDelegate() {
		System.out.println("EditorFactory getViewDelegate().");
		if (mModel == null)
			mModel = new EditorModelDelegate();
		if (mView == null) 
			mView = new EditorViewDelegate(context, mModel);
		return mView;
	}
}// end of EditorFactory class        


enum ACTIVITY {
	NONE(-1), DASHBOARD(0), EDITOR(1);
	
	private int value;
	private ACTIVITY(int i) {
		value = i;
	}
}

public class AbstractFactory {

	public static ActivityFactory create(Context c, ACTIVITY ac) {
		switch (ac) {
		case DASHBOARD:
			return new DashboardFactory(c);          
		case EDITOR:
			return new EditorFactory(c);          
		default:
			return null;
		}
	}// end of create
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ActivityFactory factory;
		factory = create(new Context(), ACTIVITY.DASHBOARD);
		iModelDelegate model;
		ViewDelegate view;
		
		model = factory.getModelDelegate();     
		view = factory.getViewDelegate();
		
		model.loadData();
		view.updateView();
		
		factory = create(new Context(), ACTIVITY.EDITOR);
		
		model = factory.getModelDelegate();     
		view = factory.getViewDelegate();
		
		model.loadData();
		view.updateView();
	}

}// end of AbstractFactory class          






