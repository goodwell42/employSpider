package com.well.Spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.google.gson.Gson;
/**
 * 
 * @author goodwell
 *
 */
public class SpiderEmployDetail implements Runnable {

	/**
	 * 招聘的 URL
	 */
	String url;

	/**
	 * 招聘列表
	 */
	List<Employ> list;

	public SpiderEmployDetail(String url, List<Employ> list) {
		super();
		this.url = url;
		this.list = list;
	}

	@Override
	public void run() {
		// 获得执行该任务的线程的名称
//		String name = Thread.currentThread().getName();
//		System.out.println(name + " 线程，处理: " + url); 

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
			
//			for (int j = 0; j < 90; j++) {
//				String creDate = jsonHolder.data.results[j].createDate.toString();
//				String endDate = jsonHolder.data.results[j].endDate.toString();
//				String updDate = jsonHolder.data.results[j].updateDate.toString();
//				String posURL = jsonHolder.data.results[j].positionURL.toString();
//				String comName = jsonHolder.data.results[j].company.name.toString();
//				String comType = jsonHolder.data.results[j].company.type.name.toString();
//				String comSize = jsonHolder.data.results[j].company.size.name.toString();
//				String comUrl = jsonHolder.data.results[j].company.url.toString();
//				String city = jsonHolder.data.results[j].city.display.toString();
//				String jobType = jsonHolder.data.results[j].jobType.display.toString();
//				String jobName = jsonHolder.data.results[j].jobName.toString();
//				String salary = jsonHolder.data.results[j].salary.toString();
//				String eduLevel = jsonHolder.data.results[j].eduLevel.name.toString();
//				String workingExp = jsonHolder.data.results[j].workingExp.name.toString();
//				String emplType = jsonHolder.data.results[j].emplType.toString();
//				String jobSearch = jsonHolder.data.results[j].jobTag.searchTag.toString();
				
//				System.out.printf("第%d条, %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", j+1, creDate,endDate,updDate,posURL,comName,comType,comSize,comUrl,city,jobType,jobName,salary,eduLevel,workingExp,emplType,jobSearch);
			
//			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
