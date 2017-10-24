package com.bisa.hkshop.zj.service;

import com.bisa.hkshop.zj.basic.utility.BaseDelayed;

public interface IDelayedService {

    //匿名的内部类
    public <T> void start(OnStartListener onStartListener,OnDelayedListener listener);
      
    public void add(BaseDelayed<?> baseDelayed);

    //返回当前所有的队列
    public BaseDelayed<?>[] getDelayQueue();
    
	public <T, D extends BaseDelayed<?>> D remove(Class<D>clazz, T value);
}
