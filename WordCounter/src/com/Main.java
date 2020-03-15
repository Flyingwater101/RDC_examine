package com;

import java.io.File;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) throws Exception {
	        System.out.println(
	        		"-c file.c    �����ļ� file.c ���ַ���\n" +
	                "-w file.c    �����ļ� file.c �Ĵʵ���Ŀ  \n" +
	                "-l file.c    �����ļ� file.c ������  \n" );
	        Scanner input = new Scanner(System.in);
	        while (true) {
	            System.out.println("please input '[order] [filename]':");
	            String order[] = input.nextLine().split(" ");
	            CountService countService = new CountService();

	            if (order.length==2) {
	                        File file = new File(order[1]);
	                        if(!file.exists()){
	                            System.out.println("�ļ������ڣ�����������");
	                        }
	                        else if(file.isDirectory()){ //�����ΪĿ¼ʱ��
	                        	System.out.println("��������ȷ�ļ���ַ");
	                        }
	                        else {

	                                if (order[0].equals("-c")) {
	                                    System.out.println("�ı����ַ���Ϊ" + countService.countChar(file));
	                                } else if (order[0].equals("-w")) {
	                                    System.out.println("�ı����ַ���Ϊ" + countService.countWord(file));
	                                } else if (order[0].equals("-l")) {
	                                    System.out.println("�ı�������Ϊ" + countService.countLine(file));
	                                }else {
	                                    System.out.println("������������������");
	                                }
	                        }
	            }else System.out.println("������������������");
	        }
	 }
}
