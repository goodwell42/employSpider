package com.well.Spider;
/**
 * 
 * @author goodwell
 *
 */

/**
 * 
 * 爬到的数据有：jsonHolder.data.results[i]
-招聘方
  招聘发布时间 createDate
  发布结束时间 endDate
  招聘信息最新更新时间 updateDate
  招聘详细信息页面 positionURL

  公司名 company.name
  公司企业类型 company.type.name
  公司规模人数 company.size.name
  公司信息介绍 company.url

-求职方
  工作所在： 城市-区 city.display
  工作类型 jobType.display
  工作职位 jobName
  薪资 salary
  学历要求 eduLevel.name
  工作经验时间要求 workingExp.name

-分类
  职业类型 emplType
  搜索标签 jobTag.searchTag
 *
 */
public class JsonHolder {
	public int code;
	public A data;
	class A {
		public int numFound;
		public B[] results;
		class B {
			public String applyType;
			/**
			 * 招聘信息更新时间
			 */
			public String updateDate;
			public C city;
			class C {
				/**
				 *工作所在： 城市-区
				 */
		    	public String display;
		    	public D[] items;
		    	class D {
		    		//省略...
		    	}
			}
		    /**
		     *  发布结束时间
		     */
		    public String endDate;
		    /**
		     * 招聘详细信息页面
		     */
		    public String positionURL;
		    /**
		     * 薪资
		     */
		    public String salary;
//		    public E[] welfare;
//		    class E {}
		    //省略...
		    public F workingExp;
		    class F {
		    	public String code;
		    	/**
		    	 * 工作经验时间要求
		    	 */
		    	public String name;
		    }
		    public G company;
		    class G {
		    	public String number;
		    	public H size;
		    	class H {
		    		public String code;
		    		/**
		    		 * 公司规模人数
		    		 */
			    	public String name;
		    	}
		    	/**
		    	 * 公司名
		    	 */
		    	public String name;
		    	public I type;
		    	class I {
		    		public String code;
		    		/**
		    		 * 企业分类
		    		 */
			    	public String name;
		    	}
		    	/**
		    	 * 公司信息介绍
		    	 */
		    	public String url;
		    }
		    
		    public J jobType;
		    class J {
		    	/**
		    	 * 工作类型
		    	 */
		    	public String display;
		    	public K[] items;
		    	class K {
		    		public String code;
			    	public String name;
		    	}
		    }
		    /**
		     * 招聘发布时间
		     */
		    public String createDate;
		    /**
		     * 工作职位
		     */
		    public String jobName;
		    public L eduLevel;
	    	class L {
	    		public String code;
	    		/**
	    		 * 学历要求
	    		 */
		    	public String name;
	    	}
	    	public String companyLogo;
	    	/**
	    	 * 职业类型
	    	 */
	    	public String emplType;
	    	/**
	    	 * 搜索标签
	    	 */
	    	public M jobTag;
	    	class M {
	    		public String searchTag;
	    	}
	    	
		}
	}
}