package utils

class UserInputOptions {

    fun startMenu(): Int {
        var userInputType: String?
        var userInputTypeReturn: Int? = 0
        while (userInputTypeReturn != 1 && userInputTypeReturn != 2) {
            println("\nВведите: ")
            println("1 - чтобы скачать JSON")
            println("2 - чтобы скачать XML\n")
            userInputType = readlnOrNull()
            userInputTypeReturn = checkUserInputOneOrTwo(userInputType)
        }
        return userInputTypeReturn
    }

    fun secondMenu(): Int {
        var userInputType: String?
        var userInputTypeReturn: Int? = 0
        while (userInputTypeReturn != 1 && userInputTypeReturn != 2) {
            println("\nВведите: ")
            println("1 - вывести все новости")
            println("2 - поиск по keyword\n")
            userInputType = readlnOrNull()
            userInputTypeReturn = checkUserInputOneOrTwo(userInputType)
        }
        return userInputTypeReturn
    }


    private fun checkUserInputOneOrTwo(userInputText: String?): Int? {
        val checkUserInput = userInputText?.toIntOrNull()
        if (checkUserInput !is Int) {
            println("Нужно ввести число 1 или 2.")
        } else if (checkUserInput != 1 && checkUserInput != 2) {
            println("Нужно ввести число 1 или 2.")
        }
        return checkUserInput
    }

    fun checkUserInputKeyword(): String {
        var userInputKeyword: String?
        while (true) {
            println("\nВведите keyword:\n")
            userInputKeyword = readlnOrNull()
            if (userInputKeyword != null) return userInputKeyword
        }
    }
}