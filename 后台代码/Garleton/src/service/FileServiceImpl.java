package service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileServiceImpl implements FileService {

	public String upload(File file, String path, String extension) {
		// TODO Auto-generated method stub
		String fileName="";
		try {
			if (file != null) {
				String dir = ServletActionContext.getRequest().getRealPath(path);
				//System.out.println(dir);
				File fileLoaction = new File(dir);
				if (!fileLoaction.exists()) {
					fileLoaction.mkdirs();
				}
				fileName=UUID.randomUUID().toString().replace("-", "")+extension;
				File uploadFile = new File(dir, fileName);
				while(uploadFile.exists()){
					fileName=UUID.randomUUID().toString().replace("-", "")+extension;
					uploadFile = new File(dir, fileName);
				}
				FileUtils.copyFile(file, uploadFile);	
			}
			return fileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fileName;
		}
	}

}
