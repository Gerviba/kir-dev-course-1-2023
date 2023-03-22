package hu.kirdev.board.controller.task3

import hu.kirdev.board.model.FormMessage
import hu.kirdev.board.service.FormService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class FormController(
    private val formService: FormService
) {

    // Extra Task 1.2: Create an endpoint for the form based on the board.
    @GetMapping("/form")
    fun showForm(model: Model, @RequestParam(defaultValue = "") done: String): String {
        model.addAttribute("appName", "Form Example")
        if (done == "true")
            model.addAttribute("done", true)
        return "form"
    }

    // Extra Task 1.3: Create an endpoint to save the form submissions.
    // You might create a new service to save it, but it is not required. You can save it in this class as well.
    @PostMapping("/form")
    fun submitForm(model: Model, @ModelAttribute form: FormMessage): String {
        formService.createSubmission(form.name, form.email, form.age)
        return "redirect:/form?done=true"
    }

    // Extra Task 1.4: Create an endpoint to list the results.
    // For example: GET /api/form-responses
    @ResponseBody
    @GetMapping("/api/form-responses")
    fun apiFormSubmissions(): List<FormMessage> {
        return formService.getAllSubmissions()
    }

    // Extra Task 1.5: Optional: Validate the form responses.
    // See: https://www.baeldung.com/spring-boot-bean-validation
    // or come up with your own (e.g. add a model attribute called error and if it is not null show it to the user)

}