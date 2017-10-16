package com.bisa.hkshop.wqc.service;

import java.util.List;

import com.bisa.health.entity.Pager;
import com.bisa.hkshop.model.Appraise;

public interface IAppraiseService {

	public int addAppraise(Appraise appraise);

	public Appraise loadAppraise(int product_guid,String order_detail_guid);
	
	public int upAppraise(Appraise appraise);
	
	public int delAppraise(Appraise appraise);

	public Pager<Appraise> loadAppraiseList(int product_guid);

}
