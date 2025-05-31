package com.study.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.Function0Arg;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class StreamDemo {
	public static <R> void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();

		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		List<String> productPriceList2 = productsList.stream().filter(p -> p.price > 25000).map(p -> p.name)
				.collect(Collectors.toList());
		System.out.println(productPriceList2);

		productsList.stream().filter(product -> product.price <= 30000)
				.forEach(product -> System.out.println(product.name));

		System.out.println(productsList.stream().max((o1, o2) -> o1.price > o2.price ? 1 : -1).get().price);

		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * t;
			}
		};
		list.stream().filter(e -> e % 2 == 0).map(fn).forEach(System.out::println);
		// list.stream().filter(e -> e % 2 == 0).map(t -> t *
		// t).forEach(System.out::println);

		System.out.println("Min : " + list.stream().min((x, y) -> x > y ? 1 : -1).get());
		System.out.println("Min : " + list.stream().max((x, y) -> x.compareTo(y)).get());

	}
}