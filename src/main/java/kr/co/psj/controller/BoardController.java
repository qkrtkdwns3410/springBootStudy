package kr.co.psj.controller;

import kr.co.psj.model.Board;
import kr.co.psj.repository.BoardRepository;
import kr.co.psj.validator.BoardValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/*

 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardValidation boardValidation;

    @GetMapping("/list")

    public String list(Model model, Pageable pageable) {
        Page<Board> boards = boardRepository.findAll(pageable); // DB의 데이터를 모두 들고 올 수 있습니다.

        boards.getTotalElements();
        model.addAttribute("boards", boards);

        return "/board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);

        }
        return "/board/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@Valid Board board, BindingResult bindingResult) {
        boardValidation.validate(board, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/board/form";
        }
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}

























