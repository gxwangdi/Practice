package edu.gxwangdi.design.patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * The Command pattern forwards a request only to a specific module. It encloses 
 * a request for a specific action inside an object and gives it a known public 
 * interface. It lets you give the client the ability to make requests without 
 * knowing anything about the actual action that will be performed, and allows 
 * you to change that action without affecting the client program in any way.
 * 
 * One important purpose of the Command pattern is to keep the program and user 
 * interface objects completely separate from the actions that they initiate.
 * 
 * The Command object can also be used when you need to tell the program to execute 
 * the command when the resources are available rather than immediately. In such 
 * cases, you are queuing commands to be executed later. Finally, you can use 
 * Command objects to remember operations so that you can support Undo requests.
 * 
 * The main disadvantage of the Command pattern is a proliferation of little 
 * classes that either clutters up the main class if they are inner or clutters 
 * up the program name space if they are outer classes. Now even in the case 
 * where we put all of our actionPerformed events in a single basket, we usually 
 * call little private methods to carry out the actual function. It turns out 
 * that these private methods are just about as long as our little inner classes, 
 * so there is frequently little difference in complexity between inner and outer 
 * class approaches.
 * */
/** The Command interface */
interface Command {
   void execute();
}

/** The Invoker class */
class Switch {
   private List<Command> history = new ArrayList<Command>();

   public void storeAndExecute(final Command cmd) {
      this.history.add(cmd);
      cmd.execute();
   }
}

/** The Receiver class */
class Light {

   public void turnOn() {
      System.out.println("The light is on");
   }

   public void turnOff() {
      System.out.println("The light is off");
   }
}

/** The Command for turning on the light - ConcreteCommand #1 */
class FlipUpCommand implements Command {
   private Light theLight;

   public FlipUpCommand(final Light light) {
      this.theLight = light;
   }

   @Override
   public void execute() {
      theLight.turnOn();
   }
}

/** 
 * The Command for turning off the light 
 * - Reverse operation for FlipUpCommand.
 * 
 * We can set a boolean param in Command.execute() 
 * to indicate if this is a reverse operation.
 **/
class FlipDownCommand implements Command {
   private Light theLight;

   public FlipDownCommand(final Light light) {
      this.theLight = light;
   }

   @Override
   public void execute() {
      theLight.turnOff();
   }
}

class CommandFactory {
	private final Map<String, Command> commands;

	private CommandFactory() {
		commands = new HashMap<String,Command>();
	}

	public void addCommand(final String name, final Command command) {
		commands.put(name, command);
	}

	public void executeCommand(String name) {
		if (commands.containsKey(name)) {
			commands.get(name).execute();
		}
	}

	public void listCommands() {
		System.out.println("Enabled commands: " + commands.keySet().stream().collect(Collectors.joining(", ")));
	}

	/* Factory pattern */
	public static CommandFactory init() {
		final CommandFactory cf = new CommandFactory();

		// commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
		cf.addCommand("Light on", () -> System.out.println("Light turned on"));
		cf.addCommand("Light off", () -> System.out.println("Light turned off"));

		return cf;
	}
}// end of CommandFactory class


public class CommandPattern {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CommandInJava7();
		
		CommandInJava8();
	}
	
	private static void CommandInJava7() {
		final Light lamp = new Light();
		final Command switchUp = new FlipUpCommand(lamp);
		final Command switchDown = new FlipDownCommand(lamp);
		
		final Switch mySwitch = new Switch();
		mySwitch.storeAndExecute(switchUp);
		mySwitch.storeAndExecute(switchDown);
	}
	
	private static void CommandInJava8() {
		final CommandFactory cf = CommandFactory.init();
		cf.executeCommand("Light on");
		cf.listCommands();
	}
}
