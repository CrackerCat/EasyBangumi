package com.heyanle.inject.api

import java.lang.reflect.GenericArrayType
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.TypeVariable
import java.lang.reflect.WildcardType

inline fun <reified T: Any> fullType(): FullTypeReference<T> = object:FullTypeReference<T>(){}
interface TypeReference<T> {
    val type: Type
}

// 获得泛型的 type
abstract class FullTypeReference<T> protected constructor() : TypeReference<T> {
    override val type: Type = javaClass.genericSuperclass.let { superClass ->
        if (superClass is Class<*>) {
            throw IllegalArgumentException("Internal error: TypeReference constructed without actual type information")
        }
        (superClass as ParameterizedType).actualTypeArguments[0]
    }
}
