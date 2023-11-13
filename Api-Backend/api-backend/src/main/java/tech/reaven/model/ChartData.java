package tech.reaven.model;

import lombok.Data;
import java.util.Date;

@Data
public class ChartData {
    private Date timeData;
    private int priceData;
    public ChartData(Date timeData, int priceData) {
        this.timeData = timeData;
        this.priceData = priceData;
    }
}