package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DemoControllerTest {

    @Mock
    private DemoService demoService;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new DemoController(demoService)).build();
    }

    @Test
    void 正常() throws Exception {

        // 実行
        // 検証
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk());
        assertAll(
                () -> verify(demoService, times(1)).nextHoliday()
        );
    }

    @Test
    void 例外発生() throws Exception {

        // 設定
        doThrow(new Exception()).when(demoService).nextHoliday();

        // 実行
        // 検証
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk());
        assertAll(
                () -> verify(demoService, times(1)).nextHoliday(),
                () -> assertThrows(Exception.class,
                        () -> demoService.nextHoliday()
                )
        );
    }
}
