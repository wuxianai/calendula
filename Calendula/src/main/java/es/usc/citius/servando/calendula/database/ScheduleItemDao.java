package es.usc.citius.servando.calendula.database;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import es.usc.citius.servando.calendula.persistence.Routine;
import es.usc.citius.servando.calendula.persistence.Schedule;
import es.usc.citius.servando.calendula.persistence.ScheduleItem;

/**
 * Created by joseangel.pineiro on 3/26/15.
 */
public class ScheduleItemDao extends GenericDao<ScheduleItem, Long> {


    public ScheduleItemDao(DatabaseHelper db) {
        super(db);
    }

    @Override
    public Dao<ScheduleItem, Long> getConcreteDao() {
        try {
            return dbHelper.getScheduleItemsDao();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating medicines dao", e);
        }
    }

    public List<ScheduleItem> findBySchedule(Schedule s) {
        return findBy(ScheduleItem.COLUMN_SCHEDULE, s.getId());
    }

    public List<ScheduleItem> findByRoutine(Routine r) {
        return findBy(ScheduleItem.COLUMN_ROUTINE, r.getId());
    }

}
