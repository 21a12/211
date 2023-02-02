package com.ktdsuniversity.edu.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWriter {

	public static File createNewFile() throws IOException {
		File textFile = new File("C:\\logs0", "test.txt");
		textFile.createNewFile();
		return textFile;
	}

	public static File createNewFileThrowRuntimeException() {
		File textFile = new File("C:\\logs0", "test.txt");
		try {
			textFile.createNewFile();
		} catch (IOException ioe) {
			throw new RuntimeException(ioe.getMessage(), ioe);
		}
		return textFile;
	}

	public static void main(String[] args) {

//		File textFile = new File("C:\\logs", "text.txt");
		File textFile = new File("C:\\logs");
		
		if(textFile.isDirectory()) {
			// 경로 안에 존재 유무  &&  파일이 맞는지
//		if (textFile.exists() && textFile.isFile()) {
			
			// 임포트 java.io.FileOutputStream;
			// 임포트 java.io.OutputStream;
			// 클래스와 생성자가 다르므로 인터페이스이거나 추상클래스이거나
			OutputStream fos = null;
			try {
				fos = new FileOutputStream(textFile);
				fos.write("파일 내용을 씁니다.".getBytes());
				fos.flush(); //작성
				fos.close(); //닫기...메모리누수 방지
			} catch (FileNotFoundException e) {
//				e.printStackTrace();
			} catch (IOException e) {
//				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close(); //닫기...메모리누수 방지
					} catch (IOException e) {} 
				}
			}
		} //if (textFile.exists() && textFile.isFile()) {

//		createNewFileThrowRuntimeException();

//		try {
//			createNewFile();
//		} catch (IOException ioe) {
//			System.out.println("err" + ioe.getMessage());
//		}
	}

}
