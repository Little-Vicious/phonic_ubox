package com.zzxy.ssm.controller.interceptor;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
/**
 * SQL控制台打印优化拦截器
 * @author 王文博
 *
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
	@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class SqlCostInterceptor implements Interceptor {

	private Properties properties;
	
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
		Object parameter = null;
		if(invocation.getArgs().length > 1){
			parameter = invocation.getArgs()[1];
		}
		String sqlId = mappedStatement.getId();
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		Configuration configuration = mappedStatement.getConfiguration();
		Object returnValue = null;
		long start = System.currentTimeMillis();
		returnValue = invocation.proceed();
		long end = System.currentTimeMillis();
		long time = (end-start);
		if(time > 1){
			String sql = getSql(configuration,boundSql,sqlId,time);
			System.err.println(sql);
		}
		return returnValue;
	}

	private String getSql(Configuration configuration, BoundSql boundSql, String sqlId, long time) {
		String sql = showSql(configuration,boundSql);
		StringBuilder str = new StringBuilder(100);
		str.append("sqlId=>[");
		str.append(sqlId);
		str.append("]\n");
		str.append("SQL=>[");
		str.append(sql);
		str.append("]\n");
		str.append("执行耗时=>[");
		str.append(time);
		str.append("ms]\n");
		return str.toString();
	}

	private String showSql(Configuration configuration, BoundSql boundSql) {
		Object parameterObject = boundSql.getParameterObject();
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		String sql = boundSql.getSql().replaceAll("\\s]+", " ");
		if(parameterMappings.size() > 0 && parameterObject != null){
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			if(typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())){
				sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));
			}else {
				MetaObject metaObject = configuration.newMetaObject(parameterObject);
				for(ParameterMapping parameterMapping:parameterMappings){
					String propertyName = parameterMapping.getProperty();
					if(metaObject.hasGetter(propertyName)){
						Object obj = metaObject.getValue(propertyName);
						sql = sql.replaceFirst("\\?", getParameterValue(obj));
					}else if (boundSql.hasAdditionalParameter(propertyName)) {
						Object obj = boundSql.getAdditionalParameter(propertyName);
						sql = sql.replaceFirst("\\?", getParameterValue(obj));
					}
				}
			}
		}
		return sql;
	}

	private String getParameterValue(Object obj) {
		String value =null;
		if(obj instanceof String){
			value = "'"+obj.toString()+"'";
		}else if (obj instanceof Date) {
			DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT,Locale.CHINA);
			value = "'"+formatter.format(obj)+"'";
		}else {
			if(obj != null){
				value = obj.toString();
			}else {
				value = " ";
			}
		}
		return value;
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
