package com.crazybunqnq.test;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

public class FunctionTest {
	@Test
	public void jdk8FunctionTest() {
		// sum[-10,10)
		System.out.println(sumNormal(-10, 10));
		System.out.println(calc(-10,  10, x -> x));
		// sum[-10,10) 绝对值的和
		System.out.println(calc(-10, 10, x -> Math.abs(x)));

		// (op x y)
		System.out.println(calc(2, 3, (x, y) -> String.valueOf(x + y)));
		System.out.println(calc(5.3, 3, (x, y) -> String.valueOf(x + y)));
		System.out.println(calc(2.0f, 3, (x, y) -> String.valueOf(x / y)));
		System.out.println(calc(2.22, 3, (x, y) -> String.valueOf(x - y)));
		System.out.println(calc(2L, 3.22, (x, y) -> String.valueOf(x * y)));
	}

	/**
	 * 计算 a 到 b 之间的和
	 */
	static int sumNormal(int a, int b) {
		int sum = 0;
		for (int i = a; i < b; i++) {
			sum += i;
		}
		return sum;
	}

	/**
	 * 序列求和
	 */
	static int calc(int a, int b, Function<Integer, Integer> function) {
		int ret = 0;
		for (; a < b; a++) {
			ret += function.apply(a);
		}
		return ret;
	}

	/**
	 * @param fArg
	 *            Type of first argument
	 * @param sArg
	 *            Type of second argument
	 * @param op
	 *            operator
	 */
	static <F, S, O extends BiFunction<F, S, String>> String calc(F fArg, S sArg, O op) {
		return op.apply(fArg, sArg);
	}

}
