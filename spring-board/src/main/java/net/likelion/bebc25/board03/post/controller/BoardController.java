package net.likelion.bebc25.board03.post.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.likelion.bebc25.board03.post.dto.PostDto;
import net.likelion.bebc25.board03.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/03/board")
public class BoardController {

    private final PostService postService;

    public BoardController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 목록 조회하는 컨트롤러
    @GetMapping("/list.html")
    public String getBoardList(Model model) {
        List<PostDto> posts = postService.getPosts();

        model.addAttribute("posts", posts);

        return "board/list";
    }

    // 게시글 상세 조회하는 컨트롤러
    @GetMapping("/detail.html")
    public String getDetail(@RequestParam("id") int id, Model model) {
        PostDto post = postService.getPost(id);
        model.addAttribute("post", post);

        return "board/detail";
    }

    // 게시글 등록 화면을 요청하는 컨트롤러
    @GetMapping("/write.html")
    public String getWriteForm(@ModelAttribute("postForm") PostDto post) {
        return "board/write";
    }

    // 게시글 수정 화면을 요청하는 컨트롤러
    @GetMapping("/edit.html")
    public String getEditForm(@RequestParam("id") int id, Model model) {
        PostDto post = postService.getPost(id);

        model.addAttribute("postForm", post);
        return "board/write";
    }


    @PostMapping("/write")
    public String writePost(@Valid @ModelAttribute("postForm") PostDto post, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "board/write";
        }
        postService.writePost(post);

        return "redirect:list.html";
    }

    // 게시글 수정 요청을 처리하는 컨트롤러
    @PostMapping("/edit")
    public String editPost(@Valid @ModelAttribute("postForm") PostDto post, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "board/write";
        }

        postService.editPost(post);
        return "redirect:list.html";
    }

    // 게시글 삭제 요청을 처리하는 컨트롤러
    @PostMapping("/delete")
    public String deletePost(@RequestParam("id") int id) {
        postService.removePost(id);
        return "redirect:list.html";
    }
}
