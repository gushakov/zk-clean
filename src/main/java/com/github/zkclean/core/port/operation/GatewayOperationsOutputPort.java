package com.github.zkclean.core.port.operation;

import com.github.zkclean.core.model.greeting.Greeting;

public interface GatewayOperationsOutputPort {

    /**
     * Loads a {@link Greeting} for a given addressee's {@code name} if there is one in the store.
     *
     * @param name name of the addressee
     * @return greeting
     * @throws com.github.zkclean.infrastructure.adapter.memory.AddresseeNotFoundError if no greeting could be found for
     *                                                                                 the addressee
     */
    Greeting load(String name);

}
