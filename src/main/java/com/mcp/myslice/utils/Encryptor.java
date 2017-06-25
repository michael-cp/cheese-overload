package com.mcp.myslice.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

	private static final String ENCRYPTION_ALGORITHM = "SHA-512"; 
	
	public String getSecurePassword(String passwordToHash){
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for ENCRYPTION_ALGORITHM
			MessageDigest md = MessageDigest.getInstance(ENCRYPTION_ALGORITHM);
			//Add password bytes to digest -- REMOVE USING SALT
			//			md.update(salt.getBytes());
			//Get the hash's bytes 
			byte[] bytes = md.digest(passwordToHash.getBytes());
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	
}
