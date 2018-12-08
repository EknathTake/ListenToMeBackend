package com.listenme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.listenme.domain.model.Activity;

@Repository("activityRepository")
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
