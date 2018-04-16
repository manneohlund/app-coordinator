package appcoordinator

import android.app.Activity
import appcoordinator.extension.getAddAnnotation
import appcoordinator.extension.getReplaceAnnotation

/**
 * Created by Manne Öhlund on 2018-03-08.
 * Copyright © 2018. All rights reserved.
 */
object AppCoordinator {

    val ADD = 0
    val REPLACE = 1

    fun <T : android.app.Fragment> add(context: Activity, fragment: T, transactionModel: Any? = null) {
        context.fragmentManager.beginTransaction().apply {
            fragment.getAddAnnotation()?.let { add ->
                add(add.containerId, fragment, add.tag)
                addToBackStack(add.tag)
            } ?: throw Exception("Add annotation not found")

            commit()
        }
    }

    fun <T : android.app.Fragment> replace(context: Activity, fragment: T, transactionModel: Any? = null) {
        context.fragmentManager.beginTransaction().apply {
            fragment.getReplaceAnnotation()?.let { replace ->
                replace(replace.containerId, fragment, replace.tag)
            } ?: throw Exception("Replace annotation not found")

            commit()
        }
    }
}