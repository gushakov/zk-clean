package com.github.zkclean.core.port.operation;

import com.github.zkclean.core.model.greeting.Greeting;

public interface GatewayOperationsOutputPort {

    Greeting load(String name);

}
