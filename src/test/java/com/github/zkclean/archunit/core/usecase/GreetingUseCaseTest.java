package com.github.zkclean.archunit.core.usecase;

import com.github.zkclean.core.model.greeting.Greeting;
import com.github.zkclean.core.port.operation.GatewayOperationsOutputPort;
import com.github.zkclean.core.usecase.greeting.GreetingInputPort;
import com.github.zkclean.core.usecase.greeting.GreetingUseCase;
import com.github.zkclean.infrastructure.adapter.zk.greeting.GreetingPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class GreetingUseCaseTest {

    @Mock
    private GatewayOperationsOutputPort mockGateway;

    @Mock
    private GreetingPresenter mockPresenter;

    private GreetingInputPort useCase;

    @BeforeEach
    void setUp() {
        lenient().when(mockGateway.load(anyString()))
                .thenReturn(Greeting.builder()
                        .message("Hi, test")
                        .shout(false)
                        .build());

        useCase = new GreetingUseCase(mockPresenter, mockGateway);
    }

    @Test
    void should_present_existing_greeting_for_given_name() {
        useCase.greetUser("Peter");
    }
}
