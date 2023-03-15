package hu.kirdev.board.controller.task2

import hu.kirdev.board.model.BoardSubmissionDto
import hu.kirdev.board.service.BoardService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class BoardController(
    private val boardService: BoardService
) {

    // GET /board
    @GetMapping("/board")
    fun showBoard(model: Model): String {
        model.addAttribute("appName", "Message Board")
        model.addAttribute("messages", boardService.getAllMessages())
        return "board"
    }

    // POST /board
    @PostMapping("/board")
    fun submitMessage(@ModelAttribute submission: BoardSubmissionDto): String {
        println(submission.name)
        println(submission.message)
        println("---")
        boardService.createMessage(submission.name, submission.message)
        return "redirect:/board"
    }


}