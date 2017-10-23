package com.bisa.hkshop.zj.basic.utility;

import java.io.Serializable;
import java.util.HashMap;

public class DelayOrderDto implements Serializable{

	
	private HashMap<String,BaseDelayed<String>> delaylist;

	public HashMap<String, BaseDelayed<String>> getDelaylist() {
		return delaylist;
	}

	public void setDelaylist(HashMap<String, BaseDelayed<String>> delaylist) {
		this.delaylist = delaylist;
	}
	
}
