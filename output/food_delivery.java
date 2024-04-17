// ORM class for table 'food_delivery'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Wed Apr 17 21:15:13 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class food_delivery extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.id = (String)value;
      }
    });
    setters.put("delivery_person_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.delivery_person_id = (String)value;
      }
    });
    setters.put("delivery_person_age", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.delivery_person_age = (Integer)value;
      }
    });
    setters.put("delivery_person_ratings", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.delivery_person_ratings = (Float)value;
      }
    });
    setters.put("restaurant_latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.restaurant_latitude = (Float)value;
      }
    });
    setters.put("restaurant_longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.restaurant_longitude = (Float)value;
      }
    });
    setters.put("delivery_location_latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.delivery_location_latitude = (Float)value;
      }
    });
    setters.put("delivery_location_longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.delivery_location_longitude = (Float)value;
      }
    });
    setters.put("type_of_order", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.type_of_order = (String)value;
      }
    });
    setters.put("type_of_vehicle", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.type_of_vehicle = (String)value;
      }
    });
    setters.put("time_taken", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        food_delivery.this.time_taken = (Integer)value;
      }
    });
  }
  public food_delivery() {
    init0();
  }
  private String id;
  public String get_id() {
    return id;
  }
  public void set_id(String id) {
    this.id = id;
  }
  public food_delivery with_id(String id) {
    this.id = id;
    return this;
  }
  private String delivery_person_id;
  public String get_delivery_person_id() {
    return delivery_person_id;
  }
  public void set_delivery_person_id(String delivery_person_id) {
    this.delivery_person_id = delivery_person_id;
  }
  public food_delivery with_delivery_person_id(String delivery_person_id) {
    this.delivery_person_id = delivery_person_id;
    return this;
  }
  private Integer delivery_person_age;
  public Integer get_delivery_person_age() {
    return delivery_person_age;
  }
  public void set_delivery_person_age(Integer delivery_person_age) {
    this.delivery_person_age = delivery_person_age;
  }
  public food_delivery with_delivery_person_age(Integer delivery_person_age) {
    this.delivery_person_age = delivery_person_age;
    return this;
  }
  private Float delivery_person_ratings;
  public Float get_delivery_person_ratings() {
    return delivery_person_ratings;
  }
  public void set_delivery_person_ratings(Float delivery_person_ratings) {
    this.delivery_person_ratings = delivery_person_ratings;
  }
  public food_delivery with_delivery_person_ratings(Float delivery_person_ratings) {
    this.delivery_person_ratings = delivery_person_ratings;
    return this;
  }
  private Float restaurant_latitude;
  public Float get_restaurant_latitude() {
    return restaurant_latitude;
  }
  public void set_restaurant_latitude(Float restaurant_latitude) {
    this.restaurant_latitude = restaurant_latitude;
  }
  public food_delivery with_restaurant_latitude(Float restaurant_latitude) {
    this.restaurant_latitude = restaurant_latitude;
    return this;
  }
  private Float restaurant_longitude;
  public Float get_restaurant_longitude() {
    return restaurant_longitude;
  }
  public void set_restaurant_longitude(Float restaurant_longitude) {
    this.restaurant_longitude = restaurant_longitude;
  }
  public food_delivery with_restaurant_longitude(Float restaurant_longitude) {
    this.restaurant_longitude = restaurant_longitude;
    return this;
  }
  private Float delivery_location_latitude;
  public Float get_delivery_location_latitude() {
    return delivery_location_latitude;
  }
  public void set_delivery_location_latitude(Float delivery_location_latitude) {
    this.delivery_location_latitude = delivery_location_latitude;
  }
  public food_delivery with_delivery_location_latitude(Float delivery_location_latitude) {
    this.delivery_location_latitude = delivery_location_latitude;
    return this;
  }
  private Float delivery_location_longitude;
  public Float get_delivery_location_longitude() {
    return delivery_location_longitude;
  }
  public void set_delivery_location_longitude(Float delivery_location_longitude) {
    this.delivery_location_longitude = delivery_location_longitude;
  }
  public food_delivery with_delivery_location_longitude(Float delivery_location_longitude) {
    this.delivery_location_longitude = delivery_location_longitude;
    return this;
  }
  private String type_of_order;
  public String get_type_of_order() {
    return type_of_order;
  }
  public void set_type_of_order(String type_of_order) {
    this.type_of_order = type_of_order;
  }
  public food_delivery with_type_of_order(String type_of_order) {
    this.type_of_order = type_of_order;
    return this;
  }
  private String type_of_vehicle;
  public String get_type_of_vehicle() {
    return type_of_vehicle;
  }
  public void set_type_of_vehicle(String type_of_vehicle) {
    this.type_of_vehicle = type_of_vehicle;
  }
  public food_delivery with_type_of_vehicle(String type_of_vehicle) {
    this.type_of_vehicle = type_of_vehicle;
    return this;
  }
  private Integer time_taken;
  public Integer get_time_taken() {
    return time_taken;
  }
  public void set_time_taken(Integer time_taken) {
    this.time_taken = time_taken;
  }
  public food_delivery with_time_taken(Integer time_taken) {
    this.time_taken = time_taken;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof food_delivery)) {
      return false;
    }
    food_delivery that = (food_delivery) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.delivery_person_id == null ? that.delivery_person_id == null : this.delivery_person_id.equals(that.delivery_person_id));
    equal = equal && (this.delivery_person_age == null ? that.delivery_person_age == null : this.delivery_person_age.equals(that.delivery_person_age));
    equal = equal && (this.delivery_person_ratings == null ? that.delivery_person_ratings == null : this.delivery_person_ratings.equals(that.delivery_person_ratings));
    equal = equal && (this.restaurant_latitude == null ? that.restaurant_latitude == null : this.restaurant_latitude.equals(that.restaurant_latitude));
    equal = equal && (this.restaurant_longitude == null ? that.restaurant_longitude == null : this.restaurant_longitude.equals(that.restaurant_longitude));
    equal = equal && (this.delivery_location_latitude == null ? that.delivery_location_latitude == null : this.delivery_location_latitude.equals(that.delivery_location_latitude));
    equal = equal && (this.delivery_location_longitude == null ? that.delivery_location_longitude == null : this.delivery_location_longitude.equals(that.delivery_location_longitude));
    equal = equal && (this.type_of_order == null ? that.type_of_order == null : this.type_of_order.equals(that.type_of_order));
    equal = equal && (this.type_of_vehicle == null ? that.type_of_vehicle == null : this.type_of_vehicle.equals(that.type_of_vehicle));
    equal = equal && (this.time_taken == null ? that.time_taken == null : this.time_taken.equals(that.time_taken));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof food_delivery)) {
      return false;
    }
    food_delivery that = (food_delivery) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.delivery_person_id == null ? that.delivery_person_id == null : this.delivery_person_id.equals(that.delivery_person_id));
    equal = equal && (this.delivery_person_age == null ? that.delivery_person_age == null : this.delivery_person_age.equals(that.delivery_person_age));
    equal = equal && (this.delivery_person_ratings == null ? that.delivery_person_ratings == null : this.delivery_person_ratings.equals(that.delivery_person_ratings));
    equal = equal && (this.restaurant_latitude == null ? that.restaurant_latitude == null : this.restaurant_latitude.equals(that.restaurant_latitude));
    equal = equal && (this.restaurant_longitude == null ? that.restaurant_longitude == null : this.restaurant_longitude.equals(that.restaurant_longitude));
    equal = equal && (this.delivery_location_latitude == null ? that.delivery_location_latitude == null : this.delivery_location_latitude.equals(that.delivery_location_latitude));
    equal = equal && (this.delivery_location_longitude == null ? that.delivery_location_longitude == null : this.delivery_location_longitude.equals(that.delivery_location_longitude));
    equal = equal && (this.type_of_order == null ? that.type_of_order == null : this.type_of_order.equals(that.type_of_order));
    equal = equal && (this.type_of_vehicle == null ? that.type_of_vehicle == null : this.type_of_vehicle.equals(that.type_of_vehicle));
    equal = equal && (this.time_taken == null ? that.time_taken == null : this.time_taken.equals(that.time_taken));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readString(1, __dbResults);
    this.delivery_person_id = JdbcWritableBridge.readString(2, __dbResults);
    this.delivery_person_age = JdbcWritableBridge.readInteger(3, __dbResults);
    this.delivery_person_ratings = JdbcWritableBridge.readFloat(4, __dbResults);
    this.restaurant_latitude = JdbcWritableBridge.readFloat(5, __dbResults);
    this.restaurant_longitude = JdbcWritableBridge.readFloat(6, __dbResults);
    this.delivery_location_latitude = JdbcWritableBridge.readFloat(7, __dbResults);
    this.delivery_location_longitude = JdbcWritableBridge.readFloat(8, __dbResults);
    this.type_of_order = JdbcWritableBridge.readString(9, __dbResults);
    this.type_of_vehicle = JdbcWritableBridge.readString(10, __dbResults);
    this.time_taken = JdbcWritableBridge.readInteger(11, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readString(1, __dbResults);
    this.delivery_person_id = JdbcWritableBridge.readString(2, __dbResults);
    this.delivery_person_age = JdbcWritableBridge.readInteger(3, __dbResults);
    this.delivery_person_ratings = JdbcWritableBridge.readFloat(4, __dbResults);
    this.restaurant_latitude = JdbcWritableBridge.readFloat(5, __dbResults);
    this.restaurant_longitude = JdbcWritableBridge.readFloat(6, __dbResults);
    this.delivery_location_latitude = JdbcWritableBridge.readFloat(7, __dbResults);
    this.delivery_location_longitude = JdbcWritableBridge.readFloat(8, __dbResults);
    this.type_of_order = JdbcWritableBridge.readString(9, __dbResults);
    this.type_of_vehicle = JdbcWritableBridge.readString(10, __dbResults);
    this.time_taken = JdbcWritableBridge.readInteger(11, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(delivery_person_id, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(delivery_person_age, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeFloat(delivery_person_ratings, 4 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(restaurant_latitude, 5 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(restaurant_longitude, 6 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(delivery_location_latitude, 7 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(delivery_location_longitude, 8 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeString(type_of_order, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(type_of_vehicle, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(time_taken, 11 + __off, 4, __dbStmt);
    return 11;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(id, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(delivery_person_id, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(delivery_person_age, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeFloat(delivery_person_ratings, 4 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(restaurant_latitude, 5 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(restaurant_longitude, 6 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(delivery_location_latitude, 7 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeFloat(delivery_location_longitude, 8 + __off, 7, __dbStmt);
    JdbcWritableBridge.writeString(type_of_order, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(type_of_vehicle, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(time_taken, 11 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.delivery_person_id = null;
    } else {
    this.delivery_person_id = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.delivery_person_age = null;
    } else {
    this.delivery_person_age = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.delivery_person_ratings = null;
    } else {
    this.delivery_person_ratings = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.restaurant_latitude = null;
    } else {
    this.restaurant_latitude = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.restaurant_longitude = null;
    } else {
    this.restaurant_longitude = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.delivery_location_latitude = null;
    } else {
    this.delivery_location_latitude = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.delivery_location_longitude = null;
    } else {
    this.delivery_location_longitude = Float.valueOf(__dataIn.readFloat());
    }
    if (__dataIn.readBoolean()) { 
        this.type_of_order = null;
    } else {
    this.type_of_order = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.type_of_vehicle = null;
    } else {
    this.type_of_vehicle = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.time_taken = null;
    } else {
    this.time_taken = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, id);
    }
    if (null == this.delivery_person_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, delivery_person_id);
    }
    if (null == this.delivery_person_age) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.delivery_person_age);
    }
    if (null == this.delivery_person_ratings) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.delivery_person_ratings);
    }
    if (null == this.restaurant_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.restaurant_latitude);
    }
    if (null == this.restaurant_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.restaurant_longitude);
    }
    if (null == this.delivery_location_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.delivery_location_latitude);
    }
    if (null == this.delivery_location_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.delivery_location_longitude);
    }
    if (null == this.type_of_order) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, type_of_order);
    }
    if (null == this.type_of_vehicle) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, type_of_vehicle);
    }
    if (null == this.time_taken) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.time_taken);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, id);
    }
    if (null == this.delivery_person_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, delivery_person_id);
    }
    if (null == this.delivery_person_age) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.delivery_person_age);
    }
    if (null == this.delivery_person_ratings) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.delivery_person_ratings);
    }
    if (null == this.restaurant_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.restaurant_latitude);
    }
    if (null == this.restaurant_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.restaurant_longitude);
    }
    if (null == this.delivery_location_latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.delivery_location_latitude);
    }
    if (null == this.delivery_location_longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeFloat(this.delivery_location_longitude);
    }
    if (null == this.type_of_order) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, type_of_order);
    }
    if (null == this.type_of_vehicle) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, type_of_vehicle);
    }
    if (null == this.time_taken) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.time_taken);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_person_id==null?"null":delivery_person_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_person_age==null?"null":"" + delivery_person_age, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_person_ratings==null?"null":"" + delivery_person_ratings, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(restaurant_latitude==null?"null":"" + restaurant_latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(restaurant_longitude==null?"null":"" + restaurant_longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_location_latitude==null?"null":"" + delivery_location_latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_location_longitude==null?"null":"" + delivery_location_longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(type_of_order==null?"null":type_of_order, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(type_of_vehicle==null?"null":type_of_vehicle, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time_taken==null?"null":"" + time_taken, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_person_id==null?"null":delivery_person_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_person_age==null?"null":"" + delivery_person_age, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_person_ratings==null?"null":"" + delivery_person_ratings, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(restaurant_latitude==null?"null":"" + restaurant_latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(restaurant_longitude==null?"null":"" + restaurant_longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_location_latitude==null?"null":"" + delivery_location_latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(delivery_location_longitude==null?"null":"" + delivery_location_longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(type_of_order==null?"null":type_of_order, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(type_of_vehicle==null?"null":type_of_vehicle, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time_taken==null?"null":"" + time_taken, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.id = null; } else {
      this.id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.delivery_person_id = null; } else {
      this.delivery_person_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_person_age = null; } else {
      this.delivery_person_age = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_person_ratings = null; } else {
      this.delivery_person_ratings = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.restaurant_latitude = null; } else {
      this.restaurant_latitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.restaurant_longitude = null; } else {
      this.restaurant_longitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_location_latitude = null; } else {
      this.delivery_location_latitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_location_longitude = null; } else {
      this.delivery_location_longitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.type_of_order = null; } else {
      this.type_of_order = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.type_of_vehicle = null; } else {
      this.type_of_vehicle = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time_taken = null; } else {
      this.time_taken = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.id = null; } else {
      this.id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.delivery_person_id = null; } else {
      this.delivery_person_id = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_person_age = null; } else {
      this.delivery_person_age = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_person_ratings = null; } else {
      this.delivery_person_ratings = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.restaurant_latitude = null; } else {
      this.restaurant_latitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.restaurant_longitude = null; } else {
      this.restaurant_longitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_location_latitude = null; } else {
      this.delivery_location_latitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.delivery_location_longitude = null; } else {
      this.delivery_location_longitude = Float.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.type_of_order = null; } else {
      this.type_of_order = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.type_of_vehicle = null; } else {
      this.type_of_vehicle = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time_taken = null; } else {
      this.time_taken = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    food_delivery o = (food_delivery) super.clone();
    return o;
  }

  public void clone0(food_delivery o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("delivery_person_id", this.delivery_person_id);
    __sqoop$field_map.put("delivery_person_age", this.delivery_person_age);
    __sqoop$field_map.put("delivery_person_ratings", this.delivery_person_ratings);
    __sqoop$field_map.put("restaurant_latitude", this.restaurant_latitude);
    __sqoop$field_map.put("restaurant_longitude", this.restaurant_longitude);
    __sqoop$field_map.put("delivery_location_latitude", this.delivery_location_latitude);
    __sqoop$field_map.put("delivery_location_longitude", this.delivery_location_longitude);
    __sqoop$field_map.put("type_of_order", this.type_of_order);
    __sqoop$field_map.put("type_of_vehicle", this.type_of_vehicle);
    __sqoop$field_map.put("time_taken", this.time_taken);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("delivery_person_id", this.delivery_person_id);
    __sqoop$field_map.put("delivery_person_age", this.delivery_person_age);
    __sqoop$field_map.put("delivery_person_ratings", this.delivery_person_ratings);
    __sqoop$field_map.put("restaurant_latitude", this.restaurant_latitude);
    __sqoop$field_map.put("restaurant_longitude", this.restaurant_longitude);
    __sqoop$field_map.put("delivery_location_latitude", this.delivery_location_latitude);
    __sqoop$field_map.put("delivery_location_longitude", this.delivery_location_longitude);
    __sqoop$field_map.put("type_of_order", this.type_of_order);
    __sqoop$field_map.put("type_of_vehicle", this.type_of_vehicle);
    __sqoop$field_map.put("time_taken", this.time_taken);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
