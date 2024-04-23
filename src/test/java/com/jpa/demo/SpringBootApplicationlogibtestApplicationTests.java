package com.jpa.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.demo.springlogintest.Userinfo;
import com.jpa.demo.springlogintest.Userrepository;
import com.jpa.demo.springlogintest.Userservice;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SpringBootApplicationlogibtestApplicationTests {
    
    @InjectMocks
    private Userservice userservice; // The service being tested
    
    @Mock
    private Userrepository userrepositorymock; // The mocked repository
    
    @Test
    public void addusertest_exists() 
    {
        
        Userinfo existinguserinfo = new Userinfo();
        
        existinguserinfo.setId(1);
        existinguserinfo.setEmail("amar@example.com");
        existinguserinfo.setFirstName("amar");
        existinguserinfo.setLastName("vaka");
        existinguserinfo.setUsername("testuser");
        existinguserinfo.setPassword("password");
        when(userrepositorymock.findByUsername("testuser")).thenReturn(Optional.of(existinguserinfo));
        Userinfo newuser = new Userinfo();
        newuser.setUsername("testuser");
        String result = userservice.adduser(newuser);
        assertEquals("Username already exists: testuser", result);
        verify(userrepositorymock,times(0)).save(newuser);
    }
    
    @Test
    public void testadduser_usernnamenotexists()
    {
    	when(userrepositorymock.findByUsername("testuser")).thenReturn(Optional.empty());
    	
        Userinfo newuser = new Userinfo();
        newuser.setUsername("testuser");
        
        String result = userservice.adduser(newuser);
        
        assertTrue(result.contains("User added successfully"));
        assertTrue(result.contains(newuser.getUsername()));
        verify(userrepositorymock,times(1)).save(newuser);
    }
    
    
    
    @Test
    public void checkusertest_notnull()
    {
    	
    	Userinfo u = new Userinfo();
        
        u.setId(2);
        u.setEmail("amar@example.com");
        u.setFirstName("amar");
        u.setLastName("vaka");
        u.setUsername("amarsammy");
        u.setPassword("password");
        
        when(userrepositorymock.findById(u.getId())).thenReturn(Optional.of(u));
        
        Userinfo ru =userservice.checkUser(2);
        assertNotNull(ru);
        assertEquals(2,ru.getId());
        assertEquals("amar@example.com",ru.getEmail());
        assertEquals("amar",ru.getFirstName());
        assertEquals("vaka",ru.getLastName());
        assertEquals("amarsammy",ru.getUsername());
        assertEquals("password",ru.getPassword());
        
    }
    
    @Test
    public void checkusertest_null()
    {
    	when(userrepositorymock.findById(4)).thenReturn(Optional.empty());
    	
    	Userinfo ru1 = userservice.checkUser(4);
    	assertNull(ru1);
    }
    
}
