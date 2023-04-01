package sp1.sp1.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sp1.sp1.domain.BoardVO;
import sp1.sp1.service.BoardService;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

//    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model){
        log.info("=====> Controller - list");
        List<BoardVO> list = boardService.getList();
        System.out.println(list);
        model.addAttribute("list", list);

        return "board/list";
    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes rttr) {
        log.info("=====> Controller - register: " + boardVO);

        boardService.register(boardVO);

        rttr.addFlashAttribute("result", boardVO.getBno());
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public void get(
            @RequestParam("bno") Long bno,
            Model model){
        log.info("=====> Controller - get");

        model.addAttribute("board", boardService.get(bno));
    }

    @PostMapping("/modify")
    public String modify(
            BoardVO boardVO,
            RedirectAttributes rttr){
        log.info("=====> Controller - modify: " + boardVO);

        if (boardService.modify(boardVO)) {
            rttr.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(
            @RequestParam("bno") Long bno,
            RedirectAttributes rttr) {
        log.info("=====> Controller - remove " + bno);

        if(boardService.remove(bno)){
            rttr.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }
}
