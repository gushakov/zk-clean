package com.github.zkclean.core.model.greeting;

import com.github.zkclean.core.model.InvalidDomainObjectError;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.Validate;

@Value
public class Greeting {

    String message;
    boolean shout;

    @Builder
    public Greeting(String message, boolean shout) {
        try {
            this.message = Validate.notBlank(message);
            this.shout = shout;
        } catch (Exception e) {
            throw new InvalidDomainObjectError(Greeting.class);
        }
    }
}
