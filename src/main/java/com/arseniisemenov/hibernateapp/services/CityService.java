package com.arseniisemenov.hibernateapp.services;

import com.arseniisemenov.hibernateapp.dao.CityDao;
import com.arseniisemenov.hibernateapp.models.City;

import java.util.List;

public class CityService {
    private CityDao cityDao;
    public CityService() {
        cityDao = new CityDao();
    }

    public City findCity(int id) {
        return cityDao.findById(id);
    }

    public List<City> findAllCities() {
        return cityDao.findAll();
    }

    public void saveCity(City city) {
        cityDao.save(city);
    }

    public void updateCity(City city) {
        cityDao.update(city);
    }

    public void deleteCity(City city) {
        cityDao.delete(city);
    }

    public List<City> searchCities(String name, Integer citizens, String story) {
        return cityDao.searchCities(name, citizens, story);
    }
}
