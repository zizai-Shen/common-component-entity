package tax.szz.common.entity.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

import java.util.Map;

/**
 * 作者：沈自在 <a href="https://www.szz.tax">Blog</a>
 *
 * @description 感知 ApplicationContext 容器，静态方法获取 Bean
 * @date 2023/9/17
 */
public class ApplicationContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext;

    /**
     * 清空注入的容器
     */
    public static void clearHolder() {
        applicationContext = null;
    }

    /**
     * 检查容器是否注入成功
     */
    private static void checkApplicationContext() {
        if (null == applicationContext)
            throw new IllegalArgumentException("ApplicationContext is null, please start the spring container correctly");
    }

    /**
     * 获取容器
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 获取 Bean
     */
    public static <T> T getBean(String name, Class<T> type) {
        checkApplicationContext();
        return applicationContext.getBean(name, type);
    }

    /**
     * 获取 Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        Map<String, T> beanMaps = applicationContext.getBeansOfType(clazz);
        return !beanMaps.isEmpty() ? beanMaps.values().stream().findFirst().orElse(null) : null;
    }

    /**
     * Spring 容器销毁方法
     */
    @Override
    public void destroy() throws Exception {
        clearHolder();
    }

    /**
     * ApplicationContext 感知
     */
    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }
}
