package ch.csbe.backendlb.resources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UserService interface for user-related operations.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Constructor to inject the UserRepository dependency.
     *
     * @param userRepository The UserRepository instance.
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of User objects.
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The User object if found, or null if not found.
     */
    @Override
    public User getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    /**
     * Creates a new user.
     *
     * @param user The User object to create.
     * @return The created User object.
     */
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing user by their ID.
     *
     * @param id   The ID of the user to update.
     * @param user The updated User object.
     * @return The updated User object if found, or null if not found.
     */
    @Override
    public User update(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     */
    @Override
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("User with the id " + id + " could not be found!");
        }
    }

    /**
     * Checks if a user with a specific ID exists.
     *
     * @param id The ID of the user to check.
     * @return True if the user exists, false otherwise.
     */
    public boolean userExistsById(Long id) {
        return userRepository.existsById(id);
    }
}
