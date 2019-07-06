// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: CompanionValAsConstructorArgInClasses.kt

package com.companionval

class CustomToString<T> {
    fun T.customToString() = "custom:" + this.toString()
}

class Foo(val someString: String, companion val customToString: CustomToString<String> = CustomToString()) {
    fun retrieveCustomToString() : String = someString.customToString()
}


fun box(): String {
    val result = Foo("bar").retrieveCustomToString()
    return if (result == "custom:bar") {
        "OK"
    } else {
        "fail 1"
    }
}