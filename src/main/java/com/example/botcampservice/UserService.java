package com.example.botcampservice;

/*
 * import java.util.Arrays; import java.util.HashSet;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.example.botcampEntites.Role; import
 * com.example.botcampEntites.User; import
 * com.example.botcampRepository.RoleRepository; import
 * com.example.botcampRepository.UserRepository;
 * 
 * @Service public class UserService { private UserRepository userRepository;
 * private RoleRepository roleRepository; private BCryptPasswordEncoder
 * bCryptPasswordEncoder;
 * 
 * @Autowired public UserService(UserRepository userRepository, RoleRepository
 * roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
 * this.userRepository = userRepository; this.roleRepository = roleRepository;
 * this.bCryptPasswordEncoder = bCryptPasswordEncoder; }
 * 
 * public User findUserByEmail(String email) { return
 * userRepository.findByEmail(email); }
 * 
 * public void saveUser(User user, String role, int active) {
 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
 * user.setActive(active); Role userRole = roleRepository.findByRole(role);
 * user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
 * userRepository.save(user); }
 * 
 * 
 * 
 * }
 */