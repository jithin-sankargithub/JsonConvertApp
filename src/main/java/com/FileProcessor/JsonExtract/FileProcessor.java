/**
 * 
 */
package com.FileProcessor.JsonExtract;

import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jithi
 *
 */
public class FileProcessor<T> {
	
	private final Class<T> pojoClass;
	
	private final ObjectMapper objectMapper;
	
	public FileProcessor(Class<T> pojoClass) {
		this.pojoClass = pojoClass;
		this.objectMapper = new ObjectMapper();
	}
	
	public FileProcessor(Class<T> pojoClass,ObjectMapper objectMapper) {
		this.pojoClass = pojoClass;
		this.objectMapper = objectMapper;
	}
	
	public Result<T> processFile(String filePath){
		try {
			String fileContent = Files.readString(Path.of(filePath));
			T pojo = objectMapper.readValue(fileContent, pojoClass);
			String jsonString = objectMapper.writeValueAsString(pojo);
			return new Result<>(pojo, jsonString);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static class Result<T>{
		private final T pojo;
		
		private final String jsonString;
		
		public Result(T pojo, String jsonString) {
			this.pojo = pojo;
			this.jsonString = jsonString;
		}

		public T getPojo() {
			return pojo;
		}

		public String getJsonString() {
			return jsonString;
		}
		
		
	}

}
