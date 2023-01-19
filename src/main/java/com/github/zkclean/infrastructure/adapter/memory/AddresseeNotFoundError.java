package com.github.zkclean.infrastructure.adapter.memory;

import com.github.zkclean.core.GenericGreetingError;
import lombok.Getter;

public class AddresseeNotFoundError extends GenericGreetingError {

    @Getter
    private final String addressee;

    public AddresseeNotFoundError(String addressee) {
        super("Could not find addressee with name: <%s>. Try with: Brad, George, or Tom.".formatted(addressee));
        this.addressee = addressee;
    }
}
