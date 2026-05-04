    package com.ProyectoSergi.Proyecto.controller;

    import com.BackendSergi.domain.entity.Comment;
    import com.BackendSergi.domain.entity.User;
    import com.BackendSergi.domain.service.CommentService;
    import com.BackendSergi.domain.service.UserService;
    import jakarta.servlet.http.HttpServletRequest;
    import org.springframework.security.core.Authentication;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.time.LocalDateTime;

    @Controller
    @RequestMapping("comment")
    public class BlogController {

        private CommentService commentService;
        private UserService userService;

        public BlogController(CommentService commentService, UserService userService) {
            this.commentService = commentService;
            this.userService = userService;

        }

        @PostMapping("/addComment")
        public String addComment(@RequestParam String entityType, @RequestParam Long entityId, @RequestParam String content,
        Authentication authentication, HttpServletRequest request) {

             String username = authentication.getName();

             User user = userService.findByUsername(username).orElseThrow( () -> new RuntimeException("Usuario no encontrado"));

             Comment newComment = new Comment();
             newComment.setContent(content);
             newComment.setEntityType(entityType);
             newComment.setEntityId(entityId);
             newComment.setCreatedAt(LocalDateTime.now());
             newComment.setUser(user);
             commentService.save(newComment);

             String referer = request.getHeader("referer");
            return "redirect:" + (referer != null ? referer : "/");
        }

    }
