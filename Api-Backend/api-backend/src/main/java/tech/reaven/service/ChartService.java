package tech.reaven.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reaven.model.ChartData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.lang.Math;
import java.util.Collections;
@Service
@AllArgsConstructor
public class ChartService {
    public void generateData(int number,List<ChartData> list,int day) {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        int price = (int) Math.floor(Math.random() * (700 - 50 + 1)) + 50;
        int minPrice;
        int maxPrice;
        for (int i = 0; i < number; i++) {
            minPrice = price - price * 4 / 100;
            maxPrice = price + price * 4 / 100;
            price = (int) Math.floor(Math.random() * (maxPrice - minPrice + 1)) + minPrice;
            list.add(new ChartData(date, price));
            c.add(Calendar.DAY_OF_YEAR,-day);
            date=c.getTime();
        }
        Collections.reverse(list);
    }
    public List<ChartData> getDailyPrice() {
        List<ChartData> list = new ArrayList<ChartData>();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,8);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        Date date = c.getTime();
        int price = (int) Math.floor(Math.random() * (700 - 50 + 1)) + 50;
        int minPrice;
        int maxPrice;
        for (int i = 0; i <= 14; i++) {
            minPrice = price - price * 4 / 100;
            maxPrice = price + price * 4 / 100;
            price = (int) Math.floor(Math.random() * (maxPrice - minPrice + 1)) + minPrice;
            list.add(new ChartData(date, price));
            c.add(Calendar.HOUR,1);
            date=c.getTime();
        }
        return list;
    }
    public List<ChartData> getThreeMonths() {
        List<ChartData> list = new ArrayList<ChartData>();
        this.generateData(90,list,1);//get price everyday
        return list;
    }
    public List<ChartData> getOneYear() {
        List<ChartData> list = new ArrayList<ChartData>();
        this.generateData(180,list,2);//get price every two days
        return list;
    }
    public List<ChartData> getThreeYears() {
        List<ChartData> list = new ArrayList<ChartData>();
        this.generateData(540,list,2);//get price every two days
        return list;
    }
    public List<ChartData> getFiveYears() {
        List<ChartData> list = new ArrayList<ChartData>();
        this.generateData(900,list,2);//get price every two days
        return list;
    }
}
