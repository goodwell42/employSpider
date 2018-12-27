package com.well.Spider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author goodwell
 *
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 线程池
		// 固定大小
		ExecutorService pool = Executors.newFixedThreadPool(4);
		// 无限（缓存）
		pool = Executors.newCachedThreadPool();

		ArrayList<Employ> list = new ArrayList<Employ>();
		
		// 智联招聘
		String path = "https://fe-api.zhaopin.com/c/i/sou?start=";
		// 筛选出Java开发相关招聘
		String queryCondition = "&pageSize=90&cityId=489&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=Java%E5%BC%80%E5%8F%91&kt=3&x-zp-page-request-id=941d9a45496841779520aed79813db78-1545893287010-973394";
			
		for (int i = 0; i < 220; i++) {
			String url = String.format("%s%d%s", path, i*90, queryCondition);
//			String url = String.format("%s%d", path, i*90);
			pool.submit(new Spider(url, list));
			pool.execute(new SpiderEmployDetail(url, null));
		}		
		pool.shutdown();

		while (!pool.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				// 数据排序
//				Collections.sort(list);
				System.out.println(list.size());
				
				// 导入数据库中
				// myBatis/iBatis
				try {
					SqlSessionFactory factory = new SqlSessionFactoryBuilder()
							.build(Resources.getResourceAsStream("config.xml"));
					
					// 打开会话
					SqlSession session = factory.openSession();
					
					// 动态代理
					EmployMapper mapper = (EmployMapper) session.getMapper(EmployMapper.class);
					
					for (Employ employ : list) {
						// 使用注解中的 INSERT 语句存储到数据库
						mapper.save(employ);
					}
					
					session.commit();
					session.close();
					System.out.println("完成存储");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
//		ExecutorService pool2 = Executors.newFixedThreadPool(4);
//		
//		for (Employ employ : list) {
//			System.out.println(employ.posURL);
//			pool2.execute(new SpiderEmployDetail(employ.posURL, null));
//		}
//		pool2.shutdown();
				
		// 写入文件 电子表格兼容模式
		String file = "d:/employ.csv";	// 绝对路径
		file = "employTxt.csv";				// 相对路径
				
		// 排序
//		Collections.sort(list);
				
		// io
		try (FileWriter out = new FileWriter(file)) {
		// 写数据
			for (Employ employ : list) {
				out.write(employ.toCSV());
			}
			System.out.println("ok");
		} catch (Exception e) {
			
		}
		
	}

}
