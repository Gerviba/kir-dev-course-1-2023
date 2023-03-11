package hu.kirdev.board.controller.task1

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.text.SimpleDateFormat
import java.time.Instant

private const val APP_NAME = "kir-dev demo app"

@Controller
class BasicController {

    private var numberOfRequests: Int = 0
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @ResponseBody
    @GetMapping("/api/name")
    fun test1(): String {
        return APP_NAME
    }

    @ResponseBody
    @GetMapping("/api/date")
    fun test2(): String {
        return dateFormat.format(Instant.now().toEpochMilli())
    }

    @ResponseBody
    @GetMapping("/api/n")
    fun test3(): Int {
        numberOfRequests += 1
        return numberOfRequests
    }

    @GetMapping("/")
    fun index(model: Model): String {
        numberOfRequests += 1

        model.addAttribute("appName", APP_NAME)
        model.addAttribute("time", dateFormat.format(Instant.now().toEpochMilli()))
        model.addAttribute("n", numberOfRequests)
        return "index"
    }

}