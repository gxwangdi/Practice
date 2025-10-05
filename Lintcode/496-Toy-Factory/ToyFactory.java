

/**
 * Your object will be instantiated and called as such:
 * ToyFactory tf = new ToyFactory();
 * Toy toy = tf.getToy(type);
 * toy.talk();
 */
interface Toy {
    void talk();
}

class Dog implements Toy {
    public void talk() {
        System.out.println("Wow");
    }
}

class Cat implements Toy {
    public void talk() {
        System.out.println("Meow");
    }
}

public class ToyFactory {
    /**
     * @param type a string
     * @return Get object of the type
     */
	public Toy getToy(String type) {
		if ("Dog".equalsIgnoreCase(type)) {
			return new Dog();
		} else if ("Cat".equalsIgnoreCase(type)) {
			return new Cat();
		}
		return null;
	}
}

