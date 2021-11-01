package br.com.alura.agenda.database.migrations;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class AgendaMigrations {
    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_Temp` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefone` TEXT, `email` TEXT)");
            database.execSQL("INSERT INTO Aluno_Temp (id, nome, telefone, email) SELECT id, nome, telefone, email FROM Aluno");
            database.execSQL("DROP TABLE Aluno");
            database.execSQL("ALTER TABLE Aluno_Temp RENAME TO Aluno");

        }
    };
    private static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_Temp` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefone` TEXT, `email` TEXT, `data` INTEGER)");
            database.execSQL("INSERT INTO Aluno_Temp (id, nome, telefone, email) SELECT id, nome, telefone, email FROM Aluno");
            database.execSQL("DROP TABLE Aluno");
            database.execSQL("ALTER TABLE Aluno_Temp RENAME TO Aluno");
        }
    };

    private static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Aluno_Temp` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefoneFixo` TEXT,`telefoneCelular` TEXT,`email` TEXT, `data` INTEGER)");
            database.execSQL("INSERT INTO Aluno_Temp (id, nome, telefoneFixo, email) SELECT id, nome, telefone astelefoneFixo, email FROM Aluno");
            database.execSQL("DROP TABLE Aluno");
            database.execSQL("ALTER TABLE Aluno_Temp RENAME TO Aluno");
        }
    };
    public static final Migration[] MIGRATION = {MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4,MIGRATION_4_5};
}
