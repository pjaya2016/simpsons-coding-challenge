package challagesimpson.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		if("simpson".contentEquals(username)) 
		{
			return new User("simpson",
					"$2a$10$5l2UoLI5vBDBIai3jQrSwusj62AlhfE4ELCk429fVAQUEGQ9GsWZG"
					,new ArrayList<>());
		}else 
		{
			throw new UsernameNotFoundException("User Not Found");
		}
	}
}
