package top.abosen.rpc.thrift.client.scanner

import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import top.abosen.rpc.thrift.client.logger

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
class ThriftClientBeanScanProcessor : ApplicationContextAware, BeanFactoryPostProcessor {
    private lateinit var applicationContext: ApplicationContext
    private val logger = logger()

    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {

    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }
}