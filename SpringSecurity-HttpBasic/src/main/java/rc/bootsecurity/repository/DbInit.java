package rc.bootsecurity.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.bootsecurity.model.User;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Delete all 
        userRepository.deleteAll();

        // Create Users
        User tushar = new User("tushar", passwordEncoder.encode("tushar123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager"), "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(tushar, admin, manager);

        userRepository.saveAll(users);

    }
}
