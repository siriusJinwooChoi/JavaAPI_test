package io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileSample {
	public static void main(String[] args) {
		FileSample sample = new FileSample();

		//String pathName = "C:\\Users\\Jinwoo\\SIRIUS\\JAVA";			//-> (JAVA)라는 디렉토리
		//String pathName = "C:\\Python27\\NEWS.txt";	//있으면 true, 없으면 false를 반환.
		//sample.checkPath(pathName);
		
		/*
		String pathName = File.separator+"Users"+File.separator+"Jinwoo"+File.separator+"SIRIUS"+File.separator+"JAVA";
		String fileName = "Java_test.txt";
		sample.checkFile(pathName, fileName);*/
		
		String pathName = File.separator+"Users"+File.separator+"Jinwoo"+File.separator+"SIRIUS"+File.separator+"JAVA";
		sample.checkList(pathName);
	}
	
	public void checkPath(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName+" is exists? ="+file.exists());
		
		System.out.println("Make "+pathName+" result = "+file.mkdir());
		
		System.out.println(pathName+" is directory? = "+file.isDirectory());
		System.out.println(pathName+" is file? = "+file.isFile());
		System.out.println(pathName+" is hidden? = "+file.isHidden());
		
		System.out.println(pathName+" can read? = "+file.canRead());
		System.out.println(pathName+" can write? = "+file.canWrite());
		System.out.println(pathName+" can execute? = "+file.canExecute());
		
		//System.out.println(pathName+" last modified = "+file.lastModified());
		System.out.println(pathName+" last modified = "+ new Date(file.lastModified()));
		
		//System.out.println("Delete "+pathName+" result = "+file.delete());
	}
	
	public void checkFile(String pathName, String fileName) {
		File file = new File(pathName, fileName);
		try {
			System.out.println("Create result = "+file.createNewFile());
			
			System.out.println("Absolute path = "+file.getAbsolutePath());
			System.out.println("Absolute file = "+file.getAbsoluteFile());
			System.out.println("Canonical path = "+file.getCanonicalPath());
			System.out.println("Canonical file = "+file.getCanonicalFile());
			
			System.out.println("Name = "+file.getName());
			System.out.println("Path = "+file.getPath());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
////////////////////////////////////////////////////////////////////////
	
	public void checkList(String pathName) {
		File file;
		try {
			file = new File(pathName);
			//File []mainFileList = file.listFiles();	//directory, file 전부다 뽑아줌.
			//File []mainFileList = file.listFiles(new JPGFilenameFilter()); //이름이 .jpg만 filter해서 뽑아줌.
			File []mainFileList = file.listFiles(new JPGFileFilter()); //.jpg 파일만 filter해서 뽑아줌.
			for(File tempFile:mainFileList) {
				System.out.println(tempFile.getName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
