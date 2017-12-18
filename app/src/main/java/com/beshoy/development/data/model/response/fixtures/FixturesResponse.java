
package com.beshoy.development.data.model.response.fixtures;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FixturesResponse {

    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = null;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}
