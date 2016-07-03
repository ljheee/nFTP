package com.ljheee.ftp;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/**
 * Class of MD5's util
 * @author ljheee
 *
 */
public class MDUtil {
	
	public static String getMD(File file){
		return get(file,"MD5");
	}
	
	public static String getSHA(File file){
		return get(file,"SHA-1");
	}
	
private static String get(File file,String algorithm){
		
		byte[] param = file.toString().getBytes();
		String result  = null;
		try {
			//数字摘要--是个抽象类
			MessageDigest md = MessageDigest.getInstance(algorithm);//指定--采用MD5算法（可换为SHA-1，SHA-256）
			
			//生成摘要
			byte[] gererateDigest = md.digest(param);
			
			//把字节数组转化为十六进制数
			BigInteger bi = new BigInteger(1, gererateDigest);//把gererateDigest变成一个“大的整数”
			result = bi.toString(16);//将大的整数，十六进制输出
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	/**
	 * get MD5 of file
	 * The length of input is random, while result of return is fixed length
	 * @param file
	 * @return MD5
	 */
	public static String getMD5(File file){
		
		byte[] param = file.toString().getBytes();
		String result  = null;
		try {
			//数字摘要--是个抽象类
			MessageDigest md = MessageDigest.getInstance("MD5");//指定--采用MD5算法（可换为SHA-1，SHA-256）
			
			//生成摘要
			byte[] gererateDigest = md.digest("ljheee".getBytes());
			
			//把字节数组转化为十六进制数
			BigInteger bi = new BigInteger(1, gererateDigest);//把gererateDigest变成一个“大的整数”
			result = bi.toString(16);//将大的整数，十六进制输出
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
