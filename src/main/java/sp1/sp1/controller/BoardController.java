package sp1.sp1.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sp1.sp1.domain.BoardVO;
import sp1.sp1.domain.Criteria;
import sp1.sp1.domain.PageDTO;
import sp1.sp1.service.BoardService;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

//    @Autowired
    private BoardService boardService;

    // List //////////
//    @GetMapping("/list")
//    public void list(Model model){
//        log.info("=====> Controller - list");
//        List<BoardVO> list = boardService.getList();
//        System.out.println(list);
//        model.addAttribute("list", list);
//    }

    @GetMapping("/list")
    public void list(
            Criteria criteria,
            Model model){
        log.info("=====> Controller - list: " + criteria);

        int total = boardService.getTotal(criteria);

        model.addAttribute("list", boardService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(criteria, total));
    }

    // Register //////////
    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes rttr) {
        log.info("=====> Controller - register: " + boardVO);

        boardService.register(boardVO);

        rttr.addFlashAttribute("result", boardVO.getBno());
        return "redirect:/board/list";
    }

    // Get //////////
    @GetMapping({"/get", "/modify"})
    public void get(
            @RequestParam("bno") Long bno,
            @ModelAttribute("criteria") Criteria criteria,
            Model model){
        log.info("=====> Controller - get or modify");

        model.addAttribute("board", boardService.get(bno));
    }

    // Modify //////////
    @PostMapping("/modify")
    public String modify(
            BoardVO boardVO,
            @ModelAttribute("criteria") Criteria criteria,
            RedirectAttributes rttr){
        log.info("=====> Controller - modify: " + boardVO);

        if (boardService.modify(boardVO)) {
            rttr.addFlashAttribute("result", "success");
        }

//        rttr.addAttribute("pageNum", criteria.getPageNum());
//        rttr.addAttribute("amount", criteria.getAmount());
//        rttr.addAttribute("type", criteria.getType());
//        rttr.addAttribute("keyword", criteria.getKeyword());

        return "redirect:/board/list" + criteria.getListLink();
    }

    // Remove //////////
    @PostMapping("/remove")
    public String remove(
            @RequestParam("bno") Long bno,
            @ModelAttribute("criteria") Criteria criteria,
            RedirectAttributes rttr) {
        log.info("=====> Controller - remove " + bno);

        if(boardService.remove(bno)){
            rttr.addFlashAttribute("result", "success");
        }

//        rttr.addAttribute("pageNum", criteria.getPageNum());
//        rttr.addAttribute("amount", criteria.getAmount());
//        rttr.addAttribute("type", criteria.getType());
//        rttr.addAttribute("keyword", criteria.getKeyword());

        return "redirect:/board/list" + criteria.getListLink();
    }
}
