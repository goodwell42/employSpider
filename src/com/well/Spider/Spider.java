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
					.timeout(50000)
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
				Employ employ = new Employ();
				
				employ.creDate = jsonHolder.data.results[j].createDate.toString();
				employ.endDate = jsonHolder.data.results[j].endDate.toString();
				employ.updDate = jsonHolder.data.results[j].updateDate.toString();
				employ.posURL = jsonHolder.data.results[j].positionURL.toString();
				employ.comName = jsonHolder.data.results[j].company.name.toString();
				employ.comType = jsonHolder.data.results[j].company.type.name.toString();
				employ.comSize = jsonHolder.data.results[j].company.size.name.toString();
				employ.comUrl = jsonHolder.data.results[j].company.url.toString();
				employ.city = jsonHolder.data.results[j].city.display.toString();
				employ.jobType = jsonHolder.data.results[j].jobType.display.toString();
				employ.jobName = jsonHolder.data.results[j].jobName.toString();
				employ.salary = jsonHolder.data.results[j].salary.toString();
				employ.eduLevel = jsonHolder.data.results[j].eduLevel.name.toString();
				employ.workingExp = jsonHolder.data.results[j].workingExp.name.toString();
				employ.emplType = jsonHolder.data.results[j].emplType.toString();
				employ.jobSearch = jsonHolder.data.results[j].jobTag.searchTag.toString();
				
//				System.out.printf("第%d条, %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", j+1, creDate,endDate,updDate,posURL,comName,comType,comSize,comUrl,city,jobType,jobName,salary,eduLevel,workingExp,emplType,jobSearch);
				list.add(employ);
			}
				
			System.out.println(name + " 线程，完成: " + url);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
