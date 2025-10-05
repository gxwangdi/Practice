
public class Singleton {
	private static Singleton mInstance;
    private Singleton() {}
    /**
     * @return: The same instance of this class every time
     */
    public static synchronized Singleton getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton();
        }
        return mInstance;
    }
}
