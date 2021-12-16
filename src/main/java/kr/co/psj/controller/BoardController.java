package kr.co.psj.controller;

import kr.co.psj.model.Board;
import kr.co.psj.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*

 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll(); // DB의 데이터를 모두 들고 올 수 있습니다.
        model.addAttribute("boards", boards);

        return "/board/list";
    }

    @GetMapping("/form")
    public String form(Model model) {

        return "/board/form";
    }
}

























