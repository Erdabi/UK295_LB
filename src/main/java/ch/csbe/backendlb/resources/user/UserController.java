package ch.csbe.backendlb.resources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * Controller for managing user-related operations.
 */
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * Retrieve a list of all users.
     *
     * @return A list of users.
     */
    @GetMapping()
    @Operation(
            summary = "Holen Sie alle Benutzer",
            operationId = "getUsers",
            description = "Holen Sie eine Liste aller Benutzer."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Benutzer gefunden",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAll();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Create a new user.
     *
     * @param user The user to create.
     * @return The created user.
     */
    @PostMapping()
    @Operation(
            summary = "Erstellen Sie einen neuen Benutzer",
            operationId = "createUser",
            description = "Erstellen Sie einen neuen Benutzer."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Benutzer erstellt",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Ungültige Anforderung"
    )
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (isValidUser(user)) {
            User createdUser = userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Check if the user is valid.
     *
     * @param user The user to validate.
     * @return True if the user is valid, false otherwise.
     */
    private boolean isValidUser(User user) {
        if (user == null) {
            return false;
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return false;
        }

        return user.getPassword() != null && !user.getPassword().isEmpty();
    }

    /**
     * Retrieve a user by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Holen Sie einen Benutzer anhand seiner ID",
            operationId = "getUserById",
            description = "Holen Sie einen Benutzer anhand seiner ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Benutzer gefunden",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Benutzer nicht gefunden"
    )
    public ResponseEntity<User> getUserById(
            @Parameter(description = "ID des Benutzers") @PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Update a user by ID.
     *
     * @param id    The ID of the user to update.
     * @param user  The updated user information.
     * @return The updated user if successful, or 404 if not found.
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Aktualisieren Sie einen Benutzer anhand seiner ID",
            operationId = "updateUserById",
            description = "Aktualisieren Sie einen Benutzer anhand seiner ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Benutzer aktualisiert",
            content = @Content(schema = @Schema(implementation = User.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Benutzer nicht gefunden"
    )
    public ResponseEntity<User> updateUserById(
            @Parameter(description = "ID des Benutzers") @PathVariable("id") Long id,
            @RequestBody User user) {
        User updatedUser = userService.update(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a user by ID.
     *
     * @param id The ID of the user to delete.
     * @return 204 if successful, or 404 if not found.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Löschen Sie einen Benutzer anhand seiner ID",
            operationId = "deleteUserById",
            description = "Löschen Sie einen Benutzer anhand seiner ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Benutzer gelöscht"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Benutzer nicht gefunden"
    )
    public ResponseEntity<Void> userById(
            @Parameter(description = "ID des zu löschenden User") @PathVariable Long id) {
        userService.delete(id);
        if (!userService.userExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    /**
     * Register a new user.
     *
     * @return A message indicating user registration.
     */
    @PostMapping("/user/register")
    @Operation(
            summary = "Registrieren Sie einen neuen Benutzer",
            operationId = "registerNewUser",
            description = "Hier kann sich ein Benutzer registrieren."
    )
    public ResponseEntity<String> registerNewUser() {
        return ResponseEntity.ok("Hier kann sich ein Benutzer registrieren");
    }

    /**
     * Assign administrator rights to a user.
     *
     * @param userId The ID of the user to assign administrator rights to.
     * @return A message indicating the assignment of administrator rights.
     */
    @PutMapping("/users/assign-admin/{userId}")
    @Operation(
            summary = "Weisen Sie einem Benutzer Administratorrechte zu",
            operationId = "assignAdmin",
            description = "Hier kann ein Administrator Administratorrechte einem Benutzer zuweisen."
    )
    public ResponseEntity<String> assignAdmin(
            @Parameter(description = "ID des Benutzers") @PathVariable String userId) {
        return ResponseEntity.ok("Hier kann ein Administrator Administratorrechte einem Benutzer zuweisen: " + userId);
    }
}
