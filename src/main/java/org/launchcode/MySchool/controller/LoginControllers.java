package org.launchcode.MySchool.controller;

public class LoginControllers {
    @RestController
    @RequestMapping("/login")
    public class LoginController {
        @Autowired
        private AuthenticationManager authenticationManager;

        @PostMapping
        public ResponseEntity<String> login(@RequestBody LoginRequest request) {
            try {
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
                );
                return ResponseEntity.ok("Login successful for " + auth.getAuthorities());
            } catch (BadCredentialsException e) {
                return ResponseEntity.status(401).body("Invalid credentials");
            }
        }
    }

    // DTO for login
    public class LoginRequest {
        private String username;
        private String password;
        // Getters/setters
    }
}
