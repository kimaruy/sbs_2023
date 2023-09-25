package com.jhg.proto.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create/{questionId}")
    public String createComment(@PathVariable Long questionId, @ModelAttribute("commentForm") CommentForm commentForm, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            // 유효성 검사 오류 처리
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.commentForm", bindingResult);
            redirectAttributes.addFlashAttribute("commentForm", commentForm);
            return "redirect:/question/detail/" + questionId;
        }

        // 댓글 생성 및 저장 로직 추가
        // 사용자 이름 또는 세션에서 사용자 정보를 가져와서 설정

        // 댓글 생성
        // SiteUser user = userService.getCurrentUser(); // 현재 사용자 정보 가져오기
        // Comment comment = commentService.createComment(commentForm.getContent(), user);

        // 댓글과 질문 연결
        // Question question = questionService.getQuestion(questionId);
        // question.addComment(comment);
        // questionService.saveQuestion(question);

        return "redirect:/question/detail/" + questionId;
    }

    // 다른 댓글 관련 컨트롤러 메서드 추가
}
