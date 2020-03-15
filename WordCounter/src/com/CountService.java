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


		FileReader fileReader = new FileReader(file);// 读文件
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String value = bufferedReader.readLine();

		while (value != null) {
			value = value.trim();// 去除前后的空格

			// msg += value + "\n";
			String r = value.replaceAll("\\.", "");
			r = r.replaceAll("[^\\w]", " ");// 特殊符号都去除，变为空格,方便统计单词数
			r = r.replaceAll("\\s+", " ").replaceAll("\"", " ");
			r = r.trim();// 去除头尾的空格
			String s[] = r.split(" ");// 按空格拆分得到单词
			if (!s[0].equals("")) {// 空行不计算单词数
				count += s.length; // 累加单词数
			}

			value = bufferedReader.readLine();// 读取下一行，重新进行循环
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
