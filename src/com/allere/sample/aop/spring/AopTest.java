package com.allere.sample.aop.spring;

import com.allere.sample.proxy.object.IAdd;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

public class AopTest {

    public static void main(String[] argv) throws ClassNotFoundException {

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setProxyInterfaces(new Class[]{IAdd.class});
        proxyFactoryBean.addAdvice(new AopAllInOne());
//    <bean id="methodProxy" class="org.springframework.aop.framework.ProxyFactoryBean">
//       <property name="proxyInterfaces">
//         <value>org.study.spring.aop.proxyfactorybean.IBussinessService</value>
//       </property>
//
//       <property name="target">
//         <ref bean="bussinessService"/>
//       </property>
//
//       <property name="interceptorNames">
//          <list>
//             <value>methodCount</value>
//             <value>methodLogger</value>
//          </list>
//       </property>

    }
}
