package com.hdaf.testtasksuperheroapp.feature_superhero.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hdaf.testtasksuperheroapp.feature_superhero.data.local.entity.SuperheroEntity

@Database(
    entities = [SuperheroEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SuperheroDataBase : RoomDatabase() {

    abstract val dao: SuperheroDao
}