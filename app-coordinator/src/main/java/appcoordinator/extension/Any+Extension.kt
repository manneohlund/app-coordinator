package appcoordinator.extension

import appcoordinator.annotation.*
import kotlin.reflect.full.findAnnotation

/**
 * Created by Manne Öhlund on 2018-03-08.
 * Copyright © 2018. All rights reserved.
 */

fun Any.getTagAnnotation(): Tag? = this.javaClass.kotlin.findAnnotation()

fun Any.getTagName(): String? = getAddAnnotation()?.tag ?: getReplaceAnnotation()?.tag ?: getTagAnnotation()?.name

fun Any.getContainerId(): Int? = getAddAnnotation()?.containerId ?: getReplaceAnnotation()?.containerId ?: getContainerAnnotation()?.id

// Get

fun Any.getAddAnnotation(): Add? = this.javaClass.kotlin.findAnnotation()

fun Any.getReplaceAnnotation(): Replace? = this.javaClass.kotlin.findAnnotation()

fun Any.getAddToBackStackAnnotation(): AddToBackStack? = this.javaClass.kotlin.findAnnotation()

fun Any.getHideAnnotation(): Hide? = this.javaClass.kotlin.findAnnotation()

fun Any.getContainerAnnotation(): Container? = this.javaClass.kotlin.findAnnotation()

// CustomAnimation

fun Any.getCustomAnimationAnnotation(): CustomAnimation? = this.javaClass.kotlin.findAnnotation()

fun Any.getCustomAnimationsAnnotation(): CustomAnimations? = this.javaClass.kotlin.findAnnotation()