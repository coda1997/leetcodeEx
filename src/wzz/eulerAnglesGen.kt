package wzz

import java.lang.reflect.*

class `练习生`{
    val time = "两年半"
    fun `唱🎤`(){
//        print(this::)
    }
    fun `跳🤸‍♂️`(){

    }
    fun `rap🕺`(){

    }
    fun `⛹️‍🏀`(){

    }
    fun `🐔你太美`(){

    }
}



fun main(args: Array<String>) {
    val cxk = `练习生`()
    cxk::class
            .java.methods
            .filter { it.modifiers==17&&!(it.name.contains("wait")||it.name.contains("getTime")) }
            .joinToString(prefix = "我会", separator = "") { it.name }
            .apply(::println)
}