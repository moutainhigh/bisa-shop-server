package com.bisa.hkshop.wqc.basic.utility;

import java.util.UUID;

/**
 * @author Shengzhao Li
 */
public abstract class GuidGenerator {
	
	public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
	
	public static String generate(int number){
    	String UUid = UUID.randomUUID().toString().replaceAll("-", "");
    	if(number<0 || number>32){
    		return null;
    	}
    	String uid = UUid.substring(0, number);
    	return uid;
    }

	
}