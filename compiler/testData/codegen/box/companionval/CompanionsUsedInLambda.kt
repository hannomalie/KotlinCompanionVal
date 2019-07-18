// TARGET_BACKEND: JVM
// WITH_RUNTIME

package com.companionval

class Entity(var name: String)

class EntityService {
    fun Entity.save() {}
}

class ServerBackend {
    fun Entity.executeWithTransaction(entityAction: Entity.() -> Unit) {}
}

companion val entityService = EntityService()
companion val backend = ServerBackend()

fun box(): String {

    Entity("oldName").executeWithTransaction {
        name = "newName"
        save()
    }
    return "OK"
//    return if (result == "bar") {
//        "OK"
//    } else {
//        "fail 1"
//    }
}