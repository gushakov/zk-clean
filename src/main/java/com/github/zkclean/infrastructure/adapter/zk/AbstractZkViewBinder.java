package com.github.zkclean.infrastructure.adapter.zk;

import lombok.Getter;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.DependsOn;

import java.util.Arrays;

/**
 * Default implementation of {@link ViewBinder} which updates the view
 * using a call to {@link BindUtils}.
 *
 * @see BindUtils#postNotifyChange(Object, String...)
 */
public class AbstractZkViewBinder implements ViewBinder {

    @Getter
    private String error;

    @Override
    public void setError(Throwable t) {
        this.error = t.getMessage();
    }

    public void clearErrors() {
        this.error = null;
    }

    @DependsOn("error")
    public boolean getHasErrors() {
        return error != null;
    }

    @Override
    public void updateView(String... properties) {

        if (Arrays.stream(properties).noneMatch("error"::equals)) {
            BindUtils.postNotifyChange(this, addErrorProperty(properties));
        }

    }

    private String[] addErrorProperty(String... properties) {
        String[] copy = Arrays.copyOf(properties, properties.length + 1);
        copy[properties.length] = "error";
        return copy;
    }

}
