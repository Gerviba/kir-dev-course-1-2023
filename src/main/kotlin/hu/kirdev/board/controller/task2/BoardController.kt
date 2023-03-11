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

    @GetMapping("/board")
    fun board(model: Model): String {
        model.addAttribute("appName", "Message Board")
        model.addAttribute("messages", boardService.getAllMessages())
        return "board"
    }

    @PostMapping("/board")
    fun newSubmission(@ModelAttribute submission: BoardSubmissionDto): String {
        boardService.createMessage(submission.name, submission.message)
        return "redirect:/board"
    }

}