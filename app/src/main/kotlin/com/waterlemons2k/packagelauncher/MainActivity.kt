package com.waterlemons2k.packagelauncher

import android.app.Activity
import android.os.Bundle
import android.util.Log

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startPackage(getString(R.string.package_name))
        finish()
    }

    /**
     * Launch a package. Log if the package is not found.
     *
     * @param packageName - name of the package to start.
     */
    private fun startPackage(packageName: String) {
        Log.d(TAG, "Package: $packageName")

        val intent = packageManager.getLaunchIntentForPackage(packageName)
        intent?.let {
            startActivity(it)
        } ?: Log.w(TAG, "Package not found")
    }

    companion object {
        const val TAG = "PackageLauncher"
    }
}
