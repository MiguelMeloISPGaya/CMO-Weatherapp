package models;

import java.sql.Timestamp;

public class Query {

    private int id;
    private long timestamp_last;

    public Query() {

    }

    public Query(long timestamp_last) {
        this.timestamp_last = timestamp_last;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp_last() {
        return timestamp_last;
    }

    public void setTimestamp_last(long timestamp_last) {
        this.timestamp_last = timestamp_last;
    }
}
