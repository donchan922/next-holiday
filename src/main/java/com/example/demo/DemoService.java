package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DemoService {

    public Holiday nextHoliday() throws Exception {

        // 祝日のCSVファイルを読み込む
        InputStream is = new ClassPathResource("syukujitsu.csv").getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "SJIS"));

        Date sysDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");

        String line;

        // 1行ずつCSVファイルを読み込む
        for (int i = 0; (line = br.readLine()) != null; i++) {

            // 1行目（ヘッダ行）はスキップ
            if (i == 0) {
                continue;
            }

            // holiday[0] = 祝日の日付(yyyy/M/D), holiday[1] = 祝日の名前
            String[] holiday = line.split(",", 0);

            // 現在日時より未来の祝日の場合
            if (sdf.parse(holiday[0]).after(sysDate)) {

                String img;

                if (holiday[1].contains("元旦")) {
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
                    br.close();
                    return new Holiday(holiday[0], "振替休日", "hurikae.png");
                }
                br.close();
                return new Holiday(holiday[0], holiday[1], img);
            }
        }
        br.close();
        // 次の祝日が取得できなかった場合は、システムエラー
        throw new Exception();
    }
}
