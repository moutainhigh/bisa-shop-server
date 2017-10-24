package com.bisa.hkshop.zj.basic.utility;

import java.io.Serializable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public  class BaseDelayed<T> implements Delayed,Serializable{
	
	private long startTime;  
	
	private T value;
	
	private int uid;
	
	private int classId;
	
	public BaseDelayed(){
		
	}
	
	public BaseDelayed(int timeout, T value,int uid,int classId){
		System.out.println("baselayed进来了实例化"+startTime + "    " + timeout);
		this.startTime = System.currentTimeMillis() + timeout*1000L;
		this.value = value;
		this.uid = uid;
		this.classId = classId;
		System.out.println("baselayed结束"+startTime);
	}

	public long getStartTime() {
		return startTime;
	}
	
	public T getValue(){
		return this.value;
	}

	
	public int getUid() {
		return uid;
	}
	
	
	
	public int getClassId() {
		return classId;
	}
	
	
	
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.getStartTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);  
	}

	@Override
	public int compareTo(Delayed other) {
		if (other == this){  
            return 0;  
        }  
        if(other instanceof BaseDelayed){  
        	BaseDelayed<?> otherRequest = (BaseDelayed<?>)other;  
            return (int)(this.getStartTime() - otherRequest.getStartTime());  
        }  
        return 0;  
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (startTime ^ (startTime >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDelayed<?> other = (BaseDelayed<?>) obj;
		if (startTime != other.startTime)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseDelayed [startTime=" + startTime + ", value="+getValue() + ", id="+getUid()+"]";
	}

}
