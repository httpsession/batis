package com.jack.app.dao;

import com.jack.batis.annotation.Mapper;
import com.jack.batis.annotation.Update;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 下午4:27:45 
*/
@Mapper
public interface ProductDao {
	@Update("update product set price =#{price} where id=#{id}")
	public int updateProduct(String productId,int price);
	
	@Update("update product set price =#{price} where id=#{id}")  
	public int deleteProduct(String productId);
}
