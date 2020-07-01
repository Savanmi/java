package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RecordBook implements Serializable {
    private List<Integer> records;
    private int numberOfRecords;

    RecordBook(){
        records = new ArrayList<>();
        numberOfRecords = 0;
    }

    void addNewRecord(int record) {
          numberOfRecords++;
        records.add(record);
        sortRecords();
    }

    private void sortRecords(){
        java.util.Collections.sort(records);
        java.util.Collections.reverse(records);
    }

    public int getRecord(int index){
        return records.get(index);
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }
}
