package com.FileProcessor.JsonExtract;

public class JsonExtract {
	
	public void convertJson() {
		String filePath = "src/main/resources/JsonFiles/FirstJson.json";
		FileProcessor.Result<JithinJson> fileResult = new FileProcessor<>(JithinJson.class).processFile(filePath);
		System.out.println(fileResult.getPojo());
	}
	

}
