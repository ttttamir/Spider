package com.xgen.spider;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.xgen.spider.Film;

@Root(name = "film-list")
public class FilmList {

	// 委托
	@ElementList(inline = true)
	ArrayList<Film> list;

	public FilmList() {
		list = new ArrayList<>();
	}

	public void add(Film film) {
		// 封装（包装）
		list.add(film);
	}

	@Override
	public String toString() {
		return "FilmList [list=" + list + "]";
	}
	
}

