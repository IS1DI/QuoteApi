package com.is1di.quoteapi.repository;

import com.is1di.quoteapi.model.entity.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<Vote, UUID> {
    Page<Vote> findByQuote_IdOrderByCreatedAtAsc(UUID id, Pageable pageable);
    Page<Vote> findByVotedBy_LoginAndQuote_IdOrderByCreatedAtAsc(String login, UUID id, Pageable pageable);
    boolean existsByVotedBy_LoginAndQuote_Id(String login, UUID id);
}