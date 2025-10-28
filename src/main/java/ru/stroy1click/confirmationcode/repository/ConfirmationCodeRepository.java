package ru.stroy1click.confirmationcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stroy1click.confirmationcode.entity.ConfirmationCode;
import ru.stroy1click.confirmationcode.model.Type;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Long> {

    Optional<ConfirmationCode> findByTypeAndUserId(Type type, Long userId);

    void deleteByTypeAndUserId(Type type, Long userId);

    Integer countByTypeAndUserId(Type type, Long userId);

    void deleteByCode(Integer code);

    List<ConfirmationCode> findAllByUserId(Long userId);
}
