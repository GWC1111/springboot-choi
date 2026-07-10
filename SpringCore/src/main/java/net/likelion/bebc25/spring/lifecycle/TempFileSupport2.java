package net.likelion.bebc25.spring.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.Destroyable;

@Component
public class TempFileSupport2 implements InitializingBean, DisposableBean {
    @Value("resources/temp.log")
    private String filePath;

    public TempFileSupport2() {
        System.out.println("생성자 호출됨." + filePath);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(filePath + "경로의 FileOutStream 생성.");
    }

    public void writeLog(String msg) {
        System.out.println(filePath + "에 로그 저장: " + msg);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(filePath + " 경로의 FileOutputStream 닫기.");
    }
}
