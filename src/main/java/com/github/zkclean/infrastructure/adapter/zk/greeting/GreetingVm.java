package com.github.zkclean.infrastructure.adapter.zk.greeting;

import com.github.zkclean.core.usecase.greeting.GreetingInputPort;
import lombok.Getter;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.spring.SpringUtil;

public class GreetingVm {

    @Getter
    private GreetingViewBinder binder;

    @Init
    public void init(){
        this.binder = new GreetingViewBinder();
    }

    @Command
    public void greet(){
        useCase().greetUser(binder.getName());
    }

    private GreetingInputPort useCase(){
        return SpringUtil.getApplicationContext().getBean(GreetingInputPort.class, binder);
    }

}
