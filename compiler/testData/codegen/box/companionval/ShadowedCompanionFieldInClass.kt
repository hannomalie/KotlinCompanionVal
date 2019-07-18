// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class Printer<T>(val prefix: String = "custom:") {
    fun T.customToString() = prefix + this.toString()
}

class Foo(val someString: String) {
    private companion val printer: Printer<String> = Printer()
    fun retrieveCustomToString(companion anotherPrinter: Printer<String> = Printer("anotherCustom:")) : String {
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