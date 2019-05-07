package hard.study.spring.bean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/applicationContext.xml" })
public class BeanConfigurationByXmlTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void init() {
//        applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
    }

    @Test
    public void 프로퍼티를_이용한_빈주입_테스트() {

        Avante car = applicationContext.getBean("bean1-1", Avante.class);
        assertNotNull(car.getEngine());

        System.out.println(car);
    }

}
