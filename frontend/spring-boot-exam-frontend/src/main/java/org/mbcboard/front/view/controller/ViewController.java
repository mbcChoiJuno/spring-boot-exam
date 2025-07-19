package org.mbcboard.front.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class ViewController {

    @GetMapping({"/list"})
    public String listPage() {
        return "list";
    }

    @GetMapping("/read")
    public String readPage() {
        return "read";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/modify")
    public String modifyPage() {
        return "modify";
    }
}
