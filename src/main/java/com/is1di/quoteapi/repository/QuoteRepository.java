package com.is1di.quoteapi.repository;

import com.is1di.quoteapi.model.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, UUID> {
    List<Quote> findByVotes_IsUpVotedOrderByVotes_IsUpVotedAsc(boolean isUpVoted);

    @Query("from Quote q group by q order by (select sum(case when (v.isUpVoted = :upVoted) then 1 else 0 end) from Vote v where q.id = v.quote.id ) desc ")
    List<Quote> findByVotesIsUpVoted(@Param("upVoted") boolean upVoted);

    @Query("from Quote order by random() limit 1")
    Optional<Quote> findRandom();
}