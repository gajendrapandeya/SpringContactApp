
package com.codderMonkey.service;

import com.codderMonkey.domain.Contact;
import java.util.List;

/**
 *
 * @author gajen
 */
public interface ContactService {
    
    public void save(Contact c);
    public void update(Contact c);
    public void delete(Integer contactId);
    
    //used to delete bulk of contacts
    public void delete(Integer[] contactIds);
    
    /**
     * This method returns all User Contact (user who is logged in).
     *
     * @param userId
     * @return
     */
    public List<Contact> findUserContact(Integer userId);
    
    /**
     * The method search contact for user(userId) based on given
     * free-text-criteria (txt)
     *
     * @param userId User who is logged in
     * @param txt criteria used to search - free text search criteria
     * @return
     */
    public List<Contact> findUserContact(Integer userId, String txt);
    
    public Contact findById(Integer cotactId);
    
}
