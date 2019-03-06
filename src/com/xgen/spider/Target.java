package com.xgen.spider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.simpleframework.xml.core.Persister;

public class Target implements Runnable {
	
	String filmName;
	String filmTime;
	ArrayList<String> actors = new ArrayList<>();
	String director;
	int n;
	Film film = new Film();
	FilmList list;
	
	

	public Target(int n,FilmList list) {
		super();
		this.n = n;
		this.list = list;
	}

	@Override
	public void run() {
		try {
			Document doc1 = Jsoup.connect("https://movie.douban.com/top250").get();
			// 获得此电影主页
			Elements e1 = doc1.select(".hd a");
			String httf = e1.get(n - 1).attr("href");
			Document doc2 = Jsoup.connect(httf).get();
			// 获得电影名称
			Elements e4 = doc2.select("h1");
			filmName = e4.text();
			// 导演
			Elements e2 = doc2.select(".attrs a");
			director = e2.first().text();
			// 演员
			Elements e3 = doc2.select(".actor .attrs a");
			for (int i = 0; i < e3.size(); i++) {
				actors.add(i, e3.get(i).text());
			}
			// 电影时长
			Elements e5 = doc2.select("#info content");
			filmTime = e5.text();
			System.out.println(filmTime);

			film.setFilmName(filmName);
			film.setDirector(director);
			film.setActors(actors);
			list.add(film);
			
			
			
			
			// Document doc2 = Jsoup.connect(e2.attr("href")).get();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@Override
//	public String toString() {
//		return "Target [Actors=" + Actors + "]";
//	}

}
