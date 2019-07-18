// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class Entity(var name: String)

class ServerBackend {
    fun <T> executeInTransaction(action: ActionContext.() -> T) {}
}

class CoroutineScope {
    fun <T> async(action: () -> T) {}
}

class Printer {
    fun Any.customToString(): String = "custom: $this"
}

class ActionContext(companion val coroutineScope: CoroutineScope,
                    companion val printer: Printer)

fun box(): String {

    val result = ServerBackend().executeInTransaction {
        async {
        }
        Entity("foo").customToString()
    }
    return "OK"
//    return if (result == "bar") {
//        "OK"
//    } else {
//        "fail 1"
//    }
}