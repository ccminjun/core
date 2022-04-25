package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter tab하면 자동 완성
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); // 타입을 지정 안해서 object가 꺼내짐
            System.out.println("beanDefinitionName = " + beanDefinitionName+ " object = " + bean);
        }
    }

    @Test
    @DisplayName("에플리케이션 빈 출력하기")
    void findApplicationAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter tab하면 자동 완성
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // ROLE_APPLICATION 우리가 등록한 라이브러리
            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName); // 타입을 지정 안해서 object가 꺼내짐
                System.out.println("beanDefinitionName = " + beanDefinitionName+ " object = " + bean);
            }
        }
    }
}
