package com.dancestudioSpring.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dancestudioSpring.Component.JwtUtil;
import com.dancestudioSpring.Service.AdminService;

import io.jsonwebtoken.SignatureException;

@Component
public class JwtAdminAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AdminService adminService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestTokenHeader = request.getHeader("Authorization");
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			String accessToken = requestTokenHeader.substring(7);

			try {
				
				//String username = jwtUtil.extractUsername(accessToken);
				//UserDetails adminUserDetails = adminService.loadUserByUsername(username);
				String idOfAdminAsString = jwtUtil.extractUsername(accessToken);
	            int id_of_admin = Integer.parseInt(idOfAdminAsString);
				UserDetails adminUserDetails = adminService.loadAdminById(id_of_admin);
				
				if(idOfAdminAsString != null && SecurityContextHolder.getContext().getAuthentication()  == null) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
							new UsernamePasswordAuthenticationToken(adminUserDetails, null, adminUserDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
				
			} catch(SignatureException e) {
				System.out.println("Wrong accessToken");
			}
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
