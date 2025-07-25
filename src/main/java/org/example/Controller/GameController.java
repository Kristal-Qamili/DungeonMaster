package org.example.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.Entity.Choice;
import org.example.Entity.Question;
import org.example.Entity.User;
import org.example.REPO.QuestionREPO;
import org.example.REPO.UserREPO;
import org.example.Service.QuestionService;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game")
public class GameController {

    private final QuestionService questionService;
    private final UserService userService;
    private final UserREPO userREPO;
    private final QuestionREPO questionREPO;

    @Autowired
    public GameController(UserREPO userREPO, QuestionREPO questionREPO,QuestionService questionService,UserService userService) {
        this.userREPO = userREPO;
        this.questionREPO = questionREPO;
        this.questionService = questionService;
        this.userService = userService;
    }
    @GetMapping({"","/"})
    public String game(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/game/login";
        }

        User user = userREPO.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Question question = questionREPO.findById(user.getCurrentQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        model.addAttribute("username", username);
        model.addAttribute("question", question);

        // If it's a death question, show extra info
        boolean isDeath = user.getCurrentQuestionId().startsWith("death_");
        model.addAttribute("isDeath", isDeath);
        if (isDeath) {
            model.addAttribute("deathCount", user.getDeaths());
        }

        return "question";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/start")
    public String startGame(@RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
        userService.getOrCreateUser(username);
        return "redirect:/game/play";
    }
    @GetMapping("/end")
    public String endGame(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/game/login";
        }

        User user = userREPO.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("username", username);
        model.addAttribute("deathCount", user.getDeaths());
        model.addAttribute("message", "You have conquered the dungeon!");

        return "end";
    }


    @GetMapping("/play")
    public String play(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");

        if (username == null || username.trim().isEmpty()) {
            return "redirect:/game";
        }

        User user = userService.getOrCreateUser(username);
        String currentQuestionId = user.getCurrentQuestionId();

        if (currentQuestionId.startsWith("death_")) {
            return "redirect:/game/death";
        }

        Question question = questionService.getQuestionById(currentQuestionId);

        if (question.isEnd() || currentQuestionId.startsWith("end")) {
            return "redirect:/game/end";
        }

        model.addAttribute("question", question);
        model.addAttribute("username", username);
        model.addAttribute("isDeath", false);
        return "question";
    }
    @PostMapping("/choice")
    public String choose(@RequestParam String choiceId, HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/game/login";
        }

        User user = userREPO.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Question currentQuestion = questionREPO.findById(user.getCurrentQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Choice selectedChoice = currentQuestion.getChoices().stream()
                .filter(c -> c.getLabel().equalsIgnoreCase(choiceId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Choice not found"));

        String nextId = selectedChoice.getNextQuestionId();
        Question nextQuestion = questionREPO.findById(nextId)
                .orElseThrow(() -> new RuntimeException("Next question not found"));

        user.setCurrentQuestionId(nextId);

        boolean isDeath = nextId.startsWith("death");

        if (nextId.startsWith("death")) {
            user.setDeaths(user.getDeaths() + 1);
            user.setFinished(true);
            user.setCurrentQuestionId(nextId);
            userREPO.save(user);
            return "redirect:/game/death";
        }
        if (nextId.startsWith("end")) {
            user.setFinished(true);
            user.setCurrentQuestionId(nextId);
            userREPO.save(user);
            return "redirect:/game/end";
        }
        userREPO.save(user);


        if (isDeath) {
            model.addAttribute("deathCount", user.getDeaths());
        }

        return "redirect:/game/play";
    }



    @GetMapping("/death")
    public String deathScreen(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        User user = userREPO.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Question question = questionREPO.findById(user.getCurrentQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));
        model.addAttribute("username", username);
        model.addAttribute("message", question.getText());
        model.addAttribute("deathCount", user.getDeaths());
        return "death";
    }



    @PostMapping("/restart")
    public String restart(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/game/login";
        }

        User user = userREPO.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setCurrentQuestionId("q1");
        user.setFinished(false);
        userREPO.save(user);

        return "redirect:/game/play";
    }

    @GetMapping("/reset")
    public String resetGame(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null && !username.trim().isEmpty()) {
            userService.resetUser(username);
        }
        return "redirect:/game/play";
    }
}
