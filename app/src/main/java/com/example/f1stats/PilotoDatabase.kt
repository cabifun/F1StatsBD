package com.example.f1stats
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Piloto::class], version = 1)
abstract class PilotoDatabase : RoomDatabase() {
    abstract fun pilotoDao(): PilotoDao

    companion object {
        @Volatile
        private var INSTANCE: PilotoDatabase? = null

        fun getDatabase(context: Context): PilotoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PilotoDatabase::class.java,
                    "piloto_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}