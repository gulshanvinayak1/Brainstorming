//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Repository;

import com.ghanshyam.Brainstroming.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByGmailId(String gmailId);

    Optional<User> findByUserId(String userId);
}
