package hard.study.spring.bean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.beans.factory.support.AbstractBeanDefinition.AUTOWIRE_BY_NAME;
import static org.springframework.beans.factory.support.AbstractBeanDefinition.AUTOWIRE_BY_TYPE;

public class PopulateBeanTests {

    DefaultListableBeanFactory factory;

    @Before
    public void init() {
        factory = new DefaultListableBeanFactory();
    }

    @Test
    public void 빈_이름_주입_테스트() {
        RootBeanDefinition avante = new RootBeanDefinition();
        avante.setBeanClass(Avante.class);
        avante.setAutowireMode(AUTOWIRE_BY_NAME);

        RootBeanDefinition strongEngine = new RootBeanDefinition();
        strongEngine.setBeanClass(StrongEngine.class);

        factory.registerBeanDefinition("avante", avante);
        factory.registerBeanDefinition("engine", strongEngine);

        Avante avanteBean = factory.getBean("avante", Avante.class);

        assertNotNull(avanteBean.getEngine());
        avanteBean.getEngine().run();
    }

    @Test
    public void 빈_이름_주입_실패_테스트() {
        RootBeanDefinition avante = new RootBeanDefinition();
        avante.setBeanClass(Avante.class);
        avante.setAutowireMode(AUTOWIRE_BY_NAME);

        RootBeanDefinition strongEngine = new RootBeanDefinition();
        strongEngine.setBeanClass(StrongEngine.class);

        factory.registerBeanDefinition("avante", avante);
        factory.registerBeanDefinition("strongEngine", strongEngine);

        Avante avanteBean = factory.getBean("avante", Avante.class);

        assertNull(avanteBean.getEngine());
    }

    @Test
    public void 빈_타입_주입_테스트() {
        RootBeanDefinition avante = new RootBeanDefinition();
        avante.setBeanClass(Avante.class);
        avante.setAutowireMode(AUTOWIRE_BY_TYPE);

        RootBeanDefinition strongEngine = new RootBeanDefinition();
        strongEngine.setBeanClass(StrongEngine.class);

        factory.registerBeanDefinition("avante", avante);
        factory.registerBeanDefinition("noName", strongEngine);

        Avante avanteBean = factory.getBean("avante", Avante.class);

        assertNotNull(avanteBean.getEngine());
        avanteBean.getEngine().run();
    }

    @Test
    public void 빈_애노테이션_주입_테스트() {
        
    }

}
