package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// specify that Item is the only class, version of database schema, and that history of schema is not preserved
@Database(entities = [Item :: class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    //returns the ItemDao so that the database knows about the DAO
    abstract fun itemDao(): ItemDao

    //The Singleton Pattern Implementation:
    //  if the assignment to Instance is skipped or app process killed in the background, the database resets to null.
    // for this implementation, a good fallback could be .fallbackToDestructiveMigration()
    // though with development if the file becomes corrupted or a context change happens, the database will still clear.
    // Emulators often have snapshot resets which is likely the cause for a change in the DB in my case.
    companion object {
        //allows access to the methods to create or get the database and uses the class name as the qualifier
        @Volatile   //never cached, all reads and writes are from main memory
        private var Instance: InventoryDatabase? = null //keeps a reference to the database, when one has been created

        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) { //elvis operator, this is companion obj, with application context

                //.fallbackToDestructiveMigration() as migration strategy to the builder
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it } //keep reference of the new database instance
            }
        }
    }
}