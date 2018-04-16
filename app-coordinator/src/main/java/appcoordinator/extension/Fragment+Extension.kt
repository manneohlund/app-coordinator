package appcoordinator.extension

/**
 * Created by Manne Öhlund on 2018-03-08.
 * Copyright © 2018. All rights reserved.
 */

fun android.app.Fragment.setTag(tag: String) {
    javaClass.getField("mTag").let {
        it.isAccessible = true
        it.set(this, tag)
    }
}

fun android.support.v4.app.Fragment.setTag(tag: String) {
    android.support.v4.app.Fragment::class.java
            .getDeclaredField("mTag")
            .let {
                it.isAccessible = true
                it.set(this, tag)
            }
}

/*
fun Fragment.getTagAnnotation(): Tag? = this.javaClass.kotlin.findAnnotation()

fun Fragment.getTagAnnotationName(): String? = getAddAnnotation()?.tag ?: getReplaceAnnotation()?.tag ?: getTagAnnotation()?.name

fun Fragment.getContainerId(): Int? = this.javaClass.kotlin.findAnnotation<Container>()?.id

// Get

fun Fragment.getAddAnnotation(): Add? = this.javaClass.kotlin.findAnnotation()

fun Fragment.getReplaceAnnotation(): Replace? = this.javaClass.kotlin.findAnnotation()

fun Fragment.getAddToBackStackAnnotation(): AddToBackStack? = this.javaClass.kotlin.findAnnotation()

fun Fragment.getHideAnnotation(): Hide? = this.javaClass.kotlin.findAnnotation()

// CustomAnimation

fun Fragment.getCustomAnimationAnnotation(): CustomAnimation? = this.javaClass.kotlin.findAnnotation()

fun Fragment.getCustomAnimationsAnnotation(): CustomAnimations? = this.javaClass.kotlin.findAnnotation()
*/