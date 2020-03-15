package com;

import java.io.File;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) throws Exception {
	        System.out.println(
	        		"-c file.c    返回文件 file.c 的字符数\n" +
	                "-w file.c    返回文件 file.c 的词的数目  \n" +
	                "-l file.c    返回文件 file.c 的行数  \n" );
	        Scanner input = new Scanner(System.in);
	        while (true) {
	            System.out.println("please input '[order] [filename]':");
	            String order[] = input.nextLine().split(" ");
	            CountService countService = new CountService();

	            if (order.length==2) {
	                        File file = new File(order[1]);
	                        if(!file.exists()){
	                            System.out.println("文件不存在，请重新输入");
	                        }
	                        else if(file.isDirectory()){ //输入的为目录时候
	                        	System.out.println("请输入正确文件地址");
	                        }
	                        else {

	                                if (order[0].equals("-c")) {
	                                    System.out.println("文本的字符数为" + countService.countChar(file));
	                                } else if (order[0].equals("-w")) {
	                                    System.out.println("文本的字符数为" + countService.countWord(file));
	                                } else if (order[0].equals("-l")) {
	                                    System.out.println("文本的行数为" + countService.countLine(file));
	                                }else {
	                                    System.out.println("输入有误，请重新输入");
	                                }
	                        }
	            }else System.out.println("输入有误，请重新输入");
	        }
	 }
}
