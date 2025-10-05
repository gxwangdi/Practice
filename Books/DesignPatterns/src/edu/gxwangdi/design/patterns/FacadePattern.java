package edu.gxwangdi.design.patterns;

/*
 * Frequently, as your programs evolve and develop, they grow in complexity. 
 * In fact, for all the excitement about using design patterns, these 
 * patterns sometimes generate so many classes that it is difficult to 
 * understand the program’s flow. Furthermore, there may be a number of 
 * complicated subsystems, each of which has its own complex interface. 
 * The Façade pattern allows you to simplify this complexity by providing 
 * a simplified interface to these subsystems. 
 * 
 * The Facade pattern shields clients from complex subsystem components 
 * and provides a simpler programming interface for the general user. 
 * However, it does not prevent the advanced user from going to the deeper, 
 * more complex classes when necessary.
 * 
 * In addition, the Facade allows you to make changes in the underlying 
 * subsystems without requiring changes in the client code, and reduces 
 * compilation dependencies.
* */
class CPU {
	public void freeze() {
		System.out.println("CPU.freeze()...");
	}
	public void jump(long position) {
		System.out.println("CPU.jump(" + position + ")...");
	}
	public void execute() {
		System.out.println("CPU.execute()...");
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		System.out.println("HardDrive.read(" + lba + ", " + size + ")...");
		return null;
	}
}

class Memory {
	public void load(long position, byte[] data) {
		System.out.println("Memory.load(" + position + ", " + data + ")...");
	}
}

class ComputerFacade {
	private CPU processor;
	private Memory ram;
	private HardDrive hd;
	
	public ComputerFacade () {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}
	
	public void start() {
		processor.freeze();
		ram.load(20L, hd.read(0L, 512));
		processor.jump(20L);
		processor.execute();
	}
}

public class FacadePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
	}

}//end of Facade class
