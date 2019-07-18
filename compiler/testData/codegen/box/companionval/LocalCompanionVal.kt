// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class Printer<T> {
    fun T.customToString() = "printed:" + this.toString()
}

class Foo(val someString: String)


fun box(): String {
    companion val printer: Printer<String> = Printer()

    val result = Foo("bar").someString.customToString()

    return if (result == "printed:bar") {
        "OK"
    } else {
        "fail 1"
    }
}