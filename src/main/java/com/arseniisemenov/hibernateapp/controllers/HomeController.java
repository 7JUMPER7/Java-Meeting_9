package com.arseniisemenov.hibernateapp.controllers;

import com.arseniisemenov.hibernateapp.models.City;
import com.arseniisemenov.hibernateapp.services.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index"})
    public String Index(Map<String, Object> model) {
        CityService cityService = new CityService();
        model.put("cities", cityService.findAllCities());
        return "/index";
    }

    @GetMapping(value = "/add")
    public String CreateView() {
        return "/create";
    }
    @PostMapping(value = "/add")
    public RedirectView Create(@RequestParam(name = "name") String name,
                               @RequestParam(name = "citizens") int citizens,
                               @RequestParam(name = "story") String story,
                               @RequestParam(name = "coordinates") String coordinates) {
        City city = new City(name, citizens, story, coordinates);
        CityService cityService = new CityService();
        cityService.saveCity(city);
        return new RedirectView("/");
    }

    @GetMapping(value = "/edit/{id}")
    public String EditView(Map<String, Object> model, @PathVariable(name = "id") int id) {
        CityService cityService = new CityService();
        City city = cityService.findCity(id);
        if(city != null) {
            model.put("city", city);
            return "/edit";
        }
        model.put("cities", cityService.findAllCities());
        return "/index";
    }
    @PostMapping(value = "/edit/{id}")
    public RedirectView Edit(@PathVariable(name = "id") int id,
                       @RequestParam(name = "name") String name,
                       @RequestParam(name = "citizens") int citizens,
                       @RequestParam(name = "story") String story,
                       @RequestParam(name = "coordinates") String coordinates) {
        City city = new City(name, citizens, story, coordinates);
        city.setId(id);
        CityService cityService = new CityService();
        cityService.updateCity(city);
        return new RedirectView("/");
    }

    @GetMapping(value = "/delete/{id}")
    public RedirectView Delete(@PathVariable(name = "id") int id) {
        CityService cityService = new CityService();
        City city = cityService.findCity(id);
        if(city != null) {
            cityService.deleteCity(city);
        }
        return new RedirectView("/");
    }

    @GetMapping(value = "/search")
    public String Search(Map<String, Object> model,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "citizens") String citizensString,
                         @RequestParam(name = "story") String story) {
        Integer citizens = null;
        try {
            citizens = Integer.parseInt(citizensString);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        CityService cityService = new CityService();
        model.put("cities", cityService.searchCities(name, citizens, story));
        return "/index";
    }
}
