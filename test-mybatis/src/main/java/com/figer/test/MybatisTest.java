package com.figer.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.figer.gen.TLocation;
import com.figer.gen.TLocationExample;
import com.figer.mapper.TLocationMapper;
import com.figer.utils.ChineseToEnglish;

/**
 * 生成mongodb导入json文本
 * 数据实现地区，国家，省，市联动
 * @author peng.zhang
 *
 */
public class MybatisTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MybatisTest.class);
	
	public static void main(String[] args) throws IOException {
		
		//generatorCountry();
		
		generatorProvince();
		
		//generatorCity();
	}
	
	
	
	private static void generatorCountry(){
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		TLocationMapper tLocationMapper = (TLocationMapper) application.getBean("tLocationMapper");
		TLocationExample example = new TLocationExample();
		example.createCriteria().andLocationTypeEqualTo(0);
		List<TLocation> locations = tLocationMapper.selectByExample(example);
		String className = "	\"className\" : \"com.travelzen.tops.core.mongo.entity.Country\",";
		String iataCode;
		String isoCode;
		String lastUpdateDate = "	\"lastUpdateDate\" : { \"$date\" : 1453270130243 },";
		String lastUpdateUser = "	\"lastUpdateUser\" : \"figer\",";
		String nameCn;
		String name;
		for (TLocation tLocation : locations) {
			iataCode = "	\"iataCode\":\"" + tLocation.getAbbr() + "\",";
			isoCode = "	\"isoCode\":\"" + tLocation.getAbbr() + "\",";
			name = " \"name\" : \"" + ChineseToEnglish.getPingYin(tLocation.getNameChs()) + "\",";
			nameCn = "	\"nameCn\" : \"" + tLocation.getNameChs() + "\"";
			System.out.println("{" + className + iataCode + isoCode + lastUpdateDate + lastUpdateUser + name + nameCn + "}");
		}
	}
	
	private static void generatorProvince(){
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		TLocationMapper tLocationMapper = (TLocationMapper) application.getBean("tLocationMapper");
		TLocationExample example = new TLocationExample();
		example.createCriteria().andLocationTypeEqualTo(1);
		List<TLocation> locations = tLocationMapper.selectByExample(example);
		String className = "	\"className\" : \"com.travelzen.tops.core.mongo.entity.Province\",";
		String code;
		String countryIsoCode;
		String regionCode = " \"regionCode\" : \"OVERSEA\",";
		String lastUpdateTime = "	\"lastUpdateTime\" : { \"$date\" : 1453270130243 },";
		String lastUpdateUser = "	\"lastUpdateUser\" : \"figer\",";
		String name;
		String nameCn;
		for (TLocation tLocation : locations) {
			code = "	\"code\":\"" + tLocation.getAbbr() + "\",";
			countryIsoCode = "	\"countryIsoCode\":\"" + getLocation(tLocationMapper, tLocation.getParentId()).getAbbr() + "\",";
			nameCn = "	\"nameCn\" : \"" + tLocation.getNameChs() + "\"";
			name = "	\"name\" : \"" + ChineseToEnglish.getPingYin(tLocation.getNameChs()).toUpperCase() + "\",";
			System.out.println("{" + className + code + countryIsoCode + regionCode + lastUpdateTime + lastUpdateUser + name + nameCn + "}");
		}
	}
	
	private static void generatorCity() throws IOException{
		File file = new File("/tmp/generator/city.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileOutputStream o = new FileOutputStream(file);  
		
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		TLocationMapper tLocationMapper = (TLocationMapper) application.getBean("tLocationMapper");
		TLocationExample example = new TLocationExample();
		example.createCriteria().andLocationTypeEqualTo(2);
		List<TLocation> locations = tLocationMapper.selectByExample(example);
		String className = "	\"className\" : \"com.travelzen.tops.core.mongo.entity.City\",";
		String isoCode;
		String code;
		String iataCode;
		String nameCn;
		String name;
		String priority = "\"priority\" : \"0\",";
		String pinyinFirstCharactor;
		String provinceCode = "";
		String provinceName = "";
		String countryIsoCode = "";
		String countryIataCode = "";
		String countryName = "";
		String lastUpdateDate = "	\"lastUpdateDate\" : { \"$date\" : 1453270130243 },";
		String lastUpdateUser = "	\"lastUpdateUser\" : \"figer\"";
		String regionCode = "	\"regionCode\":\"OVERSEA\",";
		String regionName = "	\"regionName\":\"海外\",";
		boolean hasProvince = false;
		for (TLocation tLocation : locations) {
			hasProvince = false;
			isoCode = "	\"isoCode\":\"" + tLocation.getAbbr() + "\",";
			code = "	\"code\":\"" + tLocation.getAbbr() + "\",";
			iataCode = "	\"iataCode\":\"" + tLocation.getAbbr() + "\",";
			nameCn = "	\"nameCn\" : \"" + tLocation.getNameChs() + "\",";
			pinyinFirstCharactor = "	\"pinyinFirstCharactor\" : \"" + ChineseToEnglish.getPinYinHeadChar(tLocation.getNameChs()).toUpperCase() + "\",";
			name = " \"name\" : \"" + ChineseToEnglish.getPingYin(tLocation.getNameChs()) + "\",";
			
			TLocation pLocation = getLocation(tLocationMapper, tLocation.getParentId());
			if (pLocation.getLocationType() == 1) {//province
				hasProvince = true;
				provinceCode = "	\"provinceCode\":\"" + pLocation.getAbbr() + "\",";
				provinceName = "	\"provinceName\":\"" + pLocation.getNameChs() + "\",";
				TLocation ppLocation = getLocation(tLocationMapper, pLocation.getParentId());
				countryIsoCode = "	\"countryIsoCode\":\"" + ppLocation.getAbbr() + "\",";
				countryIataCode = "	\"countryIataCode\":\"" + ppLocation.getAbbr() + "\",";
				countryName = "	\"countryName\":\"" + ppLocation.getNameChs() + "\",";
			}else if (pLocation.getLocationType() == 0) {//country
				TLocation ppLocation = getLocation(tLocationMapper, tLocation.getParentId());
				countryIsoCode = "	\"countryIsoCode\":\"" + ppLocation.getAbbr() + "\",";
				countryIataCode = "	\"countryIataCode\":\"" + ppLocation.getAbbr() + "\",";
				countryName = "	\"countryName\":\"" + ppLocation.getNameChs() + "\",";
			}else{
				//System.err.println("parent type error!");
				LOGGER.error("parent type error!locationId:{},plocationId:{}", tLocation.getLocationId(), pLocation.getLocationId());
			}
			
			String string;
			
			if (hasProvince) {
				string = className + isoCode + code + iataCode + nameCn + name + priority + pinyinFirstCharactor + countryIsoCode + countryIataCode + countryName + provinceCode + provinceName + regionCode + regionName + lastUpdateDate + lastUpdateUser; 
			}else{
				string = className + isoCode + code + iataCode + nameCn + name + priority + pinyinFirstCharactor + countryIsoCode + countryIataCode + countryName + regionCode + regionName + lastUpdateDate + lastUpdateUser; 
			}
			
			o.write(("{" + string + "}\n").getBytes());
		}
		o.close();
	}
	
	private static TLocation getLocation(TLocationMapper tLocationMapper, long locationId){
		TLocationExample example = new TLocationExample();
		example.createCriteria().andLocationIdEqualTo(locationId);
		List<TLocation> locations = tLocationMapper.selectByExample(example);
		return locations.get(0);
	}
	
}

