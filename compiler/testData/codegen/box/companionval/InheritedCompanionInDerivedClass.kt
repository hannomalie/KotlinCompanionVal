// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class Printer<T> {
    fun T.customToString() = "printed:" + this.toString()
}

open class Base(val someString: String) {
    protected companion val printer: Printer<String> = Printer()
}

class Foo(someString: String): Base(someString) {
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