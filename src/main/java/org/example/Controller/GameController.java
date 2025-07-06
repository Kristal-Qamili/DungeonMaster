package org.example.Controller;


import org.example.Entity.Question;
import org.example.Entity.User;
import org.example.Service.QuestionService;
import org.example.Service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game")
public class GameController {

    private final QuestionService questionService;
    private final UserService userService;

    @Autowired
    public GameController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @GetMapping
    public String loginPage() {
        return "login";

    }

    @PostMapping("/start")
    public String startGame(@RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
        userService.getOrCreateUser(username);
        return "redirect:/game/play";
    }

    @GetMapping("/play")
    public String play(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/game";
        }

        User user = userService.getOrCreateUser(username);
        Question question = questionService.getQuestionById(user.getCurrentQuestionId());

        if (question.isEnd()) {
            model.addAttribute("username", username);
            model.addAttribute("message", question.getText());
            model.addAttribute("deaths", user.getDeaths());
            return "end";
        }

        model.addAttribute("question", question);
        model.addAttribute("username", username);
        return "question";
    }

    @PostMapping("/choice")
    public String handleChoice(
            @RequestParam String choiceId,
            HttpSession session
    ) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/game";
        }

        User user = userService.getOrCreateUser(username);
        Question question = questionService.getQuestionById(user.getCurrentQuestionId());

        var choice = question.getChoices().stream()
                .filter(c -> c.getLabel().equalsIgnoreCase(choiceId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid choice"));

        String nextId = choice.getNextQuestionId();
        Question nextQuestion = questionService.getQuestionById(nextId);

        userService.updateProgress(username, nextId, nextQuestion.isDeath(), nextQuestion.isEnd());

        return "redirect:/game/play";
    }

    @GetMapping("/reset")
    public String resetGame(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            userService.resetUser(username);
        }
        return "redirect:/game/play";
    }
}
