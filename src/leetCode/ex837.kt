package leetCode

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

data class Community(var name:String="",val address:String="",val hotels:Array<Hotel> = emptyArray())
fun community(block:Community.()->Unit)=Community().apply(block)
data class Hotel(val name:String="",val address:String="")
fun Community.hotel(block: Hotel.() -> Unit)=Hotel().apply(block)

fun main(args: Array<String>) {
    val community= community {
        name="home name"
    }


}

