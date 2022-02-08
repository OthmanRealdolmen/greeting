package com.realdolmen.devops.greeting;

import com.realdolmen.devops.greeting.GreetingController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class GreetingControllerTest {

    @InjectMocks
    private GreetingController greetingController;

    @Test
    void whenCallingGreetingMethode_returnHello(){
        String answer = greetingController.hello();

        assertThat(answer).isEqualTo("hello");
    }
}
