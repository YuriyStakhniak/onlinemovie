package com.movies.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movies.dao.StarDao;
import com.movies.entity.Star;
import com.movies.service.StarService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StarsServiceImpl implements StarService {

    @Autowired
    private StarDao starDao;

    @Autowired
    @Qualifier("starValidator")
    private Validator validator;
    @Autowired
    @Qualifier("starUpdateValidator")
    private Validator updateValidator;

    public void save(Star star, MultipartFile image) throws Exception {
        validator.validate(star);
        starDao.saveAndFlush(star);

        String path = System.getProperty("catalina.home") + "/resources/"
                + star.getName() + "/" + image.getOriginalFilename();

        star.setPathImage("resources/" + star.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        starDao.save(star);
    }


    public List<Star> findAll() {
        return starDao.findAll();
    }

    public Star findOne(int id) {
        return starDao.findOne(id);
    }

    public void delete(int id) {

        starDao.delete(id);

    }

    public void update(Star star, MultipartFile image) throws Exception {
        updateValidator.validate(star);
        String path = System.getProperty("catalina.home") + "/resources/" +
                star.getName() + "/" + image.getOriginalFilename();
        star.setPathImage("resources/" + star.getName() + "/" + image.getOriginalFilename());
        File filePath = new File(path);
        try {
            filePath.mkdirs();
            image.transferTo(filePath);

        } catch (IOException e) {

            System.out.println("e = " + e);
        }
        starDao.save(star);

    }

    @Override
    public List<Star> starsWithMovies() {
        return starDao.starsWithMovies();
    }
}
