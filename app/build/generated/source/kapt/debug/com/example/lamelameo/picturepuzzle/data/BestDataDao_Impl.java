package com.example.lamelameo.picturepuzzle.data;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BestDataDao_Impl implements BestDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BestData> __insertionAdapterOfBestData;

  private final EntityDeletionOrUpdateAdapter<BestData> __deletionAdapterOfBestData;

  private final EntityDeletionOrUpdateAdapter<BestData> __updateAdapterOfBestData;

  public BestDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBestData = new EntityInsertionAdapter<BestData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `puzzle_best_data` (`puzzleName`,`moves`,`time`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BestData value) {
        if (value.getPuzzleName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPuzzleName());
        }
        stmt.bindLong(2, value.getMoves());
        stmt.bindLong(3, value.getTime());
      }
    };
    this.__deletionAdapterOfBestData = new EntityDeletionOrUpdateAdapter<BestData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `puzzle_best_data` WHERE `puzzleName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BestData value) {
        if (value.getPuzzleName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPuzzleName());
        }
      }
    };
    this.__updateAdapterOfBestData = new EntityDeletionOrUpdateAdapter<BestData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `puzzle_best_data` SET `puzzleName` = ?,`moves` = ?,`time` = ? WHERE `puzzleName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BestData value) {
        if (value.getPuzzleName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPuzzleName());
        }
        stmt.bindLong(2, value.getMoves());
        stmt.bindLong(3, value.getTime());
        if (value.getPuzzleName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPuzzleName());
        }
      }
    };
  }

  @Override
  public Object newEntry(final BestData entry, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBestData.insert(entry);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final BestData entry, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfBestData.handle(entry);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateEntry(final BestData entry, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBestData.handle(entry);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAll(final Continuation<? super List<BestData>> p0) {
    final String _sql = "SELECT * FROM puzzle_best_data";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<BestData>>() {
      @Override
      public List<BestData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPuzzleName = CursorUtil.getColumnIndexOrThrow(_cursor, "puzzleName");
          final int _cursorIndexOfMoves = CursorUtil.getColumnIndexOrThrow(_cursor, "moves");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final List<BestData> _result = new ArrayList<BestData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BestData _item;
            final String _tmpPuzzleName;
            _tmpPuzzleName = _cursor.getString(_cursorIndexOfPuzzleName);
            final int _tmpMoves;
            _tmpMoves = _cursor.getInt(_cursorIndexOfMoves);
            final int _tmpTime;
            _tmpTime = _cursor.getInt(_cursorIndexOfTime);
            _item = new BestData(_tmpPuzzleName,_tmpMoves,_tmpTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object loadAllBy(final String[] names, final Continuation<? super List<BestData>> p1) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM puzzle_best_data WHERE puzzleName IN (");
    final int _inputSize = names.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : names) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return CoroutinesRoom.execute(__db, false, new Callable<List<BestData>>() {
      @Override
      public List<BestData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPuzzleName = CursorUtil.getColumnIndexOrThrow(_cursor, "puzzleName");
          final int _cursorIndexOfMoves = CursorUtil.getColumnIndexOrThrow(_cursor, "moves");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final List<BestData> _result = new ArrayList<BestData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BestData _item_1;
            final String _tmpPuzzleName;
            _tmpPuzzleName = _cursor.getString(_cursorIndexOfPuzzleName);
            final int _tmpMoves;
            _tmpMoves = _cursor.getInt(_cursorIndexOfMoves);
            final int _tmpTime;
            _tmpTime = _cursor.getInt(_cursorIndexOfTime);
            _item_1 = new BestData(_tmpPuzzleName,_tmpMoves,_tmpTime);
            _result.add(_item_1);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }

  @Override
  public Object findByPuzzle(final String puzzleName, final Continuation<? super BestData> p1) {
    final String _sql = "SELECT * FROM puzzle_best_data WHERE puzzleName is ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (puzzleName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, puzzleName);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<BestData>() {
      @Override
      public BestData call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPuzzleName = CursorUtil.getColumnIndexOrThrow(_cursor, "puzzleName");
          final int _cursorIndexOfMoves = CursorUtil.getColumnIndexOrThrow(_cursor, "moves");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final BestData _result;
          if(_cursor.moveToFirst()) {
            final String _tmpPuzzleName;
            _tmpPuzzleName = _cursor.getString(_cursorIndexOfPuzzleName);
            final int _tmpMoves;
            _tmpMoves = _cursor.getInt(_cursorIndexOfMoves);
            final int _tmpTime;
            _tmpTime = _cursor.getInt(_cursorIndexOfTime);
            _result = new BestData(_tmpPuzzleName,_tmpMoves,_tmpTime);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }
}
