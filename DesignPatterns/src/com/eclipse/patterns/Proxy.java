package com.eclipse.patterns;

import java.io.*;
import java.net.*;

/**
 * The Proxy pattern is used when you need to represent a complex
object by a simpler one. If creating an object is expensive in time or computer
resources, Proxy allows you to postpone this creation until you need the
actual object. A Proxy usually has the same methods as the object it
represents, and once the object is loaded, it passes on the method calls from
the Proxy to the actual object.
 * 
 * Proxies can also be used to distinguish between requesting an
instance of an object and the actual need to access it.
 * 
 * Both the Adapter and the Proxy constitute a thin layer around an
 * object. However, the Adapter provides a different interface for an object,
 * while the Proxy provides the same interface for the object, but interposes
 * itself where it can save processing effort.
 * 
 * A Decorator also has the same interface as the object it surrounds, but
 * its purpose is to add additional (usually visual) function to the original object.
 * A proxy, by contrast, controls access to the contained class.
 * */

/* 5. to support plug-compatibility between
 * the wrapper and the target, create an interface*/
interface SocketInterface{
	String readLine();
	void writeLine(String str);
	void dispose();
}//end of SocketInterface


class SocketProxy implements SocketInterface {
	/* 1. Create a "wrapper" for a remote, or expensive, or sensitive target*/
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public SocketProxy(String host, int port, boolean wait){
		try{
			/* 2. encapsulate the complexity/overhead 
			 * of the target in the wrapper*/
			if(wait){
				ServerSocket server = new ServerSocket(port);
				socket = server.accept();
			} else{
				socket = new Socket(host, port);
			}
			
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		}catch(IOException e){
			e.printStackTrace();
		}
	}//end of constructor
	
	public String readLine(){
		String str = null;
		try{
			str = in.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return str;
	}//end of readLine()
	
	public void writeLine(String str){
		/* 4. The wrapper delegates to the target*/
		out.println(str);
	}//end of writeLine()
	
	public void dispose(){
		try{
			socket.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}//end of dispose()
	
}//end of SocketProxy class


public class Proxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocketInterface socket = new SocketProxy(
				"127.0.0.1", 
				8189, 
				args[0].equals("first")?true:false);
		
		String str = null;
		boolean skip = true;
		while(true){
			if(args[0].equals("second")&&skip){
				skip = !skip;
			}else{
				str = socket.readLine();
				System.out.println("Receive - "+str);
				if (str.equals("quit")) break;
			}
			System.out.print("Send ---- ");
			str = "Read.aString()";
			socket.writeLine(str);
			if (str.equals("quit"))  break;
		}
		socket.dispose();
	}//end of main()

}//end of Proxy class
