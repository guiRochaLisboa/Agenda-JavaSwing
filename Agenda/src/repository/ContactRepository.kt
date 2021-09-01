package repository

import entity.ContactEntity

class ContactRepository {

    companion object {

        private val contactList = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity) {
            contactList.add(contact)
        }

        fun delete(contact: ContactEntity) {
            var index = 0
            for(i in contactList.withIndex()){
                if(i.value.name == contact.name && i.value.phone == contact.phone){
                    index = i.index
                    break
                }
            }
            contactList.removeAt(index)
        }

        fun getList() : List<ContactEntity>{
            return contactList
        }
    }
}