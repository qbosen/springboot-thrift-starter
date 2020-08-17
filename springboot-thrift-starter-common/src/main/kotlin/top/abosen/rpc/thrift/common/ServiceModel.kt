package top.abosen.rpc.thrift.common

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
enum class ServiceModel {
    // 单线程阻塞式
    simple,

    // 单线程非阻塞式
    nonBlocking,

    // 线程池
    threadPool,

    // 半同步半异步
    hsHa,

    // 线程池选择器
    threadedSelector;

    companion object {
        val default = hsHa
    }
}