class Note(val title: String, private val content: String) {
    fun display() {
        println("\nЗаметка: $title")
        println("Содержание: $content")
    }
}