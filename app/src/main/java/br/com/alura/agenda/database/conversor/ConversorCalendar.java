package br.com.alura.agenda.database.conversor;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Calendar;

public class ConversorCalendar {
    @TypeConverter
    public Long paraLong(Calendar valor)
    {
        if(valor != null){
            return  valor.getTimeInMillis();
        }
        return null;
    }
    @TypeConverter
    public Calendar paraCalendar(Long valor)
    {
        Calendar instance = Calendar.getInstance();
        if(valor != null) {
            instance.setTimeInMillis(valor);
        }
        return instance;
    }
}
