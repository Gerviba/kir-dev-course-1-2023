package hu.kirdev.board.controller.task2

import hu.kirdev.board.model.BoardMessage
import hu.kirdev.board.service.BoardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(
    private val boardService: BoardService
) {

    @GetMapping("/api/board")
    fun listSubmissions(): List<BoardMessage> {
        return boardService.getAllMessages()
    }

}