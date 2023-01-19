package com.github.zkclean.infrastructure.adapter.zk.greeting;

import com.github.zkclean.core.usecase.greeting.GreetingInputPort;
import lombok.Getter;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.spring.SpringUtil;

/**
 * View-model used by "greeting.zul". Will act as a controller.
 */
public class GreetingVm {

    @Getter
    private GreetingViewBinder binder;

    private GreetingInputPort useCase;

    @Init
    public void init() {
        // initialize the view binder
        this.binder = new GreetingViewBinder();

        // get the use case from the application context
        this.useCase = SpringUtil.getApplicationContext().getBean(GreetingInputPort.class, binder);
    }

    @Command
    public void greet() {
        useCase.greetUser(binder.getName());
    }

}
