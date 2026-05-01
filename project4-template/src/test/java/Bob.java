import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clojure.java.api.Clojure;

// Bob made these tests

class Bob {
	@BeforeAll
	static void requires() {
        var require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("Lauren"));
	}

	@Test
	void testLaurenThirdClojure() {
		var third = Clojure.var("Lauren", "third");
		var list = List.of("A", "B", "C", "D", "E");
		assertEquals("C", third.invoke(list));
	}

	@Test
	void testEthanThirdJava() {
		var list = List.of("A", "B", "C", "D", "E");
		assertEquals("C", Ethan.third(list));
	}
}
