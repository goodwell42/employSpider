package com.well.Spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import com.google.gson.Gson;

/**
 * 
 * @author goodwell
 *
 */
public class Spider implements Runnable {

	/**
	 * 页面的路径（URL）
	 */
	String url;

	/**
	 * 存储抓取的数据
	 */
	ArrayList<Employ> list;

	/**
	 * 创建爬虫
	 * 
	 * @param url  页面的路径
	 * @param list 存储数据的列表
	 */
	public Spider(String url, ArrayList<Employ> list) {
		super();
		this.url = url;
		this.list = list;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 获得执行该任务的线程的名称
		String name = Thread.currentThread().getName();
		System.out.println(name + " 线程，处理: " + url);

		// JSOUP
		try {
			Response res = Jsoup.connect(url)
					.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
					.ignoreContentType(true).execute();
			
			// 获取该请求返回的json文件
			String json = res.body();
			// 利用Gson库对json文进行操作
			JsonHolder jsonHolder = new Gson().fromJson(json, JsonHolder.class);
			
//			方法二
//			Document doc = Jsoup.connect(url)
//					.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
//					.ignoreContentType(true).get();
//			
//			String json = doc.getElementsByTag("body").first().text();			
//			JSONObject result = JSONObject.fromObject(json);	
			
			for (int j = 0; j < 90; j++) {
				String creDate = jsonHolder.data.results[j].createDate;
				String endDate = jsonHolder.data.results[j].endDate;
				String updDate = jsonHolder.data.results[j].updateDate;
				String posURL = jsonHolder.data.results[j].positionURL;
				String comName = jsonHolder.data.results[j].company.name;
				String comType = jsonHolder.data.results[j].company.type.name;
				String comSize = jsonHolder.data.results[j].company.size.name;
				String comUrl = jsonHolder.data.results[j].company.url;
				String city = jsonHolder.data.results[j].city.display;
				String jobType = jsonHolder.data.results[j].jobType.display;
				String jobName = jsonHolder.data.results[j].jobName;
				String salary = jsonHolder.data.results[j].salary;
				String eduLevel = jsonHolder.data.results[j].eduLevel.name;
				String workingExp = jsonHolder.data.results[j].workingExp.name;
				String emplType = jsonHolder.data.results[j].emplType;
				String jobSearch = jsonHolder.data.results[j].jobTag.searchTag;
				
				System.out.printf("第%d条, %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", j+1, creDate,endDate,updDate,posURL,comName,comType,comSize,comUrl,city,jobType,jobName,salary,eduLevel,workingExp,emplType,jobSearch);
				
			}
				
			System.out.println(name + " 线程，完成: " + url);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
