package top.abosen.rpc.thrift.client

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author qiubaisen
 * @date 2020/8/14
 */
inline fun <reified T> T.logger(): Logger {
    if (T::class.isCompanion) {
        return LoggerFactory.getLogger(T::class.java.enclosingClass)
    }
    return LoggerFactory.getLogger(T::class.java)
}
