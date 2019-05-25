package com.example.demo;

import com.example.demo.dto.Holiday;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DemoService {

    private final Resource loadHolidayFile;
    private final Clock clock;

    public Holiday nextHoliday() throws Exception {

        // 祝日のCSVファイルを一括で読み込む
        Path path = Paths.get(loadHolidayFile.getURI());
        List<String> lines = Files.readAllLines(path, Charset.forName("Shift_JIS"));

        // 現在日付取得
        LocalDate nowDate = LocalDate.now(clock);
        // 日付フォーマット
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu/M/d")
                .withResolverStyle(ResolverStyle.STRICT);

        for (String line : lines) {

            // 1行目（ヘッダ行）はスキップ
            if (lines.get(0).equals(line)) {
                continue;
            }

            // holiday[0] = 祝日の日付(yyyy/M/D)
            // holiday[1] = 祝日の名前
            String[] holiday = line.split(",", 0);

            LocalDate holidayDate = LocalDate.parse(holiday[0], dateFormat);

            // ファイル内の日付が現在より未来（直近の祝日）の場合
            if (holidayDate.isAfter(nowDate)) {

                String img;

                if (holiday[1].contains("元日")) {
                    img = "gantan.png";
                } else if (holiday[1].contains("成人の日")) {
                    img = "seijin.png";
                } else if (holiday[1].contains("建国記念の日")) {
                    img = "kenkokukinen.png";
                } else if (holiday[1].contains("春分の日")) {
                    img = "syunbun.png";
                } else if (holiday[1].contains("昭和の日")) {
                    img = "syowa.png";
                } else if (holiday[1].contains("憲法記念日")) {
                    img = "kenpokinen.png";
                } else if (holiday[1].contains("みどりの日")) {
                    img = "midori.png";
                } else if (holiday[1].contains("こどもの日")) {
                    img = "kodomo.png";
                } else if (holiday[1].contains("海の日")) {
                    img = "umi.png";
                } else if (holiday[1].contains("山の日")) {
                    img = "yama.png";
                } else if (holiday[1].contains("敬老の日")) {
                    img = "keiro.png";
                } else if (holiday[1].contains("秋分の日")) {
                    img = "syubun.png";
                } else if (holiday[1].contains("体育の日")) {
                    img = "taiiku.png";
                } else if (holiday[1].contains("文化の日")) {
                    img = "bunka.png";
                } else if (holiday[1].contains("勤労感謝の日")) {
                    img = "kinrokansya.png";
                } else if (holiday[1].contains("スポーツの日")) {
                    img = "sport.png";
                } else {
                    return new Holiday(holiday[0], "振替休日", "hurikae.png");
                }
                return new Holiday(holiday[0], holiday[1], img);
            }
        }
        // 次の祝日が取得できなかった場合は、システムエラー
        throw new Exception();
    }
}
