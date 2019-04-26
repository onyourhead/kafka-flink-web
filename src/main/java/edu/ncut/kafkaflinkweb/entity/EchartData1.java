package edu.ncut.kafkaflinkweb.entity;

import java.util.List;

public class EchartData1 {
    List<Long> timestamp;
    List<Double> value;

    public EchartData1(List<Long> timestamp, List<Double> value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public List<Long> getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(List<Long> timestamp) {
        this.timestamp = timestamp;
    }

    public List<Double> getValue() {
        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }
}
