package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Mock
    private Clock clock;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void nextHoliday_次の祝日が元日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2019, 12, 31);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("gantan.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が成人の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 1, 3);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("seijin.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が建国記念の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 2, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("kenkokukinen.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が春分の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 3, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("syunbun.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が昭和の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 4, 28);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("syowa.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が憲法記念日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 5, 2);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("kenpokinen.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日がみどりの日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 5, 3);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("midori.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日がこどもの日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 5, 4);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("kodomo.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が海の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 7, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("umi.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が山の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 8, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("yama.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が敬老の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 9, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("keiro.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が秋分の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 9, 21);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("syubun.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が体育の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2019, 10, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("taiiku.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が文化の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 11, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("bunka.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が勤労感謝の日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 11, 15);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("kinrokansya.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日がスポーツの日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 7, 23);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("sport.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が振替休日() throws Exception {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(2020, 5, 5);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        Holiday holiday = demoService.nextHoliday();

        // 検証
        assertAll(
                () -> assertEquals("振替休日", holiday.getName()),
                () -> assertEquals("hurikae.png", holiday.getImage())
        );
    }

    @Test
    void nextHoliday_次の祝日が取得できなかった場合() {

        // 設定
        LocalDate LOCAL_DATE = LocalDate.of(3000, 1, 1);
        Clock fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        when(clock.instant()).thenReturn(fixedClock.instant());
        when(clock.getZone()).thenReturn(fixedClock.getZone());

        // 実行
        // 検証
        assertThrows(Exception.class,
                () -> demoService.nextHoliday());
    }
}