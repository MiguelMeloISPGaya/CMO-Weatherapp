package models;

import com.google.gson.annotations.SerializedName;

class CloudsResult {

    @SerializedName("all")
    private String all;

    public CloudsResult() {
    }

    public CloudsResult(String all) {
        this.all = all;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }
}
