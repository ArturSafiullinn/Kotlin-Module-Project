class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun addNote() {
        print("Введите название заметки: ")
        val title = readLine()?.trim()
        if (title.isNullOrEmpty()) {
            println("Название не может быть пустым.")
            return
        }

        print("Введите текст заметки: ")
        val content = readLine()?.trim()
        if (content.isNullOrEmpty()) {
            println("Содержание не может быть пустым.")
            return
        }

        notes.add(Note(title, content))
        println("Заметка добавлена!")
    }

    fun viewNotes() {
        val menu = Menu("Заметки в архиве '$name'")
        notes.forEachIndexed { index, note ->
            menu.addOption(note.title) { note.display() }
        }
        menu.addOption("Назад") {}
        menu.display()
    }
}
