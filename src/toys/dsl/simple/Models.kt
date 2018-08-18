package toys.dsl.simple


data class Village(val houses:List<House>)

data class House(val people:List<Person>)

data class Person(val name:String,val age:Int)


