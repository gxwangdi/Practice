package com.example.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utilities for password
 * */
public class PasswordUtils {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String raw1 = "test";// pw for test
		String encoded1 = encoder.encode(raw1);
		
		System.out.println(encoded1);
		
		String raw2 = "root";//pw for root
		String encoded2 = encoder.encode(raw2);
		
		System.out.println(encoded2);
		
		String raw3 = "bar";//pw for foo
		String encoded3 = encoder.encode(raw3);
		
		System.out.println(encoded3);
	}

}
