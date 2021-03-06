package com.project.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PageNotFoundControllerTest {

    @InjectMocks
    private PageNotFoundController pageNotFoundController;

    @Test
    void testGetErrorPage() {
        String result = pageNotFoundController.getErrorPage();

        assertEquals("error", result);
    }
}