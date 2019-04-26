package com.well.Spider;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * 
 * @author goodwell
 *
 */
//注解、装饰器
@Mapper
public interface EmployMapper {

	// 映射 ORM mapping
	@Insert("insert into employ_info(creDate,endDate,updDate,posURL,comName,comType,comSize,comUrl,city,jobType,jobName,salary,eduLevel,workingExp,emplType,jobSearch) values(#{creDate},#{endDate},#{updDate},#{posURL},#{comName},#{comType},#{comSize},#{comUrl},#{city},#{jobType},#{jobName},#{salary},#{eduLevel},#{workingExp},#{emplType},#{jobSearch})")
	void save(Employ employ);
	
	@Select("select * from employ where comName = #{comName}")
	Employ load(String comName);
	
}
