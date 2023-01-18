package com.github.zkclean.infrastructure.adapter.memory;

import com.github.zkclean.core.model.greeting.Greeting;
import com.github.zkclean.core.port.operation.GatewayOperationsOutputPort;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class InMemoryGateway implements GatewayOperationsOutputPort {

    private static final Set<Triple<String, String, Boolean>> pairs = Set.of(
            Triple.of("Brad", "Hello there, %s", true),
            Triple.of("George", "How are you, %s", false),
            Triple.of("Tom", "Howdy, %s", true));

    @Override
    public Greeting load(String name) {
        return pairs.stream().filter(triple -> triple.getLeft().equals(name))
                .map(triple -> Greeting.builder()
                        .message(triple.getMiddle().formatted(triple.getLeft()))
                        .shout(triple.getRight())
                        .build())
                .findAny().orElseThrow(() -> new AddresseeNotFoundError(name));
    }
}
