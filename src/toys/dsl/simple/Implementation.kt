package toys.dsl.simple



@DslMarker
annotation class SimpleDsl1

@SimpleDsl1
class PersonBuilder(initialName: String, initialAge: Int){
    var name:String = initialName
    var age:Int = initialAge

    fun build():Person = Person(name,age)
}

@SimpleDsl1
class HouseBuilder{
    private val people = mutableListOf<Person>()

    fun build():House = House(people)

    fun person(name:String = "",age:Int=0,setup:PersonBuilder.()->Unit={}){
        val personBuilder = PersonBuilder(name,age)
        personBuilder.setup()
        people +=personBuilder.build()
    }
}

@SimpleDsl1
class VillageBuilder{
    private val houses = mutableListOf<House>()

    operator fun House.unaryPlus(){
        houses+=this
    }
}