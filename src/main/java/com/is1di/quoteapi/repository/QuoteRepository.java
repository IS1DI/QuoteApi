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
    @Query("select distinct q from Quote q left join q.votes v where v.isUpVoted = :#{upVoted} order by max() limit 10")
    List<Quote> findByVotesIsUpVoted(@Param("upVoted") boolean upVoted);

    @Query("from Quote order by random() limit 1")
    Optional<Quote> findRandom();
}