class ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun start() {
        var programRun = true
        while (programRun) {
            val menu = Menu("Архивы")

            menu.addOption("Создать архив") { createArchive() }
            archives.forEach { archive ->
                menu.addOption(archive.name) { archiveMenu(archive) }
            }
            menu.addOption("Выход из программы") { programRun = false }

            menu.display()
        }
    }

    private fun createArchive() {
        print("Введите название архива: ")
        val name = readLine()?.trim()
        if (name.isNullOrEmpty()) {
            println("Название не может быть пустым.")
            return
        }
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }

    private fun archiveMenu(archive: Archive) {
        val menu = Menu("Архив: ${archive.name}")
        menu.addOption("Создать заметку") { archive.addNote() }
        menu.addOption("Просмотреть заметки") { archive.viewNotes() }
        menu.addOption("Назад") {}
        menu.display()
    }
}
