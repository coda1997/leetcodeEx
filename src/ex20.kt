fun isValid(s: String): Boolean {
    val lock = arrayListOf<Char>()
    try {
    loop@ for(c in s){

        when(c){
            '(','[','{'->lock.add(0,c)
            ')'-> if(lock[0]=='(') lock.removeAt(0) else return false
            ']'-> if(lock[0]=='[') lock.removeAt(0) else return false
            '}'-> if(lock[0]=='{') lock.removeAt(0) else return false
            else-> break@loop
        }
    }

    }catch (e:IndexOutOfBoundsException){
        return false
    }
    return lock.isEmpty()
}