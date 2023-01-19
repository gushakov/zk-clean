package com.github.zkclean.core.usecase;

import com.github.zkclean.core.GenericGreetingError;
import com.github.zkclean.core.model.greeting.Greeting;
import com.github.zkclean.core.port.operation.GatewayOperationsOutputPort;
import com.github.zkclean.core.usecase.greeting.GreetingInputPort;
import com.github.zkclean.core.usecase.greeting.GreetingUseCase;
import com.github.zkclean.infrastructure.adapter.memory.AddresseeNotFoundError;
import com.github.zkclean.infrastructure.adapter.zk.greeting.GreetingPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GreetingUseCaseTest {

    @Mock
    private GatewayOperationsOutputPort mockGateway;

    @Mock
    private GreetingPresenter mockPresenter;

    private GreetingInputPort useCase;

    @BeforeEach
    void setUp() {
        useCase = new GreetingUseCase(mockPresenter, mockGateway);
    }

    @Test
    void should_present_existing_greeting_for_given_name() {

        lenient().when(mockGateway.load(anyString()))
                .thenReturn(Greeting.builder()
                        .message("Hi, Peter")
                        .shout(false)
                        .build());

        useCase.greetUser("Peter");

        verify(mockPresenter, times(0)).presentError(any());

        ArgumentCaptor<Greeting> greetingArg = ArgumentCaptor.forClass(Greeting.class);

        verify(mockPresenter, times(1)).showGreeting(greetingArg.capture());

        assertThat(greetingArg.getValue())
                .extracting(Greeting::getMessage, Greeting::isShout)
                .containsExactly("Hi, Peter", false);
    }

    @Test
    void should_present_error_if_addressee_not_found() {

        lenient().when(mockGateway.load(anyString()))
                .thenThrow(new AddresseeNotFoundError("Peter"));

        useCase.greetUser("Peter");

        verify(mockPresenter, times(0)).showGreeting(any());

        ArgumentCaptor<Throwable> errorArg = ArgumentCaptor.forClass(Throwable.class);

        verify(mockPresenter, times(1)).presentError(errorArg.capture());

        assertThat(errorArg.getValue()).isInstanceOf(GenericGreetingError.class);
    }
}
