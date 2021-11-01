package br.com.alura.agenda.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.com.alura.agenda.dao.RoomAlunoDAO;
import br.com.alura.agenda.database.conversor.ConversorCalendar;
import br.com.alura.agenda.database.migrations.AgendaMigrations;
import br.com.alura.agenda.model.Aluno;

@Database(entities = {Aluno.class},version = 4,exportSchema = false)
@TypeConverters(ConversorCalendar.class)
public abstract class AgendaDataBase extends RoomDatabase {
    public abstract RoomAlunoDAO getRoomAlunoDAO();

    public static AgendaDataBase getInstance(Context context)
    {
        return   Room.databaseBuilder(context, AgendaDataBase.class, "agenda.db")
                .allowMainThreadQueries()
                .addMigrations(AgendaMigrations.MIGRATION)
                .build();
    };
}

