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

        // actually present the greeting
        binder.setGreetingMessage(greeting.getMessage());
        // and set the modality: shout or not
        binder.setShoutVisible(greeting.isShout());

        // clear any errors
        binder.clearErrors();

        // update the view
        binder.updateView("greetingMessage", "shoutVisible");
    }
}
