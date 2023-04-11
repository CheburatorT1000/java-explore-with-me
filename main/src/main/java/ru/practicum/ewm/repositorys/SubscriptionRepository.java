package ru.practicum.ewm.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.entity.model.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByFollowerIdAndPublisherId(Long userId, Long publisherId);

    List<Subscription> findByFollowerId(Long userId);
}
