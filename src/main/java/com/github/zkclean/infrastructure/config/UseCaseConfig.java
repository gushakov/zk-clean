package com.github.zkclean.infrastructure.config;

import com.github.zkclean.core.port.operation.GatewayOperationsOutputPort;
import com.github.zkclean.core.usecase.greeting.GreetingInputPort;
import com.github.zkclean.core.usecase.greeting.GreetingUseCase;
import com.github.zkclean.infrastructure.adapter.zk.greeting.GreetingViewBinder;
import com.github.zkclean.infrastructure.adapter.zk.greeting.GreetingPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class UseCaseConfig {

    private final GatewayOperationsOutputPort gatewayOps;

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public GreetingInputPort greetingUseCase(GreetingViewBinder binder) {
        return new GreetingUseCase(new GreetingPresenter(binder), gatewayOps);
    }

}
