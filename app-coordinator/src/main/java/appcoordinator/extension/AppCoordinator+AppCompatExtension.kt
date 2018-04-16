package appcoordinator.extension

import android.support.v7.app.AppCompatActivity
import appcoordinator.AppCoordinator

/**
 * Created by Manne Öhlund on 2018-03-08.
 * Copyright © 2018. All rights reserved.
 */

fun <T : android.support.v4.app.Fragment> AppCoordinator.add(activity: AppCompatActivity, fragment: T, transactionModel: Any? = null, transaction: Int = 0) {
    fragment.getAddAnnotation()
            ?: throw Exception("Fragment transaction `Add` annotation not found")
    show(activity, fragment, transactionModel, transaction)
}

fun <T : android.support.v4.app.Fragment> AppCoordinator.replace(activity: AppCompatActivity, fragment: T, transactionModel: Any? = null, transaction: Int = 1) {
    fragment.getReplaceAnnotation()
            ?: throw Exception("Fragment transaction `Replace` annotation not found")
    show(activity, fragment, transactionModel, transaction)
}

fun <T : android.support.v4.app.Fragment> AppCoordinator.show(activity: AppCompatActivity, fragment: T, transactionModel: Any? = null, transaction: Int? = null) {
    activity.supportFragmentManager.beginTransaction().apply {
        val targetModel = transactionModel ?: fragment
        targetModel.getCustomAnimationAnnotation()?.let { anim ->
            setCustomAnimations(anim.enter, anim.exit)
        }

        targetModel.getCustomAnimationsAnnotation()?.let { anim ->
            setCustomAnimations(anim.enter, anim.exit, anim.popEnter, anim.popExit)
        }

        val tag: String? = targetModel.getTagName() ?: fragment.tag

        targetModel.getAddAnnotation()?.let { add ->
            add(add.containerId, fragment, add.tag)
        } ?: targetModel.getReplaceAnnotation()?.let { replace ->
            replace(replace.containerId, fragment, replace.tag)
        } ?: (transaction == 0).let {
            targetModel.getContainerId()?.let { containerId ->
                add(containerId, fragment, tag)
            }
        } ?: (transaction == 1).let {
            targetModel.getContainerId()?.let { containerId ->
                replace(containerId, fragment, tag)
            }
        }

        targetModel.getAddToBackStackAnnotation()?.let { addToBackStack ->
            if (addToBackStack.value) {
                tag?.let { tag ->
                    addToBackStack(tag)
                }
            }
        }

        targetModel.getHideAnnotation()?.let { hide ->
            hide.fragment.simpleName?.let { name ->
                activity.supportFragmentManager.findFragmentByTag(name)?.let {
                    hide(it)
                } ?: throw Exception("`Hide` annotation not found, Fragment $name not hidden")
            }
        }

        commit()
    }
}