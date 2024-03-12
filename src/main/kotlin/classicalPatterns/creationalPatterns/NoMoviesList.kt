package classicalPatterns.creationalPatterns

//Singleton Design Pattern
object NoMoviesList: List<String> {
    override val size: Int
        get() = 0

    override fun contains(element: String): Boolean = emptyList<String>().contains(element)

    override fun containsAll(elements: Collection<String>): Boolean = emptyList<String>().containsAll(elements)

    override fun get(index: Int): String = emptyList<String>()[index]

    override fun indexOf(element: String): Int = emptyList<String>().indexOf(element)

    override fun isEmpty(): Boolean = emptyList<String>().isEmpty()

    override fun iterator(): Iterator<String>  = emptyList<String>().iterator()

    override fun lastIndexOf(element: String): Int = emptyList<String>().lastIndexOf(element)

    override fun listIterator(): ListIterator<String> = emptyList<String>().listIterator()

    override fun listIterator(index: Int): ListIterator<String> = emptyList<String>().listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): List<String> = emptyList()
}

fun printMovies(movies: List<String>){
    for (m in movies){
        println(m)
    }
}

fun main(){
    val myFavoriteQuickAndAngryMovies = NoMoviesList
    printMovies(myFavoriteQuickAndAngryMovies)
}