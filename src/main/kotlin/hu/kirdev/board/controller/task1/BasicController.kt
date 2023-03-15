package hu.kirdev.board.controller.task1

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.text.SimpleDateFormat

private const val APP_NAME = "kir-dev demo app"

@Controller
class BasicController {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    // java: private int n = 0
    private var n: Int = 0

    // java: public String test1() { ... }

    // GET /api/name
    @ResponseBody
    @GetMapping("/api/name")
    fun test1(): String {
        return APP_NAME
    }

    // GET /api/time
    @ResponseBody
    @GetMapping("/api/time")
    fun getTime(): String {
        return dateFormat.format(System.currentTimeMillis())
    }

    // GET /api/n
    @ResponseBody
    @GetMapping("/api/n")
    fun getN(): Int {
        n += 1
        return n
    }

    // GET /
    @GetMapping("/")
    fun index(model: Model): String {
        ++n

        model.addAttribute("appName", APP_NAME)
        model.addAttribute("time",
            dateFormat.format(System.currentTimeMillis()))
        model.addAttribute("n", n)
        return "index"
    }

}