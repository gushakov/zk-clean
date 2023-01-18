package com.github.zkclean.infrastructure.adapter.zk.greeting;

import com.github.zkclean.core.model.greeting.Greeting;
import com.github.zkclean.core.port.presenter.GreetingPresenterOutputPort;
import com.github.zkclean.infrastructure.adapter.zk.AbstractZkPresenter;
import com.github.zkclean.infrastructure.adapter.zk.ViewBinder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GreetingPresenter extends AbstractZkPresenter implements GreetingPresenterOutputPort {

    private final GreetingViewBinder binder;

    @Override
    protected ViewBinder binder() {
        return binder;
    }

    @Override
    public void showGreeting(Greeting greeting) {

        binder.setGreetingMessage(greeting.getMessage());
        binder.setShoutVisible(greeting.isShout());

        binder.updateView("greetingMessage", "shoutVisible");
    }
}
