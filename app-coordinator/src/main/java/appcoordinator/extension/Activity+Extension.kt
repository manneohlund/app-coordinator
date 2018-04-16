package appcoordinator.extension

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import appcoordinator.AppCoordinator

/**
 * Created by Manne Öhlund on 2018-03-08.
 * Copyright © 2018. All rights reserved.
 */

// Add Fragment

fun Activity.add(fragment: android.app.Fragment, transactionModel: Any? = null) = AppCoordinator.add(this, fragment, transactionModel)

fun AppCompatActivity.add(fragment: android.support.v4.app.Fragment, transactionModel: Any? = null) = AppCoordinator.add(this, fragment, transactionModel)

// Replace Fragment

fun Activity.replace(fragment: android.app.Fragment, transactionModel: Any? = null) = AppCoordinator.replace(this, fragment, transactionModel)

fun AppCompatActivity.replace(fragment: android.support.v4.app.Fragment, transactionModel: Any? = null) = AppCoordinator.replace(this, fragment, transactionModel)

// Get fragment by TAG

fun Activity.getFragment(tag: String): android.app.Fragment? = fragmentManager.findFragmentByTag(tag)

fun AppCompatActivity.getFragment(tag: String): android.support.v4.app.Fragment? = supportFragmentManager.findFragmentByTag(tag)

// Get fragment by id

fun Activity.getFragment(id: Int): android.app.Fragment? = fragmentManager.findFragmentById(id)

fun AppCompatActivity.getFragment(id: Int): android.support.v4.app.Fragment? = supportFragmentManager.findFragmentById(id)