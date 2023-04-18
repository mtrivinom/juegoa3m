package com.example.lamelameo.picturepuzzle.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BestsDatabase_Impl extends BestsDatabase {
  private volatile BestDataDao _bestDataDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `puzzle_best_data` (`puzzleName` TEXT NOT NULL, `moves` INTEGER NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`puzzleName`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '61ddfc38288d570dc4eba369cfd2371a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `puzzle_best_data`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPuzzleBestData = new HashMap<String, TableInfo.Column>(3);
        _columnsPuzzleBestData.put("puzzleName", new TableInfo.Column("puzzleName", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPuzzleBestData.put("moves", new TableInfo.Column("moves", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPuzzleBestData.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPuzzleBestData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPuzzleBestData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPuzzleBestData = new TableInfo("puzzle_best_data", _columnsPuzzleBestData, _foreignKeysPuzzleBestData, _indicesPuzzleBestData);
        final TableInfo _existingPuzzleBestData = TableInfo.read(_db, "puzzle_best_data");
        if (! _infoPuzzleBestData.equals(_existingPuzzleBestData)) {
          return new RoomOpenHelper.ValidationResult(false, "puzzle_best_data(com.example.lamelameo.picturepuzzle.data.BestData).\n"
                  + " Expected:\n" + _infoPuzzleBestData + "\n"
                  + " Found:\n" + _existingPuzzleBestData);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "61ddfc38288d570dc4eba369cfd2371a", "79ed26312e8f1b3f9ad4c24a95f666f9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "puzzle_best_data");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `puzzle_best_data`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BestDataDao getBestDao() {
    if (_bestDataDao != null) {
      return _bestDataDao;
    } else {
      synchronized(this) {
        if(_bestDataDao == null) {
          _bestDataDao = new BestDataDao_Impl(this);
        }
        return _bestDataDao;
      }
    }
  }
}
