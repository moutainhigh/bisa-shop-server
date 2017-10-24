package com.bisa.hkshop.zj.service;

import com.bisa.hkshop.zj.basic.utility.BaseDelayed;

public interface OnDelayedListener {
	 public <T extends BaseDelayed<?>> void onDelayedArrived(T delayed); 
}
