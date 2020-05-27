package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.List;

import entity.ArticleInfo;
import entity.AuthorCount;
import util.AuthorIndexUtil;
import util.TitleIndexUtil;

public class BasicSearchService {
	public List<ArticleInfo> getAllInfoByAuthor(String author) throws IOException {
		File file1 = new File("D:\\DBhomework\\authorindex.txt");
		File file2 = new File("D:\\DBhomework\\srcfile1.txt");
		File file3 = new File("D:\\DBhomework\\authorindex2.txt");
		File file4 = new File("D:\\DBhomework\\srcfile2.txt");
		RandomAccessFile raf1 = new RandomAccessFile(file1, "r");
		RandomAccessFile raf2 = new RandomAccessFile(file2, "r");
		RandomAccessFile raf3 = new RandomAccessFile(file3, "r");
		RandomAccessFile raf4 = new RandomAccessFile(file4, "r");
		List<ArticleInfo>articles = AuthorIndexUtil.getArticleByFile(author, raf1, raf2,raf3,raf4);
		return articles;
		
	}
	public List<ArticleInfo> getAllInfoByTitle(String title) throws IOException {
		File file1 = new File("D:\\DBhomework\\titleindex.txt");
		File file2 = new File("D:\\DBhomework\\srcfile1.txt");
		File file3 = new File("D:\\DBhomework\\titleindex2.txt");
		File file4 = new File("D:\\DBhomework\\srcfile2.txt");
		RandomAccessFile raf1 = new RandomAccessFile(file1, "r");
		RandomAccessFile raf2 = new RandomAccessFile(file2, "r");
		RandomAccessFile raf3 = new RandomAccessFile(file3, "r");
		RandomAccessFile raf4 = new RandomAccessFile(file4, "r");
		List<ArticleInfo>articles = TitleIndexUtil.getArticleByFile(title, raf1, raf2,raf3,raf4);
		return articles;
	}

	public static void main(String[] args) throws IOException {
		List<ArticleInfo> list = new BasicSearchService().getAllInfoByAuthor("H. Vincent Poor");
		int i=0;
		for(ArticleInfo a : list)
			i++;
		System.out.println(i);
	}
}
