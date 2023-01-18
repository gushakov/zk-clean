package com.github.zkclean.infrastructure.adapter.zk;

import lombok.Getter;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.DependsOn;

import java.util.Arrays;

public class AbstractZkViewBinder implements ViewBinder {

    @Getter
    private String error;

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    @DependsOn("error")
    public boolean getIsError() {
        return error != null;
    }

    @Override
    public void updateView(String... properties) {
        if (Arrays.stream(properties).noneMatch("error"::equals)){
            // clear error
            error = null;
            // add "error" property to the set of view properties to be updated
            BindUtils.postNotifyChange(this, withError(properties));
        }
        else {
            BindUtils.postNotifyChange(this, properties);
        }
    }

    private String[] withError(String... properties){
        String[] copy = Arrays.copyOf(properties, properties.length + 1);
        copy[properties.length] = "error";
        return copy;
    }

}
