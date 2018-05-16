package com.movies.editors;

import java.beans.PropertyEditorSupport;

import com.movies.entity.Genre;
import com.movies.service.GenreService;

public class GenreEditor extends PropertyEditorSupport {
	
	private final GenreService genreservice;

	public GenreEditor(GenreService genreservice) {
		this.genreservice = genreservice;
	}

	@Override
	public void setAsText(String idFromJsp) throws IllegalArgumentException {

		System.out.println(1111);
		Genre genres = genreservice.findOne(Integer.parseInt(idFromJsp));
		setValue(genres);


	}
	

}
