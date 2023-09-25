package com.jhg.proto.comment;

import com.jhg.proto.festival.Festival;
import com.jhg.proto.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private SiteUser author;

    @ManyToOne
    @JoinColumn(name = "festival_id")
    private Festival festival;

    // Getter와 Setter 메서드
}
