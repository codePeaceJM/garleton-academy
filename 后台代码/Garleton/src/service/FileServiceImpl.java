package service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileServiceImpl implements FileService {

	public void upload(File file, String path, String fileName) {
		// TODO Auto-generated method stub
		if (file != null) {            
			String dir = ServletActionContext.getRequest().getRealPath(path);
			System.out.println(dir);
			File fileLoaction = new File(dir);
			if (!fileLoaction.exists()) {
				fileLoaction.mkdirs();
			}
			File uploadFile = new File(dir, fileName);
			try {
				FileUtils.copyFile(file, uploadFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
