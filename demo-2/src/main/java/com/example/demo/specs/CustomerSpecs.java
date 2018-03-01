package com.example.demo.specs;


import static com.google.common.collect.Iterables.toArray;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

public class CustomerSpecs {

	@SuppressWarnings("unchecked")
	public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) { //1

		final Class<T> type = (Class<T>) example.getClass();//2 取得当前实体类对象类的类型

		return new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>(); //3 新建 Predicate列表存储构造的查询条件
				
				EntityType<T> entity = entityManager.getMetamodel().entity(type);//4 获取实体类的EntityType,可以从EntityType获取实体类的属性
				
				for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {//5 对实体类的所有属性做循环
					Object attrValue = getValue(example, attr); //6 获取实体类对象某一个属性的值
					if (attrValue != null) {
						if (attr.getJavaType() == String.class) { //7 当前属性值为字符类型的时候
							if (!StringUtils.isEmpty(attrValue)) { //8 当前字符不为空的情况
								predicates.add(cb.like(root.get(attribute(entity, attr.getName(), String.class)),
										pattern((String) attrValue))); //9 构造当前属性like(前后%)属性值查询条件，并添加到条件列表中
							}
						} else {
							predicates.add(cb.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())),
									attrValue)); //10 其余情况下，构造属性和属性值equal查询条件，并添加到条件列表中
						}
					}

				}
				return predicates.isEmpty() ? cb.conjunction() : cb.and(toArray(predicates, Predicate.class));//11
			}

			/**
			 * 12
			 */
			@SuppressWarnings("hiding")
			private <T> Object getValue(T example, Attribute<T, ?> attr) {
				return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
			}
			
			/**
			 * 13
			 */
			@SuppressWarnings("hiding")
			private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName,
					Class<E> fieldClass) { 
				return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
			}

		};

	}
	
	/**
	 * 14
	 */
	static private String pattern(String str) {
		return "%" + str + "%";
	}

}
