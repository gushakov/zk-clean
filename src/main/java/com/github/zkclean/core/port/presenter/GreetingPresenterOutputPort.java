package com.github.zkclean.core.port.presenter;

import com.github.zkclean.core.model.greeting.Greeting;

public interface GreetingPresenterOutputPort extends ErrorHandlingPresenterOutputPort {
    void showGreeting(Greeting greeting);
}
