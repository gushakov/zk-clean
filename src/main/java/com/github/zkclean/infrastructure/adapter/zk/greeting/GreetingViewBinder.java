package com.github.zkclean.infrastructure.adapter.zk.greeting;

import com.github.zkclean.infrastructure.adapter.zk.AbstractZkViewBinder;
import lombok.Getter;
import lombok.Setter;

/**
 * POJO bean which regroups all data bound to the "greeting" view.
 */
public class GreetingViewBinder extends AbstractZkViewBinder {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String greetingMessage;

    @Setter
    private boolean shoutVisible;

    public boolean getShoutVisible() {
        return shoutVisible;
    }

}
