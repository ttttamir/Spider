package com.xgen.spider;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class App {
	public static void main(String[] args) {
		
		FilmList list = new FilmList();

		ExecutorService pool = Executors.newFixedThreadPool(25);

		for (int i = 0; i < 25; i++) {
			pool.submit(new Target(i+1,list));
		}
		
//		System.out.println(list.toString());
		
		pool.shutdown();
		
		
		Persister persister = new Persister();
		try {
			Thread.sleep(5000);
			persister.write(list, new File("filmFile2.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
