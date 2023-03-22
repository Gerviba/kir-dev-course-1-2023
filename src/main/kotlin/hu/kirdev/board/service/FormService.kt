package hu.kirdev.board.service

import hu.kirdev.board.model.FormMessage
import org.springframework.stereotype.Service

@Service
class FormService {

    private val inMemoryDatabase: MutableList<FormMessage> = mutableListOf()
    private var lastId = 0

    fun createSubmission(name: String, email: String, age: Int) {
        inMemoryDatabase.add(
            FormMessage(
                id = lastId++,
                name = name,
                email = email,
                age = age
            )
        )
    }

    fun getAllSubmissions(): List<FormMessage> = inMemoryDatabase

}