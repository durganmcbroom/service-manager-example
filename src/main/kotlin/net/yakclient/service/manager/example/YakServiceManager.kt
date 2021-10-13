package net.yakclient.service.manager.example

import java.util.*
import kotlin.collections.HashMap

public object YakServiceManager {
    private val services: MutableMap<String, ServiceLoader<*>> = HashMap()

    public fun <T : YakService> load(service: Class<T>): ServiceLoader<T> = services.getOrPut(service.name) {
        ServiceLoader.load(service).also  {it.reload()}
    } as ServiceLoader<T>

    public fun <T : YakService> loadFirst(service: Class<T>): T = load(service).findFirst().get()

    public fun <T : YakService> loadFirstOrNull(service: Class<T>): T? = load(service).firstOrNull()

    public fun <T : YakService> loadAll(service: Class<T>): List<T> = load(service).toList()

    public fun refresh(service: Class<out YakService>) : Unit =
        services[service.name]?.reload() ?: Unit

    public fun <T : YakService> loadMatching(service: Class<T>, predicate: (T) -> Boolean): List<T> =
        load(service).filter(predicate)

    public fun <T : YakService> loadFirstMatching(service: Class<T>, predicate: (T) -> Boolean): T? =
        load(service).firstOrNull(predicate)
}

public inline fun <reified T : YakService> YakServiceManager.load(): ServiceLoader<T> = load(T::class.java)

public inline fun <reified T : YakService> YakServiceManager.loadFirst(): T = loadFirst(T::class.java)

public inline fun <reified T : YakService> YakServiceManager.loadFirstOrNull(): T? = loadFirstOrNull(T::class.java)

public inline fun <reified T : YakService> YakServiceManager.loadAll(): List<T> = loadAll(T::class.java)

public inline fun <reified T : YakService> YakServiceManager.refresh() : Unit = refresh(T::class.java)

public inline fun <reified T : YakService> YakServiceManager.loadMatching(noinline predicate: (T) -> Boolean): List<T> =
    loadMatching(T::class.java, predicate)

public inline fun <reified T : YakService> YakServiceManager.loadFirstMatching(
    noinline predicate: (T) -> Boolean
): T? = loadFirstMatching(T::class.java, predicate)