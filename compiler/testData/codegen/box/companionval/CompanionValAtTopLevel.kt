// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class CustomToString<T> {
    fun T.customToString() = "custom:" + this.toString()
}

public companion val customToString: CustomToString<String> = CustomToString()

class Foo(val someString: String) {
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