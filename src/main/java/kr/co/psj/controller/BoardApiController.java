package kr.co.psj.controller;

import kr.co.psj.model.Board;
import kr.co.psj.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

 */
@RestController
@RequestMapping("/api")
class BoardApiController {
    @Autowired
    private BoardRepository repository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/boards")
    List<Board> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/boards")
    Board newEmployee(@RequestBody Board board) {
        return repository.save(board);
    }

    // Single item

    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {

        return repository.findById(id)
                .orElse(null);
    }

    @PutMapping("/boards/{id}")
    Board replaceEmployee(@RequestBody Board board, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    board.setTitle(board.getTitle());
                    board.setContent(board.getContent());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    board.setId(id);
                    return repository.save(board);
                });
    }

    @DeleteMapping("/boards/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

























