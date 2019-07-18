// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class Printer<T> {
    fun T.customToString() = "printed:" + this.toString()
}

class Foo(val someString: String, companion val printer: Printer<String> = Printer()) {
    fun retrieveCustomToString() : String = someString.customToString()
}


fun box(): String {
    val result = Foo("bar").retrieveCustomToString()
    return if (result == "printed:bar") {
        "OK"
    } else {
        "fail 1"
    }
}