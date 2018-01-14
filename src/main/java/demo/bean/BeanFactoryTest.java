package demo.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Administrator on 2018/1/6.
 */
public class BeanFactoryTest {

    @Test
    public void testSampleLoad(){

        DefaultListableBeanFactory bf1;
        XmlBeanDefinitionReader reader;

        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        new EncodedResource(new ClassPathResource("beans.xml"),"gbk");

       // bf = null;
        Assert.notNull(bf, "BeanFactory must not be null");
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");

        assertEquals("testStr",bean.getTestStr());

    }
}
