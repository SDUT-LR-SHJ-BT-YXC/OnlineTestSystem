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
    //因为用到反射需要T的class类
    private Class<T> clazz;
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

    @SuppressWarnings("unchecked")
    /**
     * BaseDAO的构造器，在构造器内解析出泛型T的Class类
     */
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


    /**
     * 获取数据库查询后的某一个字段的值，单行单列。例如获取Name字段的值，或者Count(*)记录的条数
     * @param sql 用于执行的sql语句
     * @param args 填充SQL语句的占位符
     * @return 单行单列的值
     */
    public <E> E getForValue(String sql, Object ... args) throws SQLException {
        return queryRunner.query(sql,new ScalarHandler<E>(),args);
    }


    /**
     * 获取由一组T的对象构成的List
     * @param sql 用于执行的sql语句
     * @param args 填充SQL语句的占位符
     * @return T的对象构成的List
     */
    public List<T> getForList(String sql, Object ... args) throws SQLException{
        System.out.println("getForList");
        return queryRunner.query(sql, new BeanListHandler<T>(clazz,
                new BasicRowProcessor(new GenerousBeanProcessor())), args);
    }



    /**
     * 获取T的实体类对象，该对象与数据库的记录相一致
     * 因为用到反射需要T的class类
     * @param sql 用于执行的sql语句
     * @param args 填充SQL语句的占位符
     * @return T的实体类对象
     */
    public T get(String sql, Object ... args) throws SQLException {
        return queryRunner.query(sql,new BeanHandler<T>(clazz,
                new BasicRowProcessor(new GenerousBeanProcessor())),args);
    }


    /**
     * 该方法封装了，INSERT,DELETE,UPDATE相关的数据库操作
     * @param sql 用于执行的sql语句
     * @param args 填充SQL语句的占位符
     */
    public int update(String sql , Object ... args) throws SQLException {
        int row = queryRunner.update(sql, args);
        if (row == 0) {
            throw new RuntimeException();
        }
        return row;
    }
}
