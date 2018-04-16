package appcoordinator.annotation

import kotlin.reflect.KClass

/**
 * Created by Manne Öhlund on 2018-02-27.
 * Copyright © 2018. All rights reserved.
 */

annotation class Remove(val fragment: KClass<*>)