package com.listenme.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.listenme.domain.entity.Action;

/**
 * 
 * @author eknath.take
 *
 */
@Repository("actionRepository")
public interface ActionRepository extends JpaRepository<Action, Long> {

	// @Query("SELECT p FROM Action p, Activity q WHERE p.voiceCmd = :command AND
	// p.id=q.actions")
	Set<Action> findAllByVoiceCmd(@Param("command") String command);
}
