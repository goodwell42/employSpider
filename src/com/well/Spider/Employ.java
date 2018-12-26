package com.well.Spider;

/**
 * 
 * @author goodwell
 *
 */
public class Employ implements Comparable<Employ> {
	
	/**
	 * 招聘发布时间
	 */
	String creDate;
			   
	/**
	 * 发布结束时间 
	 */
	String endDate;
	
	/**
	 * 招聘信息最新更新时间 
	 */
	String updDate;
	
	/** 
	 * 招聘详细信息页面 
	 */
	String posURL;
	
	/**
	 * 公司名String
	 */
	String comName;
	
	/**
	 * 公司企业类型
	 */
	String comType;
	/**
	 * 公司规模人数
	 */
	String comSize;
	/**
	 * 公司信息介绍 
	 */
	String comUrl;

	/**
	 * 工作所在： 城市-区 
	 */
	String city;
	
	/**
	 * 工作类型 
	 */
	String jobType;
	
	/**
	 * 工作职位 
	 */
	String jobName;
	
	/**
	 * 薪资
	 */
	String salary;
	
	/**
	 * 学历要求 
	 */
	String eduLevel;
	
	/**
	 * 工作经验时间要求 
	 */
	String workingExp;

	/**
	 * 职业类型 
	 */
	String emplType;

	/**
	 * 搜索标签 
	 */
	String jobSearch;

//	public String url;
	
	public String getCreDate() {
		return creDate;
	}

	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getUpdDate() {
		return updDate;
	}

	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}

	public String getPosURL() {
		return posURL;
	}

	public void setPosURL(String posURL) {
		this.posURL = posURL;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public String getComSize() {
		return comSize;
	}

	public void setComSize(String comSize) {
		this.comSize = comSize;
	}

	public String getComUrl() {
		return comUrl;
	}

	public void setComUrl(String comUrl) {
		this.comUrl = comUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	public String getWorkingExp() {
		return workingExp;
	}

	public void setWorkingExp(String workingExp) {
		this.workingExp = workingExp;
	}

	public String getEmplType() {
		return emplType;
	}

	public void setEmplType(String emplType) {
		this.emplType = emplType;
	}

	public String getJobSearch() {
		return jobSearch;
	}

	public void setJobSearch(String jobSearch) {
		this.jobSearch = jobSearch;
	}
	
	
	@Override
	public String toString() {
		return "Employ [creDate=" + creDate + ", endDate=" + endDate + ", updDate=" + updDate + ", posURL=" + posURL
				+ ", comName=" + comName + ", comType=" + comType + ", comSize=" + comSize + ", comUrl=" + comUrl
				+ ", city=" + city + ", jobType=" + jobType + ", jobName=" + jobName + ", salary=" + salary
				+ ", eduLevel=" + eduLevel + ", workingExp=" + workingExp + ", emplType=" + emplType + ", jobSearch="
				+ jobSearch + "]";
	}

	@Override
	public int compareTo(Employ arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toCSV() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", creDate,endDate,updDate,posURL,comName,comType,comSize,comUrl,city,jobType,jobName,salary,eduLevel,workingExp,emplType,jobSearch);
	}

}
