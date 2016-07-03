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
			//����ժҪ--�Ǹ�������
			MessageDigest md = MessageDigest.getInstance(algorithm);//ָ��--����MD5�㷨���ɻ�ΪSHA-1��SHA-256��
			
			//����ժҪ
			byte[] gererateDigest = md.digest(param);
			
			//���ֽ�����ת��Ϊʮ��������
			BigInteger bi = new BigInteger(1, gererateDigest);//��gererateDigest���һ�������������
			result = bi.toString(16);//�����������ʮ���������
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
			//����ժҪ--�Ǹ�������
			MessageDigest md = MessageDigest.getInstance("MD5");//ָ��--����MD5�㷨���ɻ�ΪSHA-1��SHA-256��
			
			//����ժҪ
			byte[] gererateDigest = md.digest("ljheee".getBytes());
			
			//���ֽ�����ת��Ϊʮ��������
			BigInteger bi = new BigInteger(1, gererateDigest);//��gererateDigest���һ�������������
			result = bi.toString(16);//�����������ʮ���������
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
