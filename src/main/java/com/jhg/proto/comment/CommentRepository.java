package com.jhg.proto.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 추가적인 쿼리 메서드가 필요하다면 여기에 추가
}
