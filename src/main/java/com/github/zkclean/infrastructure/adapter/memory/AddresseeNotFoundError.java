package com.github.zkclean.infrastructure.adapter.memory;

import com.github.zkclean.core.GeneticGreetingError;
import lombok.Getter;

public class AddresseeNotFoundError extends GeneticGreetingError {

    @Getter
    private final String addressee;

    public AddresseeNotFoundError(String addressee) {
        super("Could not find addressee with name: <%s> ".formatted(addressee));
        this.addressee = addressee;
    }
}
