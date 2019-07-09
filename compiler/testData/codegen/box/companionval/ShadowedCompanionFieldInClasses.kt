// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class CustomToString<T>(val prefix: String = "custom:") {
    fun T.customToString() = prefix + this.toString()
}

class Foo(val someString: String) {
    private companion val customToString: CustomToString<String> = CustomToString()
    fun retrieveCustomToString(companion anotherCustomToString: CustomToString<String> = CustomToString("anotherCustom:")) : String {
        return someString.customToString()
    }
}


fun box(): String {
    val result = Foo("bar").retrieveCustomToString()
    return if (result == "anotherCustom:bar") {
        "OK"
    } else {
        "fail 1"
    }
}