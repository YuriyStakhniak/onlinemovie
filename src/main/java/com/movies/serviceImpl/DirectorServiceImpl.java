package com.movies.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.movies.dao.MovieDao;
import com.movies.entity.Movie;
import com.movies.validator.Validator;
import com.movies.validator.directorValidator.DirectorValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movies.dao.DirectorDao;
import com.movies.entity.Director;
import com.movies.service.DirectorService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    @Qualifier("directorValidator")
    private Validator validator;
    @Autowired
    @Qualifier("directorUpdateValidator")
    private Validator updateValidator;

	@Autowired
	private DirectorDao directorDao;


    @Transactional
	@Override
    public void save(Director director, String name, String about, MultipartFile image)
            throws Exception {
        validator.validate(director);
        directorDao.saveAndFlush(director);

        String path = System.getProperty("catalina.home") + "/resources/" +
                director.getName() + "/" + image.getOriginalFilename();
        director.setPathImage("resources/" + director.getName() + "/" + image.getOriginalFilename());
        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);

        }catch (IOException e){

            System.out.println("e = " + e);
        }

        directorDao.save(director);

    }

    @Override
    public List<Director> findAll() {
        return directorDao.findAll();
    }

    @Override
    public Director findOne(int id) {
        return directorDao.findOne(id);
    }

    @Override
    public void delete(int id) throws Exception {
        directorDao.delete(id);
    }


    @Override
    public void update(Director director, String name, String about, MultipartFile image) throws Exception {
        updateValidator.validate(director);
        String path = System.getProperty("catalina.home") + "/resources/" +
                director.getName() + "/" + image.getOriginalFilename();
        director.setPathImage("resources/" + director.getName() + "/" + image.getOriginalFilename());
        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);

        }catch (IOException e){

            System.out.println("e = " + e);
        }


        director.setName(name);
        director.setAbout(about);
        directorDao.save(director);



    }

    @Override
    public List<Director> directorsWithMovies() {
        return directorDao.directorsWithMovies();
    }


    @Override
    public Director directorWithMovies(int id) {
        return directorDao.directorWithMovies(id);
    }
}
