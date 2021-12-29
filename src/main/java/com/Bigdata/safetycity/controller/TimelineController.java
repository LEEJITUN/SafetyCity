package com.Bigdata.safetycity.controller;

import com.Bigdata.safetycity.model.Timeline;
import com.Bigdata.safetycity.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.sql.Time;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class TimelineController {
    @Autowired
    private final TimelineRepository timeLineRepository;
    // 귓속말 할 때 사용한다.
    @CrossOrigin
    @GetMapping(value = "/name/{name}/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Timeline> getMsg(@PathVariable String name){
        return timeLineRepository.mFindBySender(name)
                .subscribeOn(Schedulers.boundedElastic());
    }// 여러 건 리턴

    @CrossOrigin
    @PostMapping("/send/{name}")
    public Mono<Timeline> setMsg(@PathVariable String name){
        Timeline timeline = new Timeline();
        timeline.setName(name);
        return timeLineRepository.save(timeline);
    }// 한 건 리턴
}
