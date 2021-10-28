package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@SpringBootTest
@ExtendWith(SpringExtension.class)
class SampleServiceImplTest {
    @Autowired
    private SampleService sampleService;

    @Test
    public void proxyCreationTest() {
        log.info(sampleService);
        log.info(sampleService.getClass().getName());
        //com.example.demo.service.SampleServiceImpl$$EnhancerBySpringCGLIB$$e099a045로 만들어지는데?
        //"com.sun.proxy.$프록시번호" 가 아니라..?
        // => 속성에서 spring.aop.proxy-target-class=false로 설정해주니까 proxy.$프록시번호로 만드네.
        // 근데 이게 뭐 한 건지..
        // springboot은 cglib 방식이 default라고 함. unexpected cast exception이 덜 발생한다는데...

    }

    @Test
    public void addTest() throws Exception {
        // 1. before advice
        //이거 실행하면 advice가 add 하기 전에 실행됨.
        //before advice를 만들어 놓고, 연결시켜 놓아서 그럼.
        log.info(sampleService.add("123", "234"));

        //[실행 결과]
        // com.example.demo.aop.LogAdvice           : ========================
        // 2021-10-28 20:30:30.829  INFO 5068 --- [           main] c.e.demo.service.SampleServiceImplTest   : 3

        // 2. after throwing
        //AOP가 좀 유용하긴 하네
        //log.info(sampleService.add("123","ABC"));

        // 3. around

    }
}