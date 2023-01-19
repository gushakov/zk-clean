package com.github.zkclean.infrastructure.adapter.zk.greeting;

import com.github.zkclean.core.model.greeting.Greeting;
import com.github.zkclean.infrastructure.adapter.memory.AddresseeNotFoundError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit test for {@link GreetingPresenter}.
 */
@ExtendWith(MockitoExtension.class)
public class GreetingPresenterTest {

    // we mock a view binder implementation used
    // to create instances of the presenter we
    // are going to test
    @Mock
    private GreetingViewBinder mockBinder;

    private GreetingPresenter presenter;

    @BeforeEach
    void setUp() {

        this.presenter = new GreetingPresenter(mockBinder);
    }

    @Test
    void should_set_message_and_shout_mode_from_greeting() {
        Greeting greeting = Greeting.builder()
                .message("Hi, Peter!")
                .shout(true)
                .build();

        // when asked to present a greeting
        presenter.showGreeting(greeting);

        // verify that presenter has correctly set appropriate
        // properties in the view binder
        verify(mockBinder, times(1)).setGreetingMessage("Hi, Peter!");
        verify(mockBinder, times(1)).setShoutVisible(true);

        // also verify that any (previous) errors were cleared
        verify(mockBinder, times(1)).clearErrors();
    }

    @Test
    void should_set_error_property_when_presenting_error() {

        presenter.presentError(new AddresseeNotFoundError("Peter"));

        ArgumentCaptor<AddresseeNotFoundError> errorArg = ArgumentCaptor.forClass(AddresseeNotFoundError.class);

        verify(mockBinder, times(1)).setError(errorArg.capture());

        assertThat(errorArg.getValue()).isInstanceOf(AddresseeNotFoundError.class);
    }
}
