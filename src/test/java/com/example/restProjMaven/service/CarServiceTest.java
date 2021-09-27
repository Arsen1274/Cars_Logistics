package com.example.restProjMaven.service;

import com.example.restProjMaven.exception.CarNotFoundException;
import com.example.restProjMaven.repository.CarRepo;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CarServiceTest {

    @Autowired
    private CarRepo carRepo;

    @InjectMocks
    private CarService carService;

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void getCarsService_throwsException_ifCarNotFound() {
        // given
        // CarRepo carRepo = Mockito.mock(CarRepo.class);
        when(carRepo.findAll()).thenReturn(emptyList());
        // when
        // then
        assertThatThrownBy(() -> carService.getCarsService())
                .isInstanceOf(CarNotFoundException.class)
                .hasMessage("No registered cars");
    }
}
