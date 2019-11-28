package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.utils.DataSourceUtils;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BaseDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 21:17
 * @Version 1.0
 **/
public class BaseDAO<T> {
    private Class<T> clazz;
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

    @SuppressWarnings("unchecked")
    public BaseDAO() {
        Type superClass = this.getClass().getGenericSuperclass();
        if( superClass instanceof ParameterizedType ) {
            ParameterizedType parameterizedType = (ParameterizedType)superClass;
            Type [] typeArgs = parameterizedType.getActualTypeArguments();
            if( typeArgs != null && typeArgs.length > 0) {
                if( typeArgs[0] instanceof Class) {
                    clazz = (Class<T>)typeArgs[0];
                }
            }
        }
    }

    public <E> E getForValue(String sql, Object ... args) throws SQLException {
        return queryRunner.query(sql,new ScalarHandler<E>(),args);
    }

    public List<T> getForList(String sql, Object ... args) throws SQLException{
        System.out.println("getForList");
        return queryRunner.query(sql, new BeanListHandler<T>(clazz,
                new BasicRowProcessor(new GenerousBeanProcessor())), args);

    }

    public T get(String sql, Object ... args) throws SQLException {
        return queryRunner.query(sql,new BeanHandler<T>(clazz,
                new BasicRowProcessor(new GenerousBeanProcessor())),args);
    }

    public int update(String sql , Object ... args) throws SQLException {
        int row = queryRunner.update(sql, args);
        if (row == 0) {
            throw new RuntimeException();
        }
        return row;
    }
}
