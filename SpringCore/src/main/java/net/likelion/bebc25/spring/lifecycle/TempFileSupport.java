package net.likelion.bebc25.spring.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class TempFileSupport {
    @Value("resources/temp.log")
    private String filePath;

    public TempFileSupport() {
        System.out.println("생성자 호출됨." + filePath);
    }

    @PostConstruct
    public void init() {
        System.out.println(filePath + "경로의 FileOutStream 생성.");
    }

    public void writeLog(String msg) {
        System.out.println(filePath + "에 로그 저장: " + msg);
    }

    @PreDestroy
    public void close() {
        System.out.println(filePath + " 경로의 FileOutputStream 닫기.");
    }
}
