package top.abosen.rpc.thrift.client.scanner

import org.apache.thrift.TServiceClient
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.InitializingBean
import top.abosen.rpc.thrift.client.common.ThriftServiceSignature
import top.abosen.rpc.thrift.client.logger
import java.lang.reflect.Constructor

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
class ThriftClientFactoryBean<T> : FactoryBean<T>, InitializingBean {
    lateinit var beanName: String
    lateinit var beanClass: Class<*>
    lateinit var beanClassName: String
    lateinit var serviceClass: Class<*>
    lateinit var serviceSignature: ThriftServiceSignature
    lateinit var clientClass: Class<*>
    lateinit var clientConstructor: Constructor<out TServiceClient?>

    override fun getObject(): T? {
        TODO("Not yet implemented")

    }

    override fun getObjectType(): Class<*>? {
        TODO("Not yet implemented")
    }

    override fun afterPropertiesSet() {
        if (log.isDebugEnabled) {
            log.debug("Succeed to instantiate an instance of ThriftClientFactoryBean: {}", this)
        }
    }

    companion object {
        private val log = logger()

        // ThriftClientAware实现类的bean名称
        const val BEAN_NAME = "beanName"
        // ThriftClientAware实现类的类型
        const val BEAN_CLASS = "beanClass"
        // ThriftClientAware实现类的类型名称
        const val BEAN_CLASS_NAME = "beanClassName"
        // Thrift Service类名称
        const val SERVICE_CLASS = "serviceClass"
        // Thrift Service的服务签名
        const val SERVICE_SIGNATURE = "serviceSignature"
        // Thrift Client的类型
        const val CLIENT_CLASS = "clientClass"
        // Thrift Client的TProcessor带参数构造器
        const val CLIENT_CONSTRUCTOR = "clientConstructor"
    }
}