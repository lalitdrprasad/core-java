package com.study.java8;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class OptionalMethods {

	public static void main(String[] args) {

		System.out.println("Testing...");
		Integer x = 10, y = null;
		String str1 = "First String";
		String str2 = null;

		Optional<Integer> opt1 = Optional.empty();
		Optional<Integer> opt2 = Optional.empty();
		Optional<String> opt3 = Optional.of(str1);
		Optional<String> opt4 = Optional.ofNullable(str2);

		opt1 = Optional.of(x); // Not Null
		opt2 = Optional.ofNullable(y); // Nullable

		// get() method returns java.util.NoSuchElementException if Optional
		// object is empty

		System.out.println(opt1.get());
		System.out.println(opt2.orElse(0)); // If Empty return 0


		// Supplies Object or lambda expression(0 Arg) is passed to orElseGet
		// method's parameter
		Supplier<String> obj = () -> {
			return "Empty";
		};
		String sup = (opt4.orElseGet(obj));
		System.out.println(sup); //

		// Filter On Value "filter method will returns an Optional Object on the
		// basis of condition passed"
		// Calling orElse method over returned Optional object
		System.out.println(opt1.filter(val -> val >= 10).orElse(0));

		// Returns the hash code value of the present value, if any, or 0 (zero)
		// if no value is present.
		System.out.println(opt3.hashCode());
		System.out.println(opt4.hashCode());

		// Check Empty Condition
		System.out.println(opt1.isPresent());
		System.out.println(opt2.isPresent());

		// Take action if not empty Pass the value as Method parameter
		// ifPresent method accepts Consumer object or A Lambda Expression
		Consumer<String> con = (str) -> System.out.println(str.toUpperCase());
		opt3.ifPresent(con);// Object
		opt4.ifPresent(str -> System.out.println(str.toUpperCase()));// Lambda-Expression

		// Map accepts an object of Function or Lambda Expression as parameter,
		// applies the same code on value and returns an Object of Optional. If
		// value is null then it will return an empty object of Optional
		Function<String, String> fun = (str) -> {
			str = str.toUpperCase();
			return str;
		};
		Optional<String> opt5 = opt3.map(fun);
		System.out.println(opt5.get());

	}

}
