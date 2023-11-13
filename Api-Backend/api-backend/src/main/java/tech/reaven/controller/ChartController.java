package tech.reaven.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.reaven.model.ChartData;
import tech.reaven.service.ChartService;
import java.util.Date;

@RequestMapping("/chart")
@RestController
public class ChartController {
    @Autowired
    private ChartService chartService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/daily")
    public ResponseEntity<List<ChartData>> getDailyPrice(){
        List<ChartData> list = chartService.getDailyPrice();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/threemonths")
    public ResponseEntity<List<ChartData>> getThreeMonths(){
        List<ChartData> list = chartService.getThreeMonths();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/oneyear")
    public ResponseEntity<List<ChartData>> getOneYear(){
        List<ChartData> list = chartService.getOneYear();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/threeyears")
    public ResponseEntity<List<ChartData>> getThreeYears(){
        List<ChartData> list = chartService.getThreeYears();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/fiveyears")
    public ResponseEntity<List<ChartData>> getFiveYears(){
        List<ChartData> list = chartService.getFiveYears();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
