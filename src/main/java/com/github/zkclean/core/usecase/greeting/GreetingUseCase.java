package com.github.zkclean.core.usecase.greeting;

import com.github.zkclean.core.GenericGreetingError;
import com.github.zkclean.core.model.greeting.Greeting;
import com.github.zkclean.core.port.operation.GatewayOperationsOutputPort;
import com.github.zkclean.core.port.presenter.GreetingPresenterOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GreetingUseCase implements GreetingInputPort {

    private final GreetingPresenterOutputPort presenter;

    private final GatewayOperationsOutputPort gatewayOps;

    @Override
    public void greetUser(String name) {

        final Greeting greeting;

        try {
            // load greeting model from the gateway
            greeting = gatewayOps.load(name);

        } catch (GenericGreetingError e) {
            presenter.presentError(e);
            return;
        }

        presenter.showGreeting(greeting);

    }
}
