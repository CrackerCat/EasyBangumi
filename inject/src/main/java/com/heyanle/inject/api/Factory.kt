package com.heyanle.inject.api

import java.lang.reflect.Type

/**
 * Created by HeYanLe on 2023/7/29 19:32.
 * https://github.com/heyanLE
 */
interface InjectFactory {
    fun <R: Any> getInstance(forType: Type): R
    fun <R: Any> getInstanceOrElse(forType: Type, default: R): R {
        try {
            return getInstance(forType)
        }catch (e: Exception){
            e.printStackTrace()
            return default
        }
    }
    fun <R: Any> getInstanceOrElse(forType: Type, default: ()->R): R {
        try {
            return getInstance(forType)
        }catch (e: Exception){
            e.printStackTrace()
            return default()
        }
    }
    fun <R: Any> getInstanceOrNull(forType: Type): R? {
        try {
            return getInstance(forType)
        }catch (e: Exception){
            e.printStackTrace()
            return null
        }
    }

    fun <R: Any, K: Any> getKeyedInstance(forType: Type, key: K): R
    fun <R: Any, K: Any> getKeyedInstanceOrElse(forType: Type, key: K, default: R): R {
        try {
            return getKeyedInstance(forType, key)
        }catch (e: Exception){
            e.printStackTrace()
            return default
        }
    }
    fun <R: Any, K: Any> getKeyedInstanceOrElse(forType: Type, key: K, default: ()->R): R {
        try {
            return getKeyedInstance(forType, key)
        }catch (e: Exception){
            e.printStackTrace()
            return default()
        }
    }
    fun <R: Any, K: Any> getKeyedInstanceOrNull(forType: Type, key: K): R? {
        try {
            return getKeyedInstance(forType, key)
        }catch (e: Exception){
            e.printStackTrace()
            return null
        }
    }

}

@Suppress("NOTHING_TO_INLINE")
inline fun <R: Any> InjectFactory.get(forType: TypeReference<R>): R = getInstance(forType.type)
inline fun <reified R: Any> InjectFactory.getOrElse(forType: TypeReference<R>, default: R): R = getInstanceOrElse(forType.type, default)
inline fun <reified R: Any> InjectFactory.getOrElse(forType: TypeReference<R>, noinline default: ()->R): R = getInstanceOrElse(forType.type, default)
inline fun <reified R: Any> InjectFactory.getOrNull(forType: TypeReference<R>): R? = getInstanceOrNull(forType.type)

inline operator fun <reified R: Any> InjectFactory.invoke(): R = getInstance(fullType<R>().type)
inline fun <reified R: Any> InjectFactory.get(): R = getInstance(fullType<R>().type)
inline fun <reified R: Any> InjectFactory.getOrElse(default: R): R = getInstanceOrElse(fullType<R>().type, default)
inline fun <reified R: Any> InjectFactory.getOrElse(noinline default: ()->R): R = getInstanceOrElse(fullType<R>().type, default)
inline fun <reified R: Any> InjectFactory.getOrNull(): R? = getInstanceOrNull(fullType<R>().type)

@Suppress("NOTHING_TO_INLINE")
inline fun <R: Any> InjectFactory.get(forType: TypeReference<R>, key: Any): R = getKeyedInstance(forType.type, key)
inline fun <reified R: Any> InjectFactory.getOrElse(forType: TypeReference<R>, key: Any, default: R): R = getKeyedInstanceOrElse(forType.type, key, default)
inline fun <reified R: Any> InjectFactory.getOrElse(forType: TypeReference<R>, key: Any, noinline default: ()->R): R = getKeyedInstanceOrElse(forType.type, key, default)
inline fun <reified R: Any> InjectFactory.getOrNull(forType: TypeReference<R>, key: Any): R? = getKeyedInstanceOrNull(forType.type, key)

inline fun <reified R: Any> InjectFactory.get(key: Any): R = getKeyedInstance(fullType<R>().type, key)
inline fun <reified R: Any> InjectFactory.getOrElse(key: Any, default: R): R = getKeyedInstanceOrElse(fullType<R>().type, key, default)
inline fun <reified R: Any> InjectFactory.getOrElse(key: Any, noinline default: ()->R): R = getKeyedInstanceOrElse(fullType<R>().type, key, default)
inline fun <reified R: Any> InjectFactory.getOrNull(key: Any): R? = getKeyedInstanceOrNull(fullType<R>().type, key)