package com.example.zimuquan.circleofletters.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Object Utils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2018-9-11
 */
public class ObjectUtils {
	/**
	 * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map) obj).isEmpty();

		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isNullOrEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		return false;
	}

	/**
	 * compare two object
	 * 
	 * @param actual
	 * @param expected
	 * @return <ul>
	 *         <li>if both are null, return true</li>
	 *         <li>return actual.{@link Object#equals(Object)}</li>
	 *         </ul>
	 */
	public static boolean isEquals(Object actual, Object expected) {
		return actual == expected
				|| (actual == null ? expected == null : actual.equals(expected));
	}

	/**
	 * convert long array to Long array
	 * 
	 * @param source
	 * @return
	 */
	public static Long[] transformLongArray(long[] source) {
		Long[] destin = new Long[source.length];
		for (int i = 0; i < source.length; i++) {
			destin[i] = source[i];
		}
		return destin;
	}

	/**
	 * convert Long array to long array
	 * 
	 * @param source
	 * @return
	 */
	public static long[] transformLongArray(Long[] source) {
		long[] destin = new long[source.length];
		for (int i = 0; i < source.length; i++) {
			destin[i] = source[i];
		}
		return destin;
	}

	/**
	 * convert int array to Integer array
	 * 
	 * @param source
	 * @return
	 */
	public static Integer[] transformIntArray(int[] source) {
		Integer[] destin = new Integer[source.length];
		for (int i = 0; i < source.length; i++) {
			destin[i] = source[i];
		}
		return destin;
	}

	/**
	 * convert Integer array to int array
	 * 
	 * @param source
	 * @return
	 */
	public static int[] transformIntArray(Integer[] source) {
		int[] destin = new int[source.length];
		for (int i = 0; i < source.length; i++) {
			destin[i] = source[i];
		}
		return destin;
	}

	/**
	 * compare two object
	 * <ul>
	 * <strong>About result</strong>
	 * <li>if v1 > v2, return 1</li>
	 * <li>if v1 = v2, return 0</li>
	 * <li>if v1 < v2, return -1</li>
	 * </ul>
	 * <ul>
	 * <strong>About rule</strong>
	 * <li>if v1 is null, v2 is null, then return 0</li>
	 * <li>if v1 is null, v2 is not null, then return -1</li>
	 * <li>if v1 is not null, v2 is null, then return 1</li>
	 * <li>return v1.{@link Comparable#compareTo(Object)}</li>
	 * </ul>
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <V> int compare(V v1, V v2) {
		return v1 == null ? (v2 == null ? 0 : -1) : (v2 == null ? 1
				: ((Comparable) v1).compareTo(v2));
	}
}
