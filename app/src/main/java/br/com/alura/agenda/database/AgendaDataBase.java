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
import br.com.alura.agenda.model.Aluno;

@Database(entities = {Aluno.class},version = 4,exportSchema = false)
@TypeConverters(ConversorCalendar.class)
public abstract class AgendaDataBase extends RoomDatabase {
    public abstract RoomAlunoDAO getRoomAlunoDAO();

    public static AgendaDataBase getInstance(Context context)
    {
        return   Room.databaseBuilder(context, AgendaDataBase.class, "agenda.db")
                .allowMainThreadQueries()
                .addMigrations(new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
                    }
                }, new Migration(2, 3) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_Temp` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefone` TEXT, `email` TEXT)");
                        database.execSQL("INSERT INTO Aluno_Temp (id, nome, telefone, email) SELECT id, nome, telefone, email FROM Aluno");
                        database.execSQL("DROP TABLE Aluno");
                        database.execSQL("ALTER TABLE Aluno_Temp RENAME TO Aluno");

                    }
                }, new Migration(3,4) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_Temp` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefone` TEXT, `email` TEXT, `data` INTEGER)");
                        database.execSQL("INSERT INTO Aluno_Temp (id, nome, telefone, email) SELECT id, nome, telefone, email FROM Aluno");
                        database.execSQL("DROP TABLE Aluno");
                        database.execSQL("ALTER TABLE Aluno_Temp RENAME TO Aluno");
                    }
                })
                .build();
    };
}

