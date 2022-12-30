package com.watch.services.Imp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Hash {
	public static String MD5 = "MD5";
	public static String SHA1 = "SHA1";
	String name;
	MessageDigest md;
	private Hash(String name) {
		this.name = name;
		try {
			this.md = MessageDigest.getInstance(name);
		} catch (NoSuchAlgorithmException e) {
			System.exit(1);
		}
	}
	public static Hash getInstance(String name) {
		Hash hash;
		try {
			hash = new Hash(name);
			return hash;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String hash(String text) {
		if (md == null) {
			return "";
		}
		byte[] hashText = this.md.digest(text.getBytes());
		BigInteger output = new BigInteger(1,hashText);
		return output.toString(16);
	}
//	public String hashFile(String path, String dest) {
//		if (md == null) return "";
//		if (new File(path).exists()) {
//			try {
//				DigestInputStream dgis = new DigestInputStream(new BufferedInputStream(new FileInputStream(path)), this.md);
//				int i;
//				byte[] byteRead = new byte[1024];
//				do {
//					i = dgis.read(byteRead);
//				} while (i != -1);
//				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
//				BigInteger output = new BigInteger(1, dgis.getMessageDigest().digest());
//				bos.write(output.toString(16).getBytes());
//				bos.close();
//				return output.toString(16);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return "";
//	}

	public  String hashFile(String path) throws IOException, NoSuchAlgorithmException {
		if (md == null)
			return "";
		if (new File(path).exists()) {
			System.out.println("ok");
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
			DigestInputStream dis = new DigestInputStream(bis, MessageDigest.getInstance(name));
			int i = 0;
			byte[] buff = new byte[1024];
			do {
				i = dis.read(buff);
			} while (i != -1);
			BigInteger output = new BigInteger(1, dis.getMessageDigest().digest());
			return output.toString(16);
		}
		return "";
	}

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		Hash h = Hash.getInstance(Hash.MD5);
		System.out.println(h.hashFile("C:\\Users\\admin\\Desktop\\ATBM\\src\\main\\java\\com\\watch\\services\\Imp\\mau-don-xin-xac-nhan-don-hang.pdf"));;
	}
}