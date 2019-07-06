// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: CompanionValAsArgInFunctions.kt

package com.companionval

class Foo(val someString: String)

fun retrieveStringProperty(companion foo: Foo) : String = someString

fun box(): String {
    val result = retrieveStringProperty(Foo("bar"))
    return if (result == "bar") {
        "OK"
    } else {
        "fail 1"
    }
}