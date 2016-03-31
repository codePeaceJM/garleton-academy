package service;

import java.io.File;

public interface FileService {
	
	public String upload(File file,String path,String extension);//返回文件名(不重复）
}
