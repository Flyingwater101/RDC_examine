package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountService {
	public long countChar(File file) {
		if (!file.exists()) {
			return -1L;
		}
		return file.length();
	}

	public long countWord(File file) throws Exception {

		if (!file.exists()) {
			return -1L;
		}
		long count = 0L;


		FileReader fileReader = new FileReader(file);// ���ļ�
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String value = bufferedReader.readLine();

		while (value != null) {
			value = value.trim();// ȥ��ǰ��Ŀո�

			// msg += value + "\n";
			String r = value.replaceAll("\\.", "");
			r = r.replaceAll("[^\\w]", " ");// ������Ŷ�ȥ������Ϊ�ո�,����ͳ�Ƶ�����
			r = r.replaceAll("\\s+", " ").replaceAll("\"", " ");
			r = r.trim();// ȥ��ͷβ�Ŀո�
			String s[] = r.split(" ");// ���ո��ֵõ�����
			if (!s[0].equals("")) {// ���в����㵥����
				count += s.length; // �ۼӵ�����
			}

			value = bufferedReader.readLine();// ��ȡ��һ�У����½���ѭ��
		}

		bufferedReader.close();

		fileReader.close();

		return count;
	}

	public long countLine(File file) throws Exception {

		if (!file.exists()) {
			return -1L;
		}
		long count = 0L;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.readLine() != null) {
			count++;
		}

		fileReader.close();
		bufferedReader.close();

		return count;
	}
}
