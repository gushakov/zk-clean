package com.github.zkclean.core.model;

import com.github.zkclean.core.GeneticGreetingError;
import lombok.Getter;

public class InvalidDomainObjectError extends GeneticGreetingError {

    @Getter
    private final Class<?> modelType;

    public InvalidDomainObjectError(Class<?> modelType) {
        super("Cannot create domain object of type: <%s> using provided arguments".formatted(modelType.getName()));
        this.modelType = modelType;
    }
}
