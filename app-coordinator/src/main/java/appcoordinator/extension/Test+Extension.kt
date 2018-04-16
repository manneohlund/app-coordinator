package appcoordinator.extension

import android.system.Os

/**
 * Created by Manne Öhlund on 2018-04-10.
 * Copyright © 2018 Frost. All rights reserved.
 */


open class A {
    open fun test(): String = "A"
}

fun Os.env(): Map<String, String> = Os.environ().associate { string ->
    string.split("=").let {
        Pair(it.first(), it.last())
    }
}

fun Os.test(): String = "test"

fun Runtime.test(): String = "test"

val Any.TAG: String
    get() = this.javaClass.simpleName