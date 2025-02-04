class Menu(private val title: String) {
    private val options = mutableListOf<Pair<String, () -> Unit>>()

    fun addOption(name: String, action: () -> Unit) {
        options.add(name to action)
    }

    fun display() {
        while (true) {
            println("\n$title")
            options.forEachIndexed { index, option -> println("$index. ${option.first}") }
            print("Выберите пункт меню: ")

            val input = readLine()
            val choice = input?.toIntOrNull()

            if (choice != null && choice in options.indices) {
                options[choice].second()
                break
            } else {
                println("Некорректный ввод. Пожалуйста, введите правильный номер.")
            }
        }
    }
}
