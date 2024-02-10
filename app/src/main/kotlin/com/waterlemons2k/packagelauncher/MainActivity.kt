package com.waterlemons2k.packagelauncher

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startPackage(getString(R.string.package_name))
        finish()
    }

    /**
     * Launch a package. Toast if the package is not found.
     *
     * @param packageName The name of the package to start.
     */
    private fun startPackage(packageName: String) {
        Log.d(TAG, "Package: $packageName")

        val intent = packageManager.getLaunchIntentForPackage(packageName)
        intent?.let {
            startActivity(it)
        } ?: Toast.makeText(this, "Package not found: $packageName", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val TAG = "PackageLauncher"
    }
}
