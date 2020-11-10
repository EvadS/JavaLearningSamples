package net.proselite.spring.security.app.service;


        import net.proselite.spring.security.app.model.User;

/**
 * Service class for {@link net.proselite.spring.security.app.model.User}
 *
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}