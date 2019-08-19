package com.bookshop.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件（属性文件）的工具类
 * @author liyang
 *
 */
public class ConfigManager {

	//工具类对象
	private static ConfigManager configManager;
	//Properties类
	private static Properties properties;
	
	//私有构造方法（单例模式）
	private ConfigManager(){
		//配置文件名
		String configFile = "database.properties";
		//实例化Properties
		properties = new Properties();
		//获得文件输入流
		InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		//读取输入流
		try {
			//读取输入流
			properties.load(in);
			//关闭输入流
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获得工具类对象
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager = new ConfigManager();
		}
		return configManager;
	}
	
	//利用properties键取得值ֵ
	public String getString(String key){
		return properties.getProperty(key);
	}
}
