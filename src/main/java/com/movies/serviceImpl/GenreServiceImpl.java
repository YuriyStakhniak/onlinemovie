package com.movies.serviceImpl;

import java.util.List;

import com.movies.validator.Validator;
import com.movies.validator.genreValidator.GenreValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movies.dao.GenreDao;
import com.movies.dao.UserDao;
import com.movies.entity.Genre;
import com.movies.entity.User;
import com.movies.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService{
	

	@Autowired
	@Qualifier("genreValidator")
	private Validator validator;
	@Autowired
    @Qualifier("genreUpdateValidator")
    private Validator updateValidator;
	@Autowired
	private GenreDao genreDao;
	
	public void save(Genre genre) throws Exception {
		validator.validate(genre);
		genreDao.save(genre);
	}

	public List<Genre> findAll() {

		return genreDao.findAll();
	}

	public Genre findOne(int id) {
		return genreDao.findOne(id);
	}

	public void delete(int id) {
		genreDao.delete(id);
	}

	public void update(Genre genre) throws Exception {
	    updateValidator.validate(genre);
        genreDao.save(genre);

}
}