package org.infosec.ismp.manager.db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.util.Assert;

/**
 * @author guoxianwei
 * @date 2010-12-13 下午05:42:08
 * 
 *    由任务节点对象构建任务参数信息
 *    
 */
public final class ParamsBuilder {

	private static final ParamsBuilder m_instance = new ParamsBuilder();

	// 默认私有构造函数
	private ParamsBuilder() {

	}

	/**
	 * 返回一个有传入对象的字段构造的参数集合类 其中该对象父类的字段不包括在内。
	 */
	public Parms buildParams(Object obj) {
		Assert.notNull(obj, "the class must not be null");
		Class<?> clazz = obj.getClass();
		Field fields[] = clazz.getDeclaredFields();
		Parms params = new Parms();
		log().trace(clazz.getName() + "{");
		if (fields != null) {
			for (Field field : fields) {
				Method getterMethod = getterMethod(clazz, field);
				Object filedValue = null;
				try {
					filedValue = getterMethod.invoke(obj, new Object[] {});

				} catch (Exception e) {
					log().debug("exception occurred during get fieldvalue", e);
				}

				String fieldName = field.getName();
				fieldName = removePrefix(fieldName);
				log()
						.trace(
								"[name:" + fieldName + " value:" + filedValue
										+ "]");
				Value value = new Value();
				value.setContent(String.valueOf(filedValue));
				Parm parm = new ParamBuilder().parmName(fieldName).value(value)
						.build();
				params.addParm(parm);
			}
		}
		log().trace("}");
		return params;
	}

	/**
	 * 获得field的getter函数名称.
	 */
	private String getterName(Class<?> fieldType, String fieldName) {
		Assert.notNull(fieldType, "Type required");
		Assert.hasText(fieldName, "FieldName required");
		fieldName = removePrefix(fieldName);
		log()
				.info(
						"filedType of [" + fieldName + "] is "
								+ fieldType.getName());
		if (fieldType.getName().equals("boolean")) {
			return "is" + StringUtils.capitalize(fieldName);
		} else {
			return "get" + StringUtils.capitalize(fieldName);
		}
	}

	private String removePrefix(String str) {
		return StringUtils.removeStartIgnoreCase(str, "m_");
	}

	/**
	 * 获得field的getter函数,如果找不到该方法,返回null.
	 */
	private Method getterMethod(Class<?> clazz, Field field) {
		try {
			return clazz
					.getMethod(getterName(field.getType(), field.getName()));
		} catch (NoSuchMethodException e) {
			log().debug(
					"filed：" + field.getName()
							+ " construct getter method error occurred", e);
			// logger.error(e.getMessage(), e);
		}
		return null;
	}

	private static class ParamBuilder {

		private String m_paramName;
		private Value m_vaule;

		public Parm build() {
			Parm _p = new Parm();
			_p.setParmName(m_paramName);
			_p.setValue(m_vaule);
			return _p;
		}

		public ParamBuilder value(final Value vaule) {
			m_vaule = vaule;
			return this;
		}

		public ParamBuilder parmName(final String paraname) {
			m_paramName = paraname;
			return this;
		}

	}

	public static ParamsBuilder getInstance() {
		return m_instance;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
