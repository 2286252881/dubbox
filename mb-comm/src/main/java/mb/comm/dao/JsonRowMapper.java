package mb.comm.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class JsonRowMapper implements RowMapper<JSONObject> {

    /**
     * <B>方法名称：</B>映射行数据<BR>
     * <B>概要说明：</B><BR>
     * 
     * @param rs 结果集
     * @param row 行号
     * @return JSONObject 数据
     * @throws SQLException SQL异常错误
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
     *      int)
     */
    public JSONObject mapRow(ResultSet rs, int row) throws SQLException {
        String key = null;
        Object obj = null;
        JSONObject json = new JSONObject();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        for (int i = 1; i <= count; i++) {
            key = JdbcUtils.lookupColumnName(rsmd, i);
            obj = JdbcUtils.getResultSetValue(rs, i);
            try {
                json.put(key, obj);
            }
            catch (JSONException e) {
            }
        }
        return json;
    }
}
