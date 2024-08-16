package com.example.contactmanagerapp.repository

import com.example.contactmanagerapp.room.Contact
import com.example.contactmanagerapp.room.ContactDAO

class ContactRepository(private val contactDAO: ContactDAO) {

    val contacts=contactDAO.getAllContactsInDB()

    suspend fun insert(contact: Contact):Long{
        return contactDAO.insertContact(contact)
    }

    suspend fun update(contact: Contact){
        return contactDAO.updateContact(contact)
    }

    suspend fun delete(contact: Contact){
        return contactDAO.deleteContact(contact)
    }

    suspend fun deleteAll(){
        return contactDAO.deleteAll()
    }

}