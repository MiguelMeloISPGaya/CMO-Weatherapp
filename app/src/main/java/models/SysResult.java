package models;

import com.google.gson.annotations.SerializedName;

class SysResult {

    @SerializedName("pod")
    private String pod;

    public SysResult() {

    }

    public SysResult(String pod) {
        this.pod = pod;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
