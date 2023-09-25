package com.jhg.proto.festival;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FestivalService {
    private final FestivalRepository festivalRepository;

    public List<Festival> getListByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Festival> festivalPage = festivalRepository.findAll(pageable);
        List<Festival> festivals = festivalPage.getContent();

        // Comment 목록을 함께 로드
        festivals.forEach(festival -> festival.getCommentList().size());

        return festivals;
    }

    public int getTotalCount() {
        return (int) festivalRepository.count();
    }

    public Festival getFestivalById(Integer id) {
        return festivalRepository.findById(id).orElse(null);
    }
}
