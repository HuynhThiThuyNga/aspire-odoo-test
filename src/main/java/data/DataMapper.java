package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DataMapper {
	private static String dataPath;
	static HashMap<String, String> dataMap;
	
	public static void initData() {
		String bodyString = null;
			String jsonPath =System.getProperty("user.dir") + "/src/test/resources/"+ getDataPath();
			try {
				bodyString = FileUtils.readFileToString(new File(jsonPath), StandardCharsets.UTF_8);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				dataMap = objectMapper.readValue(bodyString, HashMap.class);
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public static String mapData(String key) {
		if (key == null) {
			return key;
		} else {
			return dataMap.get(key);
		}
	}
	
	public static void updateData(String key, String value) {
		dataMap.put(key, value);
	}
	
	public static String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}
	
	
	
	
}
