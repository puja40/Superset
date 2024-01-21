package com.puja.yadav.supersetURL.Superset;

import com.puja.yadav.supersetURL.Superset.Controller.SuperSetController;
import com.puja.yadav.supersetURL.Superset.Service.Report;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class SuperSetURLControllerTest {

    @Mock
    private Report service;

    @InjectMocks
    private SuperSetController superSetURLController;

    @Test
    public void testGetSupersetURL_Success() {
        // Arrange
        String mockSupersetURL = "http://example.com";
        when(service.getSuperSetURL()).thenReturn(mockSupersetURL);

        // Act
        ResponseEntity<String> response = superSetURLController.getSupersetURL();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockSupersetURL, response.getBody());
    }

    @Test
    public void testGetSupersetURL_NotFound() {
        // Arrange
        when(service.getSuperSetURL()).thenReturn(null);

        // Act
        ResponseEntity<String> response = superSetURLController.getSupersetURL();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Superset URL not found", response.getBody());
    }

    @Test
    public void testGetSupersetURL_InternalServerError() {
        // Arrange
        when(service.getSuperSetURL()).thenThrow(new RuntimeException("Some internal error"));

        // Act
        ResponseEntity<String> response = superSetURLController.getSupersetURL();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal Server Error", response.getBody());
    }
}
