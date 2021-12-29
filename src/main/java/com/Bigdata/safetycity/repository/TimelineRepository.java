package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.Timeline;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TimelineRepository extends ReactiveMongoRepository<Timeline, String> {
    @Tailable // 커서를 안 닫고 계속 유지한다.
    @Query("{name:?0}")// 몽고디비 문법ㅇ
    Flux<Timeline> mFindBySender(String name);// Flux(흐름) 계속해서 받겠다 response를 유지하면서 데이터 흘려보내기

    @Tailable // 커서를 안 닫고 계속 유지한다.
    @Query("{ roomNum: ?0 }")// 몽고디비 문법ㅇ
    Flux<Timeline> mFindByRoomNum(int roomNum);// Flux(흐름) 계속해서 받겠다 response를 유지하면서 데이터 흘려보내기

}
